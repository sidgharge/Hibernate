package com.bridgelabz.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bridgelabz.hibernateutil.HibernateUtil;
import com.bridgelabz.model.User;

public class UserDao {

	final Logger log;

	public UserDao() {
		log = Logger.getLogger(UserDao.class);
	}

	/**
	 * Adds user to the database
	 * 
	 * @param user
	 *            - user to be added
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
	
	public User getUser(int userId) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		User user = null;
		
		user = session.get(User.class, userId);
		session.close();
		return user;
	}
}
