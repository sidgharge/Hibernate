package com.bridgelabz;

public class Laptop {

	int laptopId;
	int personId;
	String modelName;
	Person person;
	
	public Laptop(){}
	
	public int getLaptopId() {
		return laptopId;
	}
	
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	
	public int getPersonId() {
		return personId;
	}
	
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}	
}
