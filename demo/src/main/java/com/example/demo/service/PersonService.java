package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;

@Service
public class PersonService {

	private final PersonDAO personDAO;
	
	@Autowired
	public PersonService(@Qualifier("fakeDAO") PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	
	public int addPerson(Person person) {
		return personDAO.insertPerson(person);
	}
	
	
	
}
