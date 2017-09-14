package com.bridgelabz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.LibraryDatabase;
import com.bridgelabz.dao.UserDao;
import com.bridgelabz.model.Book;
import com.bridgelabz.model.User;

//@WebServlet("/AddNewBook")
public class AddNewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		int price = Integer.parseInt(request.getParameter("price"));
		System.out.println("user id " + request.getParameter("user_id"));
		int userId = Integer.parseInt(request.getParameter("user_id"));
		//to know old title to edit database if the title is changed after editing book info
		String bookId = request.getParameter("book_id");
		
		UserDao userDao = new UserDao();
		User user  = userDao.getUser(userId);		
		Book book = new Book(title, author, category, price);
		book.setUser(user);
		
		LibraryDatabase database = new LibraryDatabase();
		
		if ((bookId != null) && (bookId.equals(""))) {
			database.addOrUpdateBook(book);			
		} else {
			book.setBookId(Integer.parseInt(bookId));
			database.addOrUpdateBook(book);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
