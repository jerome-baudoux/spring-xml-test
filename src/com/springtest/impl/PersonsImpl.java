package com.springtest.impl;

import java.util.List;

import com.springtest.api.Person;
import com.springtest.api.Persons;

/**
 * Simple list of person
 * @author Jerome
 */
public class PersonsImpl implements Persons {

	private List<Person> persons;

	/**
	 * @return the personnes
	 */
	public List<Person> getAllPersonnes() {
		return persons;
	}
	/**
	 * @param persons the personnes to set
	 */
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
}
