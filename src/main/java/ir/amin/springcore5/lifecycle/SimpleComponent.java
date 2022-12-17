package ir.amin.springcore5.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import ir.amin.springcore5.Samples;

@Component
public class SimpleComponent implements InitializingBean {

	public SimpleComponent() {
		System.out.println(Samples.LIFE_CYCLE_2 + ".1- SimpleComponent Constructor called");
	}
	
	@PostConstruct
	public void init() {
		System.out.println(Samples.LIFE_CYCLE_2 + ".2- SimpleComponent initialized by @PostConstruct (init-method)");
	}
		
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(Samples.LIFE_CYCLE_2 + ".3- SimpleComponent afterPropertiesSet called");
	}
	
	@PreDestroy
	public void destroyed() {
		System.out.println(Samples.LIFE_CYCLE_2 + ".4- SimpleComponent destroyed by @PreDestroy (destroy-method)");
	}

	public void doSomeWork() {
		System.out.println( "I do some work in SimpleComponent");
	}
}
