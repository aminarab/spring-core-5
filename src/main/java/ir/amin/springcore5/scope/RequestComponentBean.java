package ir.amin.springcore5.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import ir.amin.springcore5.Samples;


@Component
/*
 * you can not autowire or inject bean with SCOPE_REQUEST without manual initialization in @Configuration (LifeCycleConfiguration) 
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class RequestComponentBean {
	
	public RequestComponentBean() {
		System.out.println(Samples.LIFE_CYCLE_1 + "- New Instance RequestComponentBean Constructor called . RequestComponentBean instance pooled similar Stateless in JEE");
	}
	
	public void doSomeWork() {
		System.out.println("Thread name in RequestComponentBean " + Thread.currentThread().getName());
	}
	
	
}
