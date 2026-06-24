package View;

import java.util.List;
import java.util.Scanner;

import Controller.EmployeeController;
import Model.EmployeeManagement;
import Model.Employee;

public class EmployeeView {

	public void showView() {
		Scanner sc = new Scanner(System.in);
		int choice;
		
		EmployeeController ec = new EmployeeController();
		
		do {
			System.out.println("====== Employee Management =======");
			System.out.println("1. Display All");
			System.out.println("2. Employees with salary > 50000:");
			System.out.println("3. IT department employees:");
			System.out.println("4. Employees from Pune: ");
			System.out.println("5. Employees age > 30: ");
			System.out.println("6. Active employees only:");
			System.out.println("7. Sort by salary ascending:");
			System.out.println("8. Sort by salary descending:");
			System.out.println("9. Sort by Name: ");
			System.out.println("10. Top 5 highest paid employees: ");
			System.out.println("11. Lowest 3 Salaries:");
	        System.out.println("12. Count employees: ");
	        System.out.println("0. Exit");
	        System.out.println("Enter Choice: ");
	        choice=sc.nextInt();
	        
	        switch(choice) {
	        case 1:
	            ec.displayAll();
	            break;

	        case 2:
	            ec.salaryGreaterThan50000();
	            break;

	        case 3:
	            ec.itEmployees();
	            break;

	        case 4:
	            ec.fromPune();
	            break;

	        case 5:
	            ec.ageGreaterThan30();
	            break;

	        case 6:
	            ec.isActive();
	            break;

	        case 7:
	            ec.sortByAscending();
	            break;

	        case 8:
	            ec.sortByDescending();
	            break;

	        case 9:
	            ec.sortByName();
	            break;

	        case 10:
	            ec.topFivePaidEmployees();
	            break;

	        case 11:
	            ec.lowest3Salaries();
	            break;

	        case 12:
	            ec.employeeCount();
	            break;
	        }
		}while(choice!=0);
		
	}

}
