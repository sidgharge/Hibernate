package com.bridgelabz.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bridgelabz.hibernateutil.HibernateUtil;
import com.bridgelabz.model.Book;
import com.bridgelabz.model.User;

//DAO class
public class LibraryDatabase {

	final Logger log;
	
	public LibraryDatabase() {
		log = LoggerFactory.getLogger(LibraryDatabase.class);
	}
	
	/**
	 * Adds or updates the book
	 * @param book - book to be added or updated
	 */
	public void addOrUpdateBook(Book book) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(book);
			transaction.commit();
			log.debug("Book successfully added to the database");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			log.error("Failed to save the book");;
		} finally {
			session.close();
		}
		
	}
	
	/**
	 * @param category - category of which books are to be loaded
	 * @return arraylist of book titles
	 */
	public ArrayList<Book> getCategoryData(String category, int userId) {
		ArrayList<Book> books = new ArrayList<Book>();
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();	
		Query query = session.createQuery("from Book where category = :category and user_id = :userId");
		query.setString("category", category);
		query.setInteger("userId", userId);
		books = (ArrayList<Book>) query.list();
		
		log.debug("Books loaded of the category");
		return books;
	}
	
	
	/**
	 * @param title - title of the book
	 * @return book object
	 */
	public Book getBookDetails(int bookId){
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();		
		
		Query query = session.createQuery("from Book where book_id = :bookId");
		query.setInteger("bookId", bookId);
		Book book = (Book) query.uniqueResult();
		session.close();
		
		log.debug("Book details loaded");
		return book;
	}
	
	/**
	 * Deletes a book
	 * @param title title of the book to be deleted
	 */
	public void deleteBook(int bookId){
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			Book book = session.get(Book.class, bookId);
			session.remove(book);
			transaction.commit();
			log.debug("Book successfully deleted from the database");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			log.error("Failed to delete the book");;
		} finally {
			session.close();
		}
	}
}
