package com.bridgelabz;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Dao {

	void add(Person person, Set<Event> events){
		
		SessionFactory factory = HibernateUtil.getFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		person.setEvents(events);
		
		session.save(person);
		
		transaction.commit();
	}

}
