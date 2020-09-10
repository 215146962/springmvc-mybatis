package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Person;

public interface PersonService {
	public List<Person> getPersons();

	public Person getPersonById(String id);

	public void addPerson(Person person);

	public void updatePerson(Person person);

	public void deletePerson(Person person);
}
