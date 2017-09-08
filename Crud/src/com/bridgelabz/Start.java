package com.bridgelabz;

public class Start {

	public static void main(String[] args) {
		Start start = new Start();
		EmployeeDao.createFactory();
		start.add();
	}

	void add(){
		EmployeeDao dao = new EmployeeDao();
		dao.addEmployee("Nilesh", "Karle", 10000);
	}
	
	void list(){
		EmployeeDao dao = new EmployeeDao();
		dao.listAllEmployee();
	}
	
	void update(){
		EmployeeDao dao = new EmployeeDao();
		dao.updateEmployee(4, 20000);
	}
	
	void delete(){
		EmployeeDao dao = new EmployeeDao();
		dao.deleteEmployee(1);
	}
}
