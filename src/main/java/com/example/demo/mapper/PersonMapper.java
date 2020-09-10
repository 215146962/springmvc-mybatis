package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

public interface PersonMapper {
	public List<Person> getPersons();
	public Person getPersonById(String id);
	public void addPerson(Person person);
	public void updatePerson(Person person);
	public void deletePerson(Person person);
	
}
