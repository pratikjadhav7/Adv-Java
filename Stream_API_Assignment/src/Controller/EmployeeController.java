package Controller;

import Service.EmployeeService;

public class EmployeeController {

    EmployeeService sv = new EmployeeService();

    public void displayAll() {
        sv.displayAll();
    }

    public void salaryGreaterThan50000() {
        sv.salaryGreaterThan50000();
    }

    public void itEmployees() {
        sv.itEmployees();
    }

    public void fromPune() {
        sv.fromPune();
    }

    public void ageGreaterThan30() {
        sv.ageGreaterThan30();
    }

    public void isActive() {
        sv.isActive();
    }

    public void sortByAscending() {
        sv.sortByAscending();
    }

    public void sortByDescending() {
        sv.sortByDescending();
    }

    public void sortByName() {
        sv.sortByName();
    }

    public void topFivePaidEmployees() {
        sv.topFivePaidEmployees();
    }

    public void lowest3Salaries() {
        sv.lowest3Salaries();
    }

    public void employeeCount() {
        sv.employeeCount();
    }
}