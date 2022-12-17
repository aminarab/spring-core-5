package ir.amin.springcore5.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import ir.amin.springcore5.Samples;

@Configuration
public class CustomBeanFactoryAware implements BeanFactoryAware {

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(Samples.LIFE_CYCLE_X + "- CustomBeanFactoryAware hashcode : " + beanFactory.hashCode() + " in CustomBeanFactoryAware");
		
	}

}
