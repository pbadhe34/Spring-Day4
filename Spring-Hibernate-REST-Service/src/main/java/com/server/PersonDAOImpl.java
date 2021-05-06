package com.server;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.stereotype.Repository;

//This program  using Spring4.1 with Hibernate 4.1 and jackson ver2.1 libraries

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	//private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		System.out.println("PersonDAOImpl.setSessionFactory()");
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(Person p) {
		System.out.println("PersonDAOImpl.addPerson()");
		Session session = this.sessionFactory.getCurrentSession();
		//No transaction management is needed.Spring provides it
		//Transaction trans=session.beginTransaction();		 
		session.save(p);
		//trans.commit();
		//logger.info("Person saved successfully, Person Details="+p);
	}

	@Override
	public void updatePerson(Person p) {
		System.out.println("PersonDAOImpl.updatePerson()");
		Session session = this.sessionFactory.getCurrentSession();
		//Transaction trans=session.beginTransaction();
		//No transaction management is needed.Spring provides it
		session.update(p);
		//trans.commit();
		//logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("PersonDAOImpl.listPersons()");
		//Transaction trans=session.beginTransaction();
		//No transaction management is needed.Spring provides it
		List<Person> personsList = session.createQuery("from Person").list();
		for(Person p : personsList){
			//logger.info("Person List::"+p);
		}
		//trans.commit();
		return personsList;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		//No transaction management is needed.Spring provides it
		System.out.println("PersonDAOImpl.getPersonById()  "+id);
		Person p = (Person) session.load(Person.class, new Integer(id));
		//logger.info("Person loaded successfully, Person details="+p);
		System.out.println("The person returned is  "+p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		System.out.println("PersonDAOImpl.removePerson()");
		//No transaction management is needed.Spring provides it
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		//logger.info("Person deleted successfully, person details="+p);
	}

}
