package ir.amin.springcore5.aop.aspect;

import java.io.Serializable;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExecutionTraceAspect {

	/*
	 * must not include Aspect Classes
	 */
	@Pointcut("execution(* ir.amin.springcore5.aop.target.*.doAWork(..))")
	private void aMethod() {
	}

	@Around("aMethod()")
	public Object trace(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		String signature = pjp.getSignature().toString();
		Object retVal = pjp.proceed(args);
		System.out.println("AOP 1-ExecutionTraceAspect: Method '" + signature + "' was called with next arguments " + Arrays.toString(args));
		return retVal;
	}
	
//
//	@AfterReturning(pointcut="execution(* doAWork(..))", returning="returnString")
//	public void doSomeWorkReturningAdvice(String returnString){
//		System.out.println("doSomeWorkReturningAdvice executed. Returned String="+returnString);
//	}

	
	
//	@AfterThrowing(pointcut = "args(ir.amin.springcore5.aop.AOPSampleDTPO)" , throwing = "error")
	@AfterThrowing(pointcut = "within(ir.amin.springcore5.aop.target.TracibleService)" , throwing = "error")
	public void logExceptions(JoinPoint joinPoint , Throwable error){
		System.out.println("Exception thrown in AOPSampleDTPO Method="+joinPoint.toString());
		System.out.println("Method Signature: "  + joinPoint.getSignature());  
		System.out.println("Exception: "+error);  
	}
	
	
}
