package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
@Entity
public class TestPaperSyllabus {
	@Id
	@GenericGenerator(name="seq_id", strategy="com.niit.config.TestPaperSyllabusGenerator")
	@GeneratedValue(generator="seq_id")
	@Column(name = "testPaperSyllabusId", unique = true, nullable = false)
	@Expose
	private String testPaperSyllabusId;
	
	@Column(name = "courseId")
	private String courseId;
	private String testPaperSyllabusContent;
	
	@ManyToOne
	@JoinColumn(name="courseId",nullable=false, insertable=false, updatable=false)
	private Course course;
	
	public String getTestPaperSyllabusId() {
		return testPaperSyllabusId;
	}
	public void setTestPaperSyllabusId(String testPaperSyllabusId) {
		this.testPaperSyllabusId = testPaperSyllabusId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getTestPaperSyllabusContent() {
		return testPaperSyllabusContent;
	}
	public void setTestPaperSyllabusContent(String testPaperSyllabusContent) {
		this.testPaperSyllabusContent = testPaperSyllabusContent;
	}
	
	
}
