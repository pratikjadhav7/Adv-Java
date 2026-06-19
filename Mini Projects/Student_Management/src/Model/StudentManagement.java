package Model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StudentManagement {

	Connection con;
	Statement stmt;

	public StudentManagement() {

		try {
			Properties properties = new Properties();

			FileInputStream is = new FileInputStream("config.properties");
			properties.load(is);

			String driver = properties.getProperty("drivername");
			String url = properties.getProperty("pathurl");
			String username = properties.getProperty("username");
			String password = properties.getProperty("pass");

			Class.forName(driver);

			con = DriverManager.getConnection(
			        url,
			        username,
			        password);

			stmt = con.createStatement();

			System.out.println("Connection established successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ADD
	public void addStudent(Student s) {

		try {

			String query = "insert into Student values(?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, s.getRollNo());
			ps.setString(2, s.getName());
			ps.setDouble(3, s.getMarks());
			ps.setString(4, s.getMobileNo());
			ps.setString(5, s.getAddress());
			ps.setDate(6, java.sql.Date.valueOf(s.getDob()));

			ps.executeUpdate();

			System.out.println("Student Added Successfully!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DISPLAY ALL
	public void displayAllStudents() {

		try {

			ResultSet rs = stmt.executeQuery("select * from Student");

			while (rs.next()) {

				Student s = new Student();

				s.setRollNo(rs.getInt("rollNo"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getDouble("marks"));
				s.setMobileNo(rs.getString("mobileNo"));
				s.setAddress(rs.getString("address"));
				s.setDob(rs.getDate("dob").toLocalDate());

				System.out.println(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// SEARCH
	public void searchStudent(int rollNo) {

		try {

			String query = "select * from Student where rollNo=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, rollNo);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Student s = new Student();

				s.setRollNo(rs.getInt("rollNo"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getDouble("marks"));
				s.setMobileNo(rs.getString("mobileNo"));
				s.setAddress(rs.getString("address"));
				s.setDob(rs.getDate("dob").toLocalDate());

				System.out.println(s);

			} else {
				System.out.println("Student Not Found!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// UPDATE
	public void updateStudent(Student s) {

		try {

			String query =
					"update Student set name=?, marks=?, mobileNo=?, address=?, dob=? where rollNo=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, s.getName());
			ps.setDouble(2, s.getMarks());
			ps.setString(3, s.getMobileNo());
			ps.setString(4, s.getAddress());
			ps.setDate(5, java.sql.Date.valueOf(s.getDob()));
			ps.setInt(6, s.getRollNo());

			int rows = ps.executeUpdate();

			if (rows > 0)
				System.out.println("Student Updated Successfully!");
			else
				System.out.println("Student Not Found!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DELETE
	public void deleteStudent(int rollNo) {

		try {

			String query = "delete from Student where rollNo=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, rollNo);

			int rows = ps.executeUpdate();

			if (rows > 0)
				System.out.println("Student Deleted Successfully!");
			else
				System.out.println("Student Not Found!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}