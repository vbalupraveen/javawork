package com.ulab.BankAOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	/*---------------@Before Pointcuts---------------*/
	@Before("allCheckings()")
	public void firstLoggingAdvice(JoinPoint jointPoint){
	System.out.println(jointPoint.toLongString());
	Checkings checkings= (Checkings)jointPoint.getTarget();
	checkings.setAccno(465389927);
}
@Before("args(name)")
public void callBeforeTargetMethodWithArg(String name){
	System.out.println("This is method to be executed before method with String args called in main---"+name);
}
/*@Before("allGetters() && allCheckings()")
public void secondLoggingAdvice(){
System.out.println("This is Second Logging Message for all Getters");
}
@Pointcut("execution(* *get*(..))")
public void allGetters(){}*/

@Pointcut("within(com.ulab.BankAOP.Checkings)")
public void allCheckings(){}
/*---------------@After Pointcuts---------------*/
@After("args(name)")
public void callAfterTargetMethodWithArg(String name){
	System.out.println("This is method to be executed after method with String args called in main---"+name);
}
@AfterReturning(pointcut="args(name)",returning="returnVar")
public void callAfterReturnTargetMethodWithArg(String name,String returnVar){
	System.out.println(returnVar);
}
@AfterThrowing(pointcut="args(name)",throwing="ex")
public void callWhenExceptionThrownByTarget(String name,Exception ex){
	System.out.println("The exception is: "+ex);
}
}
