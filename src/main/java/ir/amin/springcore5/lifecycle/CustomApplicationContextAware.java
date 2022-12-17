package ir.amin.springcore5.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import ir.amin.springcore5.Samples;

@Configuration
public class CustomApplicationContextAware implements ApplicationContextAware{

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(Samples.LIFE_CYCLE_X + "- BeanFactoryPostProcessorSampleBean hashcode : " + applicationContext.getBean("BeanFactoryPostProcessorSampleBean").hashCode() + " in CustomApplicationContextAware");
		
	}

}