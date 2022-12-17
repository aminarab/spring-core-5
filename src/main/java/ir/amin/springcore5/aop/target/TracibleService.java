package ir.amin.springcore5.aop.target;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import ir.amin.springcore5.aop.AOPSampleDTPO;

@Component
public class TracibleService {

	public String doAWork(Serializable param) {
		System.out.println(param + " in TracibleService");
		return "from insdie method to aspect";
	}
	
	public String doBWork(String param , AOPSampleDTPO aopSampleDTPO) {
		System.out.println(param + " in TracibleService");
		if(aopSampleDTPO.getNeedToException()) {
			throw new RuntimeException(aopSampleDTPO.toString());
		}
		return "from insdie method to aspect";
	}
	
}
