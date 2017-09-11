package com.bridgelabz;

import java.util.HashSet;
import java.util.Set;

public class Person {

	int personId;
	String personName;
	Set<Event> events = new HashSet<Event>();
	
	public Person(){}
	
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}



	public void setPersonName(String personName) {
		this.personName = personName;
	}



	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
}
