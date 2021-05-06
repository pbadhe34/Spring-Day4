package com.server.service;

import com.server.domain.Person;

 
public interface PersonService {
	public Person getRandom();
	public Person getById(Long id);
	public void save(Person person);
}
