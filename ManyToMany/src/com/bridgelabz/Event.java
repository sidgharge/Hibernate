package com.bridgelabz;

import java.util.HashSet;
import java.util.Set;

public class Event {

	int eventId;
	String eventName;
	Set<Person> persons = new HashSet<>();
	
	public Event(){}
	
	public int getEventId() {
		return eventId;
	}
	
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
	
}
