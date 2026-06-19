package Service;

import Model.Student;
import Model.StudentManagement;

public class StudentService {


	StudentManagement sm = new StudentManagement();

	public void addStudent(Student s) {
		
		sm.addStudent(s);
	}

	public void displayAllStudents() {
		sm.displayAllStudents();
		
	}

	public void searchStudent(int rollNo) {
		sm.searchStudent(rollNo);
		
	}

	public void updateStudent(Student s1) {
		sm.updateStudent(s1);
		
	}

	public void deleteStudent(int rollNo) {
		sm.deleteStudent(rollNo);
		
	}
	
	
}
