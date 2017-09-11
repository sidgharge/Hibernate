package com.bridgelabz;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="event")
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="mygen")
	@GenericGenerator(name="mygen", strategy="native")
	int eventId;
	
	@Column(name="event_name")
	String eventName;
	/*
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="person_event", joinColumns={@JoinColumn(name="person_id")},
			inverseJoinColumns={@JoinColumn(name="event_id")})
	Set<Person> persons = new HashSet<>();*/
	
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

	/*public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}*/
	
}
