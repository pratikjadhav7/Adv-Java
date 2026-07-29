package Service;

import java.time.LocalDate;
import java.util.List;

import java.util.ArrayList;

import Model.Student;
import Repository.StudentRepository;
import SMS.SMservice;

public class StudentService {

	StudentRepository studentRepo = new StudentRepository();

	public boolean addStudent(Student student) {

		return studentRepo.addStudent(student);
	}

	public Student searchStudentByRollNo(int rollno) {

		return studentRepo.searchStudentByRollNo(rollno);
	}

	public List<Student> displayAllStudents() {

		return studentRepo.displayAllStudents();

	}

	public void birthdayWish() {

		List<Student> studentList = studentRepo.displayAllStudents();

		LocalDate todaysdate = LocalDate.now();
		for (Student s : studentList) {

			if (s.getDob().getMonthValue() == todaysdate.getMonthValue()
					&& s.getDob().getDayOfMonth() == todaysdate.getDayOfMonth()) {

				String msg = "Happy Birthday " + s.getName();
				SMservice.sendSMS(msg, s.getMobno());

			}
		}

	}
}
