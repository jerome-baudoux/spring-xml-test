package com.springtest.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springtest.api.Person;
import com.springtest.service.Persons;

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
			
			// fetch locally
			System.out.println(obj.getAllPersonsLocally());
			
			// Add a person
			Person newPerson = new Person();
			newPerson.setFirstName("firstName" + System.currentTimeMillis());
			newPerson.setLastName("lastName" + System.currentTimeMillis());
			
			// Fail after saving into database
			try {
				System.out.println(obj.addPersonError(newPerson));
			} catch (Throwable t) {
				t.printStackTrace();
				System.out.println("Transaction gets rollbacked");
			}
			
			// Fetch from database
			System.out.println(obj.getAllPersonsFromDatabase());
			
			// Insert into database
			System.out.println(obj.addPerson(newPerson));
			
			// Fetch from database
			System.out.println(obj.getAllPersonsFromDatabase());
			
		} finally {
			if(context!=null) {
				context.close();
			}
		}
	}
}
