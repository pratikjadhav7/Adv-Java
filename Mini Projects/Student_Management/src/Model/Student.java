package Model;

import java.time.LocalDate;

public class Student {

    private int rollNo;
    private String name;
    private double marks;
    private String mobileNo;
    private String address;
    private LocalDate dob;

    // Default Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student(int rollNo, String name, double marks, String mobileNo, String address, LocalDate dob) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
        this.mobileNo = mobileNo;
        this.address = address;
        this.dob = dob;
    }

    // Getters and Setters
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student [rollNo=" + rollNo +
               ", name=" + name +
               ", marks=" + marks +
               ", mobileNo=" + mobileNo +
               ", address=" + address +
               ", dob=" + dob + "]";
    }
}