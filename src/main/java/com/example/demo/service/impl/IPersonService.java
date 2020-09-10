package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.service.PersonService;

@Service
class IPersonService implements PersonService {

	@Autowired
	private PersonMapper personMapper;

	// ����
	public List<Person> getPersons() {

		return (List<Person>) personMapper.getPersons();
	}

	// ����id����
	public Person getPersonById(String id) {
		return personMapper.getPersonById(id);
	}

	// ���
	public void addPerson(Person person) {
		personMapper.addPerson(person);
	}

	// �޸�
	public void updatePerson(Person person) {
		personMapper.addPerson(person);
	}

	// ɾ��
	public void deletePerson(Person person) {
		personMapper.deletePerson(person);
	}

}
