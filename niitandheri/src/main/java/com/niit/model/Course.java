package com.niit.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.google.gson.annotations.Expose;
@Entity
public class Course {
	
	@Id
	@Expose
	private String courseId;
	@Expose
	private String courseName;
	
	@JsonIgnore
	@OneToMany(mappedBy="course", fetch = FetchType.EAGER)	
	private Set<TestPaperSyllabus> testPaperSyllabus;
	
	public Set<TestPaperSyllabus> getTestPaperSyllabus() {
		return testPaperSyllabus;
	}
	public void setTestPaperSyllabus(Set<TestPaperSyllabus> testPaperSyllabus) {
		this.testPaperSyllabus = testPaperSyllabus;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	

}
