package com.employeeManagement.demo.aspect;

import java.util.List;

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

import com.employeeManagement.demo.model.Employee;

@Aspect
@Component
public class EmployeeControllerLoggingAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(com.employeeManagement.demo.controller.EmployeeController)")
	public void applyAllMethodsOfEmployeeController() {
	}

	@Before("execution(within(com.employeeManagement.demo.controller.EmployeeController))")
	public void beforeAdvice(JoinPoint joinPoint) {

		// get the method name on which advice performed
		String methodDetails = joinPoint.toString();

		log.info("Before Advice:: " + methodDetails);

		// getTarget() gives us the object of whos method was called and that method
		// triggered the advice.
		joinPoint.getTarget();
	}

	@After("applyAllMethodsOfEmployeeController()")
	public void afterAdvice(JoinPoint joinPoint) {
		String methodDetails = joinPoint.toString();
		log.info("After Advice:: " + methodDetails);

	}

	@AfterReturning(pointcut = "args(name)", returning = "returnObject")
	public void afterReturningAdvice(String name, List<Employee> returnObject) {
		log.info("After Returning : "+returnObject.toString());
	}

	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
	public void afterThrowingAdvice(String name, RuntimeException ex) {

		log.error("After Throwing : "+ ex.getMessage());
	}

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
}
