package com.employeeManagement.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
Examples of cross-cutting concerns:
Logging
Security
Transaction management
Auditing,
Caching
Internationalization
Error detection and correction
Memory management
Performance monitoring
Synchronization
 
*/

//@Aspect
//@Component
public class LoggingAspectExample {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	// pointcut will apply for all methods starts with get and having zero or more
	// args
	@Pointcut("execution(* * * get*(..))") // wildcard
	public void allTheGetters() {
	}

	// pointcut for will apply for all the methods of EmployeeController class
	@Pointcut("within(com.employeeManagement.demo.controller.EmployeeController)")
	public void applyAllMethodsOfEmployeeController() {
	}

	// pointcut for will apply for all the method of controller package or its sub
	// package
	@Pointcut("within(com.employeeManagement.demo.controller..*)")
	public void applyAllMethodsUnderControllerAndItsSubPackages() {
	}

	// pointcutt for all methods who takes zero or more args
	@Pointcut("args(..)")
	public void appliedOnArgs() {
	}

	// pointcutt for all methods who takes one staring as args
	@Pointcut("args(String)")
	public void appliedOnStringArgs() {
	}

	// joinpoint means all the possible places in your code where you applied advice
	// before advice will call before method execution
	@Before("execution(within(com.employeeManagement.demo.controller.EmployeeController))")
	public void beforeAdvice(JoinPoint joinPoint) {

		// get the method name on which advice performed
		String methodDetails = joinPoint.toString();

		// getTarget() gives us the object of whos method was called and that method
		// triggered the advice.
		joinPoint.getTarget();
	}

	@Before("appliedOnStringArgs()")
	public void secondBeforeAdvice() {

	}

	@Before("args(name)")
	public void secondBeforeAdviceDuplicate(String name) {

	}

	// after advice : it executes after the method has run, no matter the method
	// completed successfully or not
	// advice will call for common of this two different pointcuts
	@After("applyAllMethodsOfEmployeeController() && allTheGetters()")
	public void afterAdvice() {

	}

	// this advice run only if the target method execute successfully and returns.
	// if any exception occurred during the execution of the method then the advice
	// will not get executed
	@AfterReturning(pointcut = "args(name)", returning = "returnString")
	public void afterReturningAdvice(String name, String returnString) {

	}

	// this advice will execute if an exception occurs during execution of method.
	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void afterThrowingAdvice(String name, RuntimeException ex) {

	}

	// this advice will called around a method execution.
	// around advice : the actual target method happens when we called
	// proceedingJoinPoint.proceed();
	@Around("allTheGetters()")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue = null;
		try {
			System.out.println("before advice.");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("after returning.");
		} catch (Throwable e) {
			System.out.println("after throwing.");
			e.printStackTrace();
		}
		System.out.println("after finally.");

		return returnValue;
	}
	
	@Around("@annotation(com.employeeManagement.demo.aspect.MyLoggable)")
	public Object aroundAdviceWithCustomAnnotation(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue = null;
		try {
			log.info("Around -Before: ");
			returnValue = proceedingJoinPoint.proceed();
			log.info("Around -After : ");
		} catch (Throwable e) {
			log.error("Around - After Throwing : " + e.getMessage());
			e.printStackTrace();
		}
		log.info("After Returning : ");

		return returnValue;
	}
}
