package Controller;

import Model.Employee;
import Service.EmployeeService;

public class EmployeeController {

	EmployeeService es = new EmployeeService();
	
	public void addEmployee(Employee s) {
		es.addEmployee(s);
		
	}

	public void displayAllEmployees() {
		es.displayAllEmployees();
		
	}

	public void updateEmployee(Employee s1) {
		es.updateEmployee(s1);
		
	}

	public void deleteEmployee(int id) {
		es.deleteEmployee(id);
		
	}

	public void searchEmployee(int id) {
		es.searchEmployee(id);
		
	}
	

}
