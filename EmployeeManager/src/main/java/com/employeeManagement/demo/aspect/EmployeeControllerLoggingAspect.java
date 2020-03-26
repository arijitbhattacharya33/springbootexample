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

	@Before("execution(* com.employeeManagement.demo.controller.EmployeeController.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {

		// get the method name on which advice performed
		String methodDetails = joinPoint.toString();

		log.info("Before Advice:: " + methodDetails);

		// getTarget() gives us the object of whos method was called and that method
		// triggered the advice. joinPoint.getTarget();
	}

	@After("applyAllMethodsOfEmployeeController()")
	public void afterAdvice(JoinPoint joinPoint) {
		String methodDetails = joinPoint.toString();
		log.info("After Advice:: " + methodDetails);

	}

	@AfterReturning(pointcut = "applyAllMethodsOfEmployeeController()", returning = "returnObject")
	public void afterReturningAdvice(List<Employee> returnObject) {
		log.info("After Returning : " + returnObject.toString());
	}

	@AfterThrowing(pointcut = "applyAllMethodsOfEmployeeController()", throwing = "ex")
	public void afterThrowingAdvice(RuntimeException ex) {

		log.info("After Throwing : " + ex.getMessage());
		log.error("After Throwing : " + ex.getMessage());
	}

	@Around("applyAllMethodsOfEmployeeController()")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
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

	@Around("@annotation(com.employeeManagement.demo.aspect.MyLoggable)")
	public Object aroundAdviceWithCustomAnnotation(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue = null;
		try {
			log.info("Around -Before: with custom annotation");
			returnValue = proceedingJoinPoint.proceed();
			log.info("Around -After : with custom annotation");
		} catch (Throwable e) {
			log.error("Around - After Throwing : with custom annotation" + e.getMessage());
			e.printStackTrace();
		}
		log.info("After Returning : with custom annotation");

		return returnValue;
	}

}
