package ir.amin.springcore5.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ir.amin.springcore5.aop.aspect.ExecutionTraceAspect;

@Configuration
@EnableAspectJAutoProxy
public class AOPbyAspectJImplementationConfiguration {

	@Bean
	public ExecutionTraceAspect executionTraceAspect() { return new ExecutionTraceAspect();}
	
}
