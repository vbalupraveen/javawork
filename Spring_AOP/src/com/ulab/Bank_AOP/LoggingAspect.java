package com.ulab.Bank_AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	//@Around("aroundPrintAccoNo()")
	@Around("@annotation(com.ulab.Bank_AOP.Loggable)")
	public Object aroundLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint){
		Object returnObj=null;
		try {
			System.out.println("Before PrintAccoNo()");
			returnObj=proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			System.out.println("Exception caught in PrintAccoNo()");
		}
		System.out.println("After PrintAccoNo()");
		System.out.println(returnObj.toString()+" Printed by Logging Aspect");
		return returnObj;
	}
@Pointcut("execution(* *com.ulab.Bank_AOP.Savings.printAccoNo(..))")
public void aroundPrintAccoNo(){}

}
