package com.springtest.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.api.Persons;

/**
 * A simple Spring test
 * @author Jerome
 */
public class Main {

	public static void main(String [] args) {
		
		ClassPathXmlApplicationContext context = null;;
		try {
			context = new ClassPathXmlApplicationContext("resources/beans.xml");
			Persons obj = (Persons) context.getBean("persons");
			System.out.println(obj.getAllPersonnes());
		} finally {
			if(context!=null) {
				context.close();
			}
		}
	}
}
