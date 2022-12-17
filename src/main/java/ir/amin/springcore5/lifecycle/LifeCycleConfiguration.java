package ir.amin.springcore5.lifecycle;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ir.amin.springcore5.Samples;
import ir.amin.springcore5.scope.RequestComponentBean;
import ir.amin.springcore5.scope.RequestPOJOBean;

@Configuration
public class LifeCycleConfiguration {

	@Bean(initMethod = "init", destroyMethod = "destroyedMethod")
	public SimplePOJO getSimplePOJO() {
		System.out.println(Samples.LIFE_CYCLE_6 + "- SimplePOJO initilized in LifeCycleConfiguration");
		return new SimplePOJO();
	}

	/*
	 * you can not autowire or inject bean with SCOPE_REQUEST (RequestPOJOBean) without manual initialization in @Configuration 
	 */
	@Bean
	public RequestPOJOBean getRequestPOJOBean() {
		System.out.println(Samples.LIFE_CYCLE_4 + "- RequestPOJOBean initilized in LifeCycleConfiguration");
		return new RequestPOJOBean();
	}
	

	/*
	 * you can not autowire or inject bean with SCOPE_REQUEST (RequestPOJOBean) without manual initialization in @Configuration 
	 */
	@Bean
	public RequestComponentBean getRequestComponentBean() {
		System.out.println(Samples.LIFE_CYCLE_0 + "- RequestComponentBean initilized in LifeCycleConfiguration");
		return new RequestComponentBean();
	}
	
	@Bean
	public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
		return new BeanFactoryPostProcessorSample();
	}
	
//	@Bean
//	public BeanPostProcessorSample customBeanPostProcessor() {
//		return new BeanPostProcessorSample();
//	}
	
}
