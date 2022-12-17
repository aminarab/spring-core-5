package ir.amin.springcore5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import ir.amin.springcore5.aop.AOPSampleDTPO;
import ir.amin.springcore5.aop.target.TracibleService;
import ir.amin.springcore5.concurrency.impls.ParentThreadImplByJavaXTransactional;
import ir.amin.springcore5.concurrency.impls.ParentThreadImplBySpringTransactional;
import ir.amin.springcore5.data.jpa.employeesample.Employee;
import ir.amin.springcore5.data.jpa.employeesample.EmployeeRepository;
import ir.amin.springcore5.lifecycle.ConstructorInjectionSample;
import ir.amin.springcore5.lifecycle.SimpleComponent;
import ir.amin.springcore5.lifecycle.SimplePOJO;
import ir.amin.springcore5.scope.PrototypeComponentBean;
import ir.amin.springcore5.scope.SingletoneComponentBean;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "ir.amin.springcore5")
public class SpringCore5Application {

	public static void main(String[] args) {
		System.out.println("******* Initialization Phase*******");
		ConfigurableApplicationContext context = SpringApplication.run(SpringCore5Application.class, args);
		System.out.println("******* Use Phase*******");
//		lifeCycleSample(context);		
//		scopesSample(context);
//		aopSample(context);
//		transactionSample(context);
		
		System.out.println("--------------------------------------End Servicing---------------------------------------------------");
		
	}

	private static void lifeCycleSample(ConfigurableApplicationContext context) {
		System.out.println(Samples.LIFE_CYCLE_7 +"- Bean Factory initilization is done and ApplicationContext is Read To Use.");
		System.out.println("--------------------------------------Start Servicing---------------------------------------------------");
		
		System.out.println(Samples.LIFE_CYCLE_8 + "- BeanFactoryPostProcessorSampleBean hashcode : " + context.getBean("BeanFactoryPostProcessorSampleBean").hashCode() + " in main(String[] args)");
		
		System.out.println(Samples.LIFE_CYCLE_9 + "- ConstructorInjectionSample.doSomeWork() : ");
		context.getBean(ConstructorInjectionSample.class).doSomeWork();
	}

	private static void transactionSample(ConfigurableApplicationContext context) {
		System.out.println("ParentThreadImplByJavaXTransactional : ");
		ParentThreadImplByJavaXTransactional parentThreadImplByJavaxTransactional = context.getBean(ParentThreadImplByJavaXTransactional.class);
		parentThreadImplByJavaxTransactional.asynchronousPreparedMessage(2l);
		parentThreadImplByJavaxTransactional.preparedMessage(1l);

		System.out.println("ParentThreadImplBySpringTransactional : ");
		ParentThreadImplBySpringTransactional parentThreadImplBySpringTransactional = context.getBean(ParentThreadImplBySpringTransactional.class);
		parentThreadImplBySpringTransactional.asynchronousPreparedMessage(2l);
		parentThreadImplBySpringTransactional.preparedMessage(1l);
	}

	private static void aopSample(ConfigurableApplicationContext context) {
		context.getBean(TracibleService.class).doAWork("doAWork");
		AOPSampleDTPO aopSampleDTPO = new AOPSampleDTPO();
		aopSampleDTPO.setNeedToException(true);
		context.getBean(TracibleService.class).doBWork("doBWork", aopSampleDTPO);
	}

	private static void scopesSample(ConfigurableApplicationContext context) {

		System.out.println();		
		System.out.println("SingletoneBean hashcode in first referencing (get form ApplicationContext) : " + context.getBean(SingletoneComponentBean.class).hashCode());
		System.out.println("SingletoneBean hashcode in second referencing (get form ApplicationContext) : " +context.getBean(SingletoneComponentBean.class).hashCode());
		System.out.println("SSingletoneBean hashcode in third referencing (get form ApplicationContext) : " +context.getBean(SingletoneComponentBean.class).hashCode());
		
		System.out.println("Scope 1- all Singletone instance gotted from Application Context has same hash code");
		System.out.println();
		
		System.out.println("Simple Component hashcode in first referencing (get form ApplicationContext) : " + context.getBean(SimpleComponent.class).hashCode());
		System.out.println("Simple Component hashcode in second referencing (get form ApplicationContext) : " + context.getBean(SimpleComponent.class).hashCode());
		System.out.println("Simple Component hashcode in third referencing (get form ApplicationContext) : " + context.getBean(SimpleComponent.class).hashCode());

		System.out.println("Scope 2- as result SimpleComponent instantiate by Singletone Scope because all hash codes is same");
		System.out.println();
		
		System.out.println("Simple POJO hashcode in first referencing (get form ApplicationContext) : " + context.getBean(SimplePOJO.class).hashCode());
		System.out.println("Simple POJO hashcode in second referencing (get form ApplicationContext) : " + context.getBean(SimplePOJO.class).hashCode());
		System.out.println("Simple POJO hashcode in third referencing (get form ApplicationContext) : " + context.getBean(SimplePOJO.class).hashCode());

		System.out.println("Scope 3- as result SimplePOJO instantiate by Singletone Scope because all hash codes is same");
		System.out.println();
		
		System.out.println("PrototypeComponentBean hashcode in first referencing (get form ApplicationContext) : " +context.getBean(PrototypeComponentBean.class).hashCode());
		System.out.println("PrototypeComponentBean hashcode in first referencing (get form ApplicationContext) : " +context.getBean(PrototypeComponentBean.class).hashCode());
		System.out.println("PrototypeComponentBean hashcode in first referencing (get form ApplicationContext) : " +context.getBean(PrototypeComponentBean.class).hashCode());

		System.out.println("Scope 4- as result PrototypeBean is pooled because hash codes is different");
		
		callGetRequestBeans();
		System.out.println("Scope 5");
		
		System.out.println();
		
		
		System.out.println("******* Desturction Phase*******");
		context.close();
	}

	private static void callGetRequestBeans() {
		final String uri = "http://localhost:8080/scopes/requestBeans";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    System.out.println(result);
	}

	@Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            repository.save(new Employee("A Guide to the Bodhisattva Way of Life"));
            repository.save(new Employee("The Life-Changing Magic of Tidying Up"));
            repository.save(new Employee("Refactoring: Improving the Design of Existing Code"));
        };
    }
	
}
