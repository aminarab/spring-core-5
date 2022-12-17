package ir.amin.springcore5.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorSample implements BeanPostProcessor {
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println();
		System.out.println("------------Called BeanPostProcessorSample.postProcessBeforeInitialization() for :\"" + beanName+"---------------");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("------------Called BeanPostProcessorSample.postProcessAfterInitialization() for :\"" + beanName+"---------------");
		System.out.println();
		return bean;
	}
}
