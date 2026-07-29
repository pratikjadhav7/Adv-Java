package Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateConfig;
import Model.Student;

public class StudentRepository {

	public boolean addStudent(Student student) {
		Session session = HibernateConfig.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		session.persist(student);
		tx.commit();

		return true;
	}

	public Student searchStudentByRollNo(int rollno) {
		Session session = HibernateConfig.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		Student student=session.get(Student.class,rollno);
		tx.commit();

		return student;
	}

	public List<Student> displayAllStudents() {
		Session session = HibernateConfig.getSessionFactory().openSession();

		Transaction tx = session.beginTransaction();

		List<Student> studentList = session.createQuery("from Student",Student.class).getResultList();
		
		tx.commit();
		
		return studentList;
		
	}
}
