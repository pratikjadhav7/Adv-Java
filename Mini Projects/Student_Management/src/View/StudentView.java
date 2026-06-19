package View;

import java.util.Scanner;

import Controller.StudentController;
import Model.Student;
import Model.StudentManagement;

public class StudentView {

	public void showView() {
		Scanner sc = new Scanner(System.in);
		int choice;

		StudentController scc = new StudentController();

		do {
			System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
			System.out.println("1. Add Student");
			System.out.println("2. Display All Students");
			System.out.println("3. Search Student");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			choice = sc.nextInt();

			switch (choice) {
			case 1:

				Student s = new Student();

				System.out.print("Enter Roll No : ");
				s.setRollNo(sc.nextInt());

				sc.nextLine();

				System.out.print("Enter Name : ");
				s.setName(sc.nextLine());

				System.out.print("Enter Marks : ");
				s.setMarks(sc.nextDouble());

				sc.nextLine();

				System.out.print("Enter Mobile No : ");
				s.setMobileNo(sc.nextLine());

				System.out.print("Enter Address : ");
				s.setAddress(sc.nextLine());

				System.out.print("Enter DOB (yyyy-mm-dd) : ");
				s.setDob(java.time.LocalDate.parse(sc.nextLine()));

				scc.addStudent(s);

				break;

			case 2:
				scc.displayAllStudents();
				break;

			case 3:

				System.out.print("Enter Roll No : ");
				int rollNo = sc.nextInt();

				scc.searchStudent(rollNo);

				break;

			case 4:

				Student s1 = new Student();

				System.out.print("Enter Roll No : ");
				s1.setRollNo(sc.nextInt());

				sc.nextLine();

				System.out.print("Enter Name : ");
				s1.setName(sc.nextLine());

				System.out.print("Enter Marks : ");
				s1.setMarks(sc.nextDouble());

				sc.nextLine();

				System.out.print("Enter Mobile No : ");
				s1.setMobileNo(sc.nextLine());

				System.out.print("Enter Address : ");
				s1.setAddress(sc.nextLine());

				System.out.print("Enter DOB (yyyy-mm-dd) : ");
				s1.setDob(java.time.LocalDate.parse(sc.nextLine()));

				scc.updateStudent(s1);

				break;

			case 5:
				System.out.print("Enter Roll No : ");
				rollNo = sc.nextInt();

				scc.deleteStudent(rollNo);

				break;

			case 6:
				System.out.println("Thank You!");
				break;

			default:
				System.out.println("Invalid Choice!");
			}

		} while (choice != 6);

		sc.close();
		
	}

}
