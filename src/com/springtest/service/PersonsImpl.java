package com.springtest.service;

import java.util.List;

import com.springtest.api.Person;
import com.springtest.dao.PersonDao;

/**
 * Simple list of person
 * @author Jerome
 */
public class PersonsImpl implements Persons {

	private PersonDao personDao;
	
	private List<Person> persons;

	/**
	 * @return the personnes
	 */
	public List<Person> getAllPersonsLocally() {
		return this.persons;
	}

	/**
	 * @return the personnes
	 */
	public List<Person> getAllPersonsFromDatabase() {
		return this.personDao.getAllPersons();
	}

	
	public int addPerson(Person person) {
		return this.personDao.addPerson(person);
	}
	
	public int addPersonError(Person person) {
		this.personDao.addPerson(person);
		throw new RuntimeException("Simulate an error in the service");
	}
	
	/**
	 * @param persons the persons to set
	 */
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	/**
	 * @param personDao the dao to set
	 */
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
}
