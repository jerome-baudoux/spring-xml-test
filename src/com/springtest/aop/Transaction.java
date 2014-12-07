package com.springtest.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Fake Transaction management
 * @author Jerome
 */
public class Transaction {

	/**
	 * manage transaction for each call
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	public Object transaction(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			System.out.println("Start transaction");
			Object val = joinPoint.proceed();
			System.out.println("Commit");
			return val;
		} catch(Throwable t) {
			System.out.println("Rollback");
			throw t;
		}
	}
}
