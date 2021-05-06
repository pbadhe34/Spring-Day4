package com.server.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.Person;
import com.server.PersonDAO;

//This program  using Spring4.1 with Hibernate 4.1 and jackson ver2.1 libraries

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		System.out.println("PersonServiceImpl.setPersonDAO()");
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		System.out.println("PersonServiceImpl.addPerson()");
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		System.out.println("PersonServiceImpl.updatePerson()");
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		System.out.println("PersonServiceImpl.listPersons()");
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		System.out.println("PersonServiceImpl.getPersonById()");
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		System.out.println("PersonServiceImpl.removePerson()");
		this.personDAO.removePerson(id);
	}

}
