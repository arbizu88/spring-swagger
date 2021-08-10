package com.caha.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.caha.model.Person;

@Service
public class PersonService {

	List<Person> persons = new ArrayList<>();
    {
    	persons.add(new Person(1, "Coca Cola", new Date(), 500.12));
    	persons.add(new Person(2, "Pepsi", new Date(), 350.16));
    	persons.add(new Person(3, "Fanta", new Date(), 400.18));
    	persons.add(new Person(4, "Imperial", new Date(), 600.13));
    }

	public List<Person> getPersons() {	
		return persons;
	}
	
	public void insertPerson(Person person) {
		persons.add(person);
	}

	public Person updatePerson(Person prd) {		
		for (Person person : persons) {
			if(person.getId() == prd.getId()) {
				persons.remove(person);
				persons.add(prd);
			}
		}
		return prd;
	}

	public Person getPerson(int id) {
		Person prd = null;
		for (Person person : persons) {
			if(person.getId() == id) {
				prd = person;
				break;
			}
		}
		return prd;
	}

	public void deletePerson(Person prd) {
		List<Person> list = this.getPersons();
		for (Person person : list) {
			if(person.equals(prd)) {
				list.remove(person);
			}
		}
	}
}
