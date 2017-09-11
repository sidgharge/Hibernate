package com.bridgelabz;

public class App {

	public static void main(String[] args) {
		
		User user = new User();
		user.setName("Siddharth");
		user.setUserId(2);
		
		UserDetails userDetails = new UserDetails();
		userDetails.setCity("Mumbai");
		userDetails.setContact(7219);
		
		Dao dao = new Dao();
		dao.addUser(user, userDetails);
		//dao.getUser(1);
	}

}
