package Service;

import Model.Employee;
import Model.EmployeeManagement;

public class EmployeeService {

	EmployeeManagement em = new EmployeeManagement();

	public void addEmployee(Employee s) {
		em.addEmployee(s);
		
	}

	public void displayAllEmployees() {
		em.displayAll();
		
	}

	public void updateEmployee(Employee e) {
		em.updateStudent(e);
		
	}

	public void deleteEmployee(int id) {
		em.deleteEmployee(id);
		
	}

	public void searchEmployee(int id) {
		em.searchEmployee(id);
		
	}
	
	
}
