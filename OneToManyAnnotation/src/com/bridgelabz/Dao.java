package com.bridgelabz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Dao {

	void add(Person person, Laptop laptop){
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		person.getLaptops().add(laptop);
		session.save(person);
		session.save(laptop);
		transaction.commit();
	}
	
}
