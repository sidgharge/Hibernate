package com.bridgelabz;

public class Start {

	public static void main(String[] args) {
		RegularEmployee employee = new RegularEmployee();
		employee.setName("Nilesh Karle");
		employee.setSalary(20000);
		employee.setBonus(4000);
		
		EmployeeDao dao = new EmployeeDao();
		dao.addEmplyee(employee);
	}

}
