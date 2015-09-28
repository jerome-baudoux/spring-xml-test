package com.springtest.service;

import java.util.List;

import com.springtest.api.Person;

/**
 * Interface for a Simple list of person
 * @author Jerome
 *
 */
public interface Persons {

	List<Person> getAllPersonsLocally();

	List<Person> getAllPersonsFromDatabase();
	
	int addPerson(Person person);
	
	int addPersonError(Person person);
}
