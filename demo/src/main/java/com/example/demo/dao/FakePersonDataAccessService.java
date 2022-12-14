package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("fakeDAO")
public class FakePersonDataAccessService implements PersonDAO {
	
	
	private static List<Person> DB = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> selectAllPeople() {
		// TODO Auto-generated method stub
		return DB;
	}

	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> personMaybe = selectPersonById(id);
		if(personMaybe.isEmpty()) {
			return 0;
		}
		DB.remove(personMaybe.get());
		return 1;
	}

	@Override
	public int updatePersonById(UUID id, Person personToUpdate) {
		
		return selectPersonById(id).map(person -> {
											int indexPersonToUpdate = DB.lastIndexOf(person);
											if(indexPersonToUpdate >= 0) {
												DB.set(indexPersonToUpdate, new Person(id, personToUpdate.getName()));
												return 1;
											} 
											return 0;
											}).orElse(0);
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream()
				.filter(person -> person.getId().equals(id))
				.findFirst();		
						
	}

}
