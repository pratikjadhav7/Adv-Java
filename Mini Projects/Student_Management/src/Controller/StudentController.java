package Controller;

import Model.Student;
import Service.StudentService;

public class StudentController {

	StudentService sv = new StudentService();
	
	public void addStudent(Student s) {
		sv.addStudent(s);
		
	}

	public void displayAllStudents() {
		sv.displayAllStudents();
		
	}

	public void searchStudent(int rollNo) {
		sv.searchStudent(rollNo);
		
	}

	public void updateStudent(Student s1) {
		sv.updateStudent(s1);
		
	}

	public void deleteStudent(int rollNo) {
		sv.deleteStudent(rollNo);
		
	}

}
