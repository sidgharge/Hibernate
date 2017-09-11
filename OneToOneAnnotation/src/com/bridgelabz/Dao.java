package com.bridgelabz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Dao {
	
	void addUser(User user, UserDetails userDetails){
		SessionFactory factory = HibernateUtil.getFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		userDetails.setUser(user);
		user.setUserDetails(userDetails);
		
		session.save(user);
		//session.save(userDetails);
		transaction.commit();
		System.out.println("Done");
	}
	
	void getUser(int id){
SessionFactory factory = HibernateUtil.getFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		User user = session.get(User.class, 1);
		System.out.println(user);
		
		transaction.commit();
	}
}
