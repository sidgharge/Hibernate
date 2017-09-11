package com.bridgelabz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="laptop")
public class Laptop {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="mygen")
	@GenericGenerator(name="mygen", strategy="native")
	@Column(name="laptop_id")
	int laptopId;
	
	/*@Column(name="person_id")
	int personId;*/
	
	@Column(name="model_name")
	String modelName;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	Person person;
	
	public Laptop(){}
	
	public int getLaptopId() {
		return laptopId;
	}
	
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	
	/*public int getPersonId() {
		return personId;
	}
	
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	*/
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
