package ir.amin.springcore5.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import ir.amin.springcore5.Samples;

/*
 * you can not autowire or inject bean with SCOPE_REQUEST without manual initialization in @Configuration (LifeCycleConfiguration) 
 */
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class RequestPOJOBean {
	
	public RequestPOJOBean() {
		System.out.println(Samples.LIFE_CYCLE_4 +"- New Instance RequestPOJOBean Constructor called . RequestPOJOBean instance pooled similar Stateless in JEE");
	}
	
	public void doSomeWork() {
		System.out.println("Thread name in RequestPOJOBean " + Thread.currentThread().getName());
	}
	
	
}
