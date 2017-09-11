package com.bridgelabz;

import java.util.HashSet;
import java.util.Set;

public class App {

	public static void main(String[] args) {
		
		Person person = new Person();
		person.setPersonName("Sid");
		
		Event event = new Event();
		event.setEventName("Marathon");
		
		Event event2 = new Event();
		event2.setEventName("IPL");
		
		Set<Event> events = new HashSet<>();
		events.add(event);
		events.add(event2);
		
		Dao dao = new Dao();
		dao.add(person, events);
	}

}
