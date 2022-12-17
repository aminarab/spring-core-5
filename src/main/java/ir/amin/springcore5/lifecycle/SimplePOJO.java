package ir.amin.springcore5.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;

import ir.amin.springcore5.Samples;

public class SimplePOJO implements InitializingBean {
	
	public SimplePOJO() {
		System.out.println(Samples.LIFE_CYCLE_6 + ".1- SimplePOJO Constructor called . SimplePOJO is similar Singletone in JEE");
	}

	@PostConstruct
	public void init() {
		System.out.println(Samples.LIFE_CYCLE_6 + ".2- SimplePOJO initialized by @PostConstruct (init-method)");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(Samples.LIFE_CYCLE_6 + ".3- SimplePOJO afterPropertiesSet called");
	}

	@PreDestroy
	public void destroyedMethod() {
		System.out.println(Samples.LIFE_CYCLE_6 + ".4- SimplePOJO destroyed by @PreDestroy (destroy-method)");
	}

}
