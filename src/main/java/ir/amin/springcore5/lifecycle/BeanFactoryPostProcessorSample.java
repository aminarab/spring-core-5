package ir.amin.springcore5.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;

public class BeanFactoryPostProcessorSample implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("------------Called BeanFactoryPostProcessorSample.postProcessBeanFactory() for define :\"BeanFactoryPostProcessorSampleBean\" by " + beanFactory+"---------------");
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
		registry.registerBeanDefinition("BeanFactoryPostProcessorSampleBean", BeanDefinitionBuilder.genericBeanDefinition(String.class)
				.addConstructorArgValue("This is BeanFactoryPostProcessorBean").getBeanDefinition());
		
	}

}
