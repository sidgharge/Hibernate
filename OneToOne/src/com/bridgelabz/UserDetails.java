package com.bridgelabz;

public class UserDetails {

	int userId;
	int contact;
	String city;
	User user;
	
	public UserDetails() {}
	
	public int getContact() {
		return contact;
	}
	
	public void setContact(int contact) {
		this.contact = contact;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return " User Id: " + userId + " Contact: " + contact + " City: " + city;
	}
}
