package com.bridgelabz;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="contract_employee")
public class ContractEmployee extends Employee{

	@Column(name="pay_per_hour")
	private int payPerHour;
	
	@Column(name="contract_duration")
	private String contractDuration;
	
	
	public int getPayPerHour() {
		return payPerHour;
	}
	public void setPayPerHour(int payPerHour) {
		this.payPerHour = payPerHour;
	}
	public String getContractDuration() {
		return contractDuration;
	}
	public void setContractDuration(String contractDuration) {
		this.contractDuration = contractDuration;
	}
	
}
