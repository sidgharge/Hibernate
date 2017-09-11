package com.bridgelabz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="user_details")
public class UserDetails {

	@Id
	@Column(name="user_id")
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=
			{@Parameter(name="property", value="user")})
	int userId;
	
	@Column(name="contact")
	int contact;
	
	@Column(name="city")
	String city;
	
	@OneToOne
	@PrimaryKeyJoinColumn
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
