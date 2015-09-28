package com.springtest.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Do stuff around our a method
 * @author Jerome
 */
public class AroundAspect {

	/**
	 * manage transaction for each call
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	public Object method(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			System.out.println("Do something");
			Object val = joinPoint.proceed();
			System.out.println("Do something else");
			return val;
		} catch(Throwable t) {
			System.out.println("Do something in case of error");
			throw t;
		}
	}
}
