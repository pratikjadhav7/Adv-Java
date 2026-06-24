package Model;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String designation;
    private int age;
    private double salary;
    private String gender;
    private int experience;
    private String city;
    private boolean active;

    public Employee(int id, String name, String department, String designation,
                    int age, double salary, String gender,
                    int experience, String city, boolean active) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.experience = experience;
        this.city = city;
        this.active = active;
    }

   
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	@Override
    public String toString() {
        return "Employee [id=" + id +
                ", name=" + name +
                ", department=" + department +
                ", designation=" + designation +
                ", age=" + age +
                ", salary=" + salary +
                ", gender=" + gender +
                ", experience=" + experience +
                ", city=" + city +
                ", active=" + active + "]";
    }
}
