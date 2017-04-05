package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student {	
	@Id
	@NotEmpty(message="Student ID cannot be empty")
	private String studentId;
	
	@Size(min=6,max=15,message="Minimum length required is 6")	
	private String password;
	@NotEmpty(message="FirstName cannot be empty")
	private String fname;
	
	@NotEmpty(message="LastName cannot be empty")
	private String lname;
	private int enabled;	
	private String dob;	
	private String role;
	
	public Student() {
		enabled=1;
		role="ROLE_STUDENT";
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	

}
