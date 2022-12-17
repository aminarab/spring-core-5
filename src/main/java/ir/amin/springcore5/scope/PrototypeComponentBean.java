package ir.amin.springcore5.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ir.amin.springcore5.Samples;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeComponentBean {
	
	public PrototypeComponentBean() {
		System.out.println(Samples.LIFE_CYCLE_9 + "- New Instance PrototypeComponentBean Constructor called . PrototypeComponentBean instance pooled similar Stateless in JEE");
	}
	

}
