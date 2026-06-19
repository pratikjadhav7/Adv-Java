package View;

import java.io.DataOutput;
import java.util.Scanner;

import Controller.EmployeeController;
import Model.Employee;


public class EmployeeView {

	public void showView() {
		Scanner sc = new Scanner(System.in);
		
		EmployeeController ec = new EmployeeController();
		int choice;
		
		do {
			System.out.println("======= Employee Mamagement ========");
			System.out.println("1. Add Employee");
			System.out.println("2. Display all Empoyees");
			System.out.println("3. Search Employee");
			System.out.println("4. Update Employee");
			System.out.println("5. Delete Employee");
			System.out.println("0. Exit");
			System.out.println("Enter Choice: ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:

				Employee s = new Employee();

				System.out.print("Enter ID : ");
				s.setId(sc.nextInt());

				sc.nextLine();

				System.out.print("Enter Name : ");
				s.setName(sc.nextLine());

				System.out.print("Enter Salary : ");
				s.setSalary(sc.nextDouble());

				sc.nextLine();

				System.out.print("Enter Role : ");
				s.setRole(sc.nextLine());

				ec.addEmployee(s);

				break;

			case 2:
				ec.displayAllEmployees();
				break;

			case 3:

				System.out.print("Enter ID : ");
				int id = sc.nextInt();

				ec.searchEmployee(id);

				break;

			case 4:

				Employee s1 = new Employee();

				System.out.print("Enter ID : ");
				s1.setId(sc.nextInt());

				sc.nextLine();

				System.out.print("Enter Name : ");
				s1.setName(sc.nextLine());

				System.out.print("Enter Salary : ");
				s1.setSalary(sc.nextDouble());

				sc.nextLine();

				System.out.print("Enter Role : ");
				s1.setRole(sc.nextLine());

				ec.updateEmployee(s1);

				break;
				
			case 5:
				System.out.print("Enter ID : ");
				id = sc.nextInt();

				ec.deleteEmployee(id);

				break;

			case 6:
				System.out.println("Thank You!");
				break;

			default:
				System.out.println("Invalid Choice!");
			}
		}while(choice!=0);
		sc.close();
		
	}

}
