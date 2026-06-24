package Model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {

    List<Employee> employees = new ArrayList<>();

    public EmployeeManagement() {

        employees.add(new Employee(1,"Amit","IT","Developer",25,60000,"Male",2,"Pune",true));
        employees.add(new Employee(2,"Priya","HR","Manager",30,55000,"Female",5,"Mumbai",true));
        employees.add(new Employee(3,"Rahul","Finance","Analyst",28,48000,"Male",3,"Pune",true));
        employees.add(new Employee(4,"Sneha","IT","Developer",26,70000,"Female",4,"Nagpur",true));
        employees.add(new Employee(5,"Rohit","Sales","Executive",32,45000,"Male",5,"Pune",true));
    }

    public void displayAll() {
        employees.forEach(System.out::println);
    }

    public void salaryGreaterThan50000() {
        employees.stream()
                 .filter(e -> e.getSalary() > 50000)
                 .forEach(System.out::println);
    }

    public void itEmployees() {
        employees.stream()
                 .filter(e -> e.getDepartment().equals("IT"))
                 .forEach(System.out::println);
    }

    public void fromPune() {
        employees.stream()
                 .filter(e -> e.getCity().equals("Pune"))
                 .forEach(System.out::println);
    }

    public void ageGreaterThan30() {
        employees.stream()
                 .filter(e -> e.getAge() > 30)
                 .forEach(System.out::println);
    }

    public void isActive() {
        employees.stream()
                 .filter(Employee::isActive)
                 .forEach(System.out::println);
    }

    public void sortByAscending() {
        employees.stream()
                 .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                 .forEach(System.out::println);
    }

    public void sortByDescending() {
        employees.stream()
                 .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                 .forEach(System.out::println);
    }

    public void sortByName() {
        employees.stream()
                 .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                 .forEach(System.out::println);
    }

    public void topFivePaidEmployees() {
        employees.stream()
                 .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                 .limit(5)
                 .forEach(System.out::println);
    }

    public void lowest3Salaries() {
        employees.stream()
                 .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                 .limit(3)
                 .forEach(System.out::println);
    }

    public void employeeCount() {
        System.out.println("Count Employees: " + employees.stream().count());
    }
}