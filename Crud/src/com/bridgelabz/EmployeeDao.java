package com.bridgelabz;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {
	static SessionFactory factory;
	
	static void createFactory(){
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");		
		factory = configuration.buildSessionFactory();		
	}
	
	void addEmployee(String firstName, String lastName, int salary){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		
		session.merge(employee);
		
		transaction.commit();
		session.close();
		System.out.println("Done");
	}
	
	void listAllEmployee(){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List<Employee> list = session.createQuery("FROM Employee").list();
		
		for(Employee employee : list){
			System.out.println("ID: " + employee.getId());
			System.out.println("First Name: " + employee.getFirstName());
			System.out.println("Last Name: " + employee.getLastName());
			System.out.println("Salary: " + employee.getSalary());
		}
		transaction.commit();
		session.close();
	}
	
	void updateEmployee(int id, int salary){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class, id);
		employee.setSalary(salary);
		
		session.update(employee);
		
		transaction.commit();
		session.close();
	}
	
	void deleteEmployee(int id){
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class, id);
		session.delete(employee);
		
		transaction.commit();
		session.close();
	}
}
