package Model;

import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeManagement {

	Connection con;
	Statement stmt;

	public EmployeeManagement() {

		try {
			Properties properties = new Properties();
			FileInputStream is = new FileInputStream("config.properties");
			properties.load(is);

			String drivername = properties.getProperty("drivername");
			String pathurl = properties.getProperty("pathurl");
			String username = properties.getProperty("username");
			String pass = properties.getProperty("pass");

			Class.forName(drivername);

			con = DriverManager.getConnection(pathurl, username, pass);

			stmt = con.createStatement();

			System.out.println("Connected Successfully!");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addEmployee(Employee e) {

		try {
			String query = "insert into Employee values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setDouble(3, e.getSalary());
			ps.setString(4, e.getRole());

			ps.executeUpdate();

			System.out.println("Employee added successfully!");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void displayAll() {
		try {
			ResultSet rs = stmt.executeQuery("select * from Employee");
			
			while(rs.next()) {
			 Employee e = new Employee();
			 
			 e.setId(rs.getInt(1));
			 e.setName(rs.getString(2));
			 e.setSalary(rs.getDouble(3));
			 e.setRole(rs.getString(4));
			 
			 System.out.println(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void searchEmployee(int id){
		try {

			String query = "select * from Employee where id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				Employee e= new Employee();

				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setSalary(rs.getDouble("salary"));
				e.setRole(rs.getString("role"));

				System.out.println(e);

			} else {
				System.out.println("Student Not Found!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(Employee e) {

		try {

			String query =
					"update Employee set name=?, salary=?, role=? where id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, e.getName());
			ps.setDouble(2, e.getSalary());
			ps.setString(3, e.getRole());

			int rows = ps.executeUpdate();

			if (rows > 0)
				System.out.println("Employee Updated Successfully!");
			else
				System.out.println("Employee Not Found!");

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void deleteEmployee(int id) {

		try {

			String query = "delete from Employee where id=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1,id);

			int rows = ps.executeUpdate();

			if (rows > 0)
				System.out.println("Employee Deleted Successfully!");
			else
				System.out.println("Employee Not Found!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
