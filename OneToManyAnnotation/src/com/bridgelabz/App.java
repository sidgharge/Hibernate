package com.bridgelabz;

public class App {

	public static void main(String[] args) {
		
		Person person = new Person();
		person.setPersonId(1);
		person.setName("Sid");
		
		Laptop laptop = new Laptop();
		laptop.setLaptopId(1);
		laptop.setModelName("Dell");
		
		person.getLaptops().add(laptop);
		laptop.setPerson(person);
		Dao dao = new Dao();
		dao.add(person, laptop);
	}

}
