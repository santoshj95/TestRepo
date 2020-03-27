package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonDao;

@RestController
public class PersonController {

	@Autowired
	PersonDao person;
	
	@RequestMapping("/savePerson")
	public Object getPerson() {
	return person.getPerson();	
	}
	
	@RequestMapping("/person")
	public Object getPersons() {
		return person.getPersons();
	}
	
	@RequestMapping("/manytomany")
	public Object getPersonsMany() {
		return person.getPersonsMany();
	}
}
