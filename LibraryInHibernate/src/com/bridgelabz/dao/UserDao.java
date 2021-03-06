package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bridgelabz.hibernateutil.HibernateUtil;
import com.bridgelabz.model.User;

public class UserDao {

	final Logger log;

	public UserDao() {
		log = LoggerFactory.getLogger(UserDao.class);
	}

	/**
	 * Adds user to the database
	 * 
	 * @param user - user to be added
	 * @return user id
	 */
	public int addUser(User user) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		int userId = 0;
		try {
			transaction = session.beginTransaction();

			userId = (int) session.save(user);

			transaction.commit();

			log.debug("User registered successfully");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
				log.debug("User registration failed");
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
		return userId;
	}

	/**
	 * @param email- email id entered by user
	 * @param password- password entered by user
	 * @return user object if user has entered correct email and password
	 */
	public User logInCheck(String email, String password) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		User user = null;

		String hql = "select user from User user where user.email = :email and user.password = :password";
		Query query = session.createQuery(hql);
		query.setString("email", email);
		query.setString("password", password);
		user = (User) query.uniqueResult();
		session.close();
		return user;
	}
	
	/**
	 * @param userId - id of user
	 * @return User object from user id
	 */
	public User getUser(int userId) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		User user = null;
		
		user = session.get(User.class, userId);
		session.close();
		return user;
	}
	
	/**
	 * @param user - user object
	 * @return true if user with entered email id already exists
	 */
	public boolean checkIfEmailAlreadyExist(User user) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", user.getEmail()));
		criteria.setProjection(Projections.rowCount());
		List list = criteria.list();
		System.out.println("First element: " + list.get(0));
		if((long)list.get(0) > 0){
			log.error("Email ID already used");
			return true;
		} else{
			log.debug("New User...");
			return false;
		}		
	}

	/**
	 * resets password
	 * @param email- email id of user
	 * @param password - new password
	 */
	public void resetPassword(String email, String password){
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
		transaction = session.beginTransaction();
		User user = null;
		
		String hql = "select user from User user where user.email = :email";
		Query query = session.createQuery(hql);
		query.setString("email", email);
		user = (User) query.uniqueResult();
		
		user.setPassword(password);
		session.update(user);
		//session.saveOrUpdate(user);
		
		transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

}
