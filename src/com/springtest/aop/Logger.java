package com.springtest.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

/**
 * Loggs every call made
 * @author Jerome
 */
public class Logger {
	
	/**
	 * Logger class and params
	 * @param joinPoint
	 */
	public void log(JoinPoint joinPoint){
        System.out.println("Calling " + joinPoint.getSignature() + " with agruments Passed=" + Arrays.toString(joinPoint.getArgs()));
    }
}
