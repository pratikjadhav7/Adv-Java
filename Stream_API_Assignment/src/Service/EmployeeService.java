package Service;

import java.util.List;

import Model.Employee;
import Model.EmployeeManagement;

public class EmployeeService {

	EmployeeManagement em = new EmployeeManagement();

	    public void salaryGreaterThan50000() {
	        em.salaryGreaterThan50000();
	    }

	    public void itEmployees() {
	        em.itEmployees();
	    }

	    public void fromPune() {
	        em.fromPune();
	    }

	    public void ageGreaterThan30() {
	        em.ageGreaterThan30();
	    }

	    public void isActive() {
	        em.isActive();
	    }

	    public void sortByAscending() {
	        em.sortByAscending();
	    }

	    public void sortByDescending() {
	        em.sortByDescending();
	    }

	    public void sortByName() {
	        em.sortByName();
	    }

	    public void topFivePaidEmployees() {
	        em.topFivePaidEmployees();
	    }

	    public void lowest3Salaries() {
	        em.lowest3Salaries();
	    }

	    public void employeeCount() {
	        em.employeeCount();
	    }

		public void displayAll() {
			em.displayAll();
			
		}


}
