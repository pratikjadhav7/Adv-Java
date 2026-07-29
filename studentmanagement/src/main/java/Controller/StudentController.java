package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import DTO.ResponseDTO;
import Model.Student;
import Service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/studentapi/*")
public class StudentController extends HttpServlet {

	StudentService studentService = new StudentService();
	ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void init() throws ServletException {
		mapper.registerModule(new JavaTimeModule());
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		setCORS(resp);
		
		String path = req.getPathInfo();

		if ("/demo".equals(path)) {
			System.out.println("Running");
		}
		else if("/searchstudentbyroll".equals(path)) {
			searchStudentByRollNo(req,resp);
		}
		else if("/displayallstudents".equals(path)) {
			displayAllStudents(req,resp);
		}
		else if("/birthdaywish".equals(path)) {
			birthdayWish(req,resp);
		}
	}

	private void birthdayWish(HttpServletRequest req, HttpServletResponse resp) {
		studentService.birthdayWish();
		
	}
	private void displayAllStudents(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		List<Student> studentList = studentService.displayAllStudents();
		
		 ResponseDTO<Student> responseDTO = new ResponseDTO<Student>();
		 if(studentList.isEmpty()) {
			 responseDTO.setStatus(404);
			 responseDTO.setMsg("Student Not Found");
		 }else {
			 responseDTO.setStatus(200);
			 responseDTO.setMsg("Student Found");
			 responseDTO.setData(studentList);
		}
		
		String response = mapper.writeValueAsString(responseDTO);
		resp.getWriter().print(response);//to sent msg for FE after converting respDTO to string bcoz getWriter takes string only
		
		
	}

	private void searchStudentByRollNo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		int rollno = Integer.parseInt(req.getParameter("rollno"));
		
		Student student = studentService.searchStudentByRollNo(rollno);
		
		 ResponseDTO<Student> responseDTO = new ResponseDTO<Student>();
		 if(student==null) {
			 responseDTO.setStatus(404);
			 responseDTO.setMsg("Student not found");
		 }else {
			 responseDTO.setStatus(200);
			 responseDTO.setMsg("Student found");
			 
			 List <Student>list=new ArrayList<Student>();
			 list.add(student);
			 responseDTO.setData(list);	 
		}
		
		String response = mapper.writeValueAsString(responseDTO);
		resp.getWriter().print(response);//to sent msg for FE after converting respDTO to string bcoz getWriter takes string only
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		setCORS(resp);
		String path = req.getPathInfo();

		if ("/addstudent".equals(path)) {
			addStudent(req, resp);
		}
	}

	private void setCORS(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

	}

	private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String studentInfo = req.getReader().readLine();
  //      System.out.println(studentInfo);
		
		 Student student = mapper.readValue(studentInfo,Student.class);
		 
		 boolean res = studentService.addStudent(student);
		 
		 ResponseDTO<Student> responseDTO = new ResponseDTO<Student>();
		 if(res==true) {
			 responseDTO.setStatus(200);
			 responseDTO.setMsg("Student Added Successfully");
		 }else {
			 responseDTO.setStatus(500);
			 responseDTO.setMsg("Error!");
		}
		
		String response = mapper.writeValueAsString(responseDTO);
		resp.getWriter().print(response);//to sent msg for FE after converting respDTO to string bcoz getWriter takes string only
		
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		setCORS(resp);
	}

}
