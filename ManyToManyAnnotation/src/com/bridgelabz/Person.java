package com.bridgelabz;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="mygen")
	@GenericGenerator(name="mygen", strategy="native")
	int personId;
	
	@Column(name="person_name")
	String personName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="person_event", joinColumns={@JoinColumn(name="person_id")},
			inverseJoinColumns={@JoinColumn(name="event_id")})
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
