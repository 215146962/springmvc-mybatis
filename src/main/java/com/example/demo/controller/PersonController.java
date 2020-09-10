package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import com.example.demo.utils.JSONResult;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	PersonService personService;

	// ����
	@RequestMapping(value = "/getPersons")
	@ResponseBody
	public JSONResult getPersons() {

		return JSONResult.ok(personService.getPersons());
	}

	// ����id���ҵ���Person
	@RequestMapping(value = "/getPersonById")
	@ResponseBody
	public Person getPersonById(String id) {

		return personService.getPersonById(id);
	}

	// ���
	@RequestMapping(value = "/addPerson")
	public void addPerson(Person person) {
		personService.addPerson(person);
	}

	// �޸�
	@RequestMapping(value = "/updatePerson")
	public void updatePerson(Person person) {
		personService.updatePerson(person);
	}

	// ɾ��
	@RequestMapping(value = "/deletePerson")
	public void deletePerson(Person person) {
		personService.deletePerson(person);
	}
}
