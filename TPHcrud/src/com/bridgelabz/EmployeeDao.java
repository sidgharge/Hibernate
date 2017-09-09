package com.bridgelabz;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {
	
	static SessionFactory factory;

	public EmployeeDao() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
	}
	
	public void addEmplyee(Employee employee){
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			
			int id = (int)session.save(employee);
			System.out.println("Employee Added as regular by ID: " + id);
			
			transaction.commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
		}		
	}
}
