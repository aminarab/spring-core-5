package ir.amin.springcore5.lifecycle;

import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionSample {

	private SimpleComponent simpleComponent;

	public ConstructorInjectionSample(SimpleComponent simpleComponent) {
		this.simpleComponent = simpleComponent;
	}
		
	public SimpleComponent getSimpleComponent() {
		return simpleComponent;
	}

	
	public void setSimpleComponent(SimpleComponent simpleComponent) {
		this.simpleComponent = simpleComponent;
	}
	

	public void doSomeWork() {
		System.out.println( "I call SimpleComponent.doSomework()");
		simpleComponent.doSomeWork();
	}
	
	
}
