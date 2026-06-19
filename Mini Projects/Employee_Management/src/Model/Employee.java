package Model;

public class Employee {

    private int id;
    private String name;
    private double salary;
    private String role;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(int id, String name, double salary, String role) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    // Getters and Setters
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // toString()
    @Override
    public String toString() {
        return "Employee [id=" + id +
               ", name=" + name +
               ", salary=" + salary +
               ", role=" + role + "]";
    }
}
