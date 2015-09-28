package com.springtest.dao;

import java.util.List;

import com.springtest.api.Person;

public interface PersonDao {

	List<Person> getAllPersons();
	
	int addPerson(Person person);
}
