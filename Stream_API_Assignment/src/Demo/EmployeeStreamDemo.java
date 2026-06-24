package Demo;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Employee {
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


public class EmployeeStreamDemo {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1,"Amit","IT","Developer",25,60000,"Male",2,"Pune",true));
        employees.add(new Employee(2,"Priya","HR","Manager",30,55000,"Female",5,"Mumbai",true));
        employees.add(new Employee(3,"Rahul","Finance","Analyst",28,48000,"Male",3,"Pune",true));
        employees.add(new Employee(4,"Sneha","IT","Developer",26,70000,"Female",4,"Nagpur",true));
        employees.add(new Employee(5,"Rohit","Sales","Executive",32,45000,"Male",5,"Pune",true));
        
        System.out.println("All Employees:");
        employees.stream().forEach(System.out::println);
        
        System.out.println("\nEmployees with salary > 50000: ");
        employees.stream().filter(e->e.getSalary()>50000).forEach(x->System.out.println(x));
        
        System.out.println("\nIT department employees: ");
        employees.stream().filter(e->e.getDepartment()=="IT").forEach(x->System.out.println(x));
        
        System.out.println(" \nEmployees from Pune: ");
        employees.stream().filter(e->e.getCity()=="Pune").forEach(x->System.out.println(x));
        
        System.out.println(" \nEmployees age > 30: ");
        employees.stream().filter(e->e.getAge()>30).forEach(x->System.out.println(x));
        
        System.out.println("\nActive employees only: ");
        employees.stream().filter(e->e.isActive()==true).forEach(x->System.out.println(x));
        
        System.out.println("\nSort by salary ascending: ");
        employees.stream().sorted((e1,e2)->Double.compare(e1.getSalary(), e2.getSalary())).forEach(x->System.out.println(x));
        
        System.out.println("\nSort by salary descending:");
        employees.stream().sorted((e1,e2)->Double.compare(e2.getSalary(),e1.getSalary())).forEach(x->System.out.println(x));
        
        System.out.println("\nSort by Name: ");
        employees.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).forEach(x->System.out.println(x));
        
        System.out.println("\nTop 5 highest paid employees: ");
        employees.stream().sorted((e1,e2)->Double.compare(e2.getSalary(),e1.getSalary())).limit(5).forEach(x->System.out.println(x));
        
        System.out.println("\nLowest 3 Salaries:");
        employees.stream().sorted((e1,e2)->Double.compare(e1.getSalary(),e2.getSalary())).limit(3).forEach(x->System.out.println(x));
        
        System.out.println("\n Count employees: "+employees.stream().count());
        

        
    }
}
