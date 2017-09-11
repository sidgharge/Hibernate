package com.bridgelabz;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="mygen")
	@GenericGenerator(name="mygen", strategy="native")
	@Column(name="user_id")
	int userId;
	
	@Column(name="name")
	String name;
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
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
