package com.bridgelabz;

import java.util.HashSet;
import java.util.Set;

public class Person {

	int personId;
	String name;
	Set<Laptop> laptops = new HashSet<>();
	
	public Person() {}
	
	public int getPersonId() {
		return personId;
	}
	
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Set<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(Set<Laptop> laptops) {
		this.laptops = laptops;
	}
	
}
