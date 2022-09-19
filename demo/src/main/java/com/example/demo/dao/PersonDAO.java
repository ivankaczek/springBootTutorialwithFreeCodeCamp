package com.example.demo.dao;

import java.util.UUID;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.example.demo.model.Person;

public interface PersonDAO {

	int insertPerson(UUID id, Person person);
	
	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
	
}
