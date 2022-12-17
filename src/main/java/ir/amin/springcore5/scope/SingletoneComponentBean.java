package ir.amin.springcore5.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ir.amin.springcore5.Samples;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletoneComponentBean {
	
	public SingletoneComponentBean() {
		System.out.println(Samples.LIFE_CYCLE_5 +"- New Instance SingletoneBean Constructor called . SingletoneBean is similar Singletone in JEE");
	}
	

}
