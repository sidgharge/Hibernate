package com.bridgelabz;

public class User {

	int userId;
	String name;
	UserDetails userDetails;
	
	public User(){}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "UserId: " + userId + " Name: " + name + userDetails.toString();
	}
	
}
