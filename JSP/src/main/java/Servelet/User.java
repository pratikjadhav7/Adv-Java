package Servelet;

import java.time.LocalDate;

public class User {

	String username;
	String pass;
	long mobo;
	String address;
	LocalDate dob;
	public User(String username, String pass, long mobo, String address, LocalDate dob) {
		super();
		this.username = username;
		this.pass = pass;
		this.mobo = mobo;
		this.address = address;
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public long getMobo() {
		return mobo;
	}
	public void setMobo(long mobo) {
		this.mobo = mobo;
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
	
	
}
