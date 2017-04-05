package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.annotations.Expose;

@Entity
public class TestPaper {
	@Id
	@GenericGenerator(name="seq_id", strategy="com.niit.config.TestPaperGenerator")
	@GeneratedValue(generator="seq_id")
	@Column(name = "testPaperId", unique = true, nullable = false)
	@Expose
	private String testPaperId;
	
	@Expose
	private String question;
	@Expose
	private String option1;
	@Expose
	private String option2;
	@Expose
	private String option3;
	@Expose
	private String option4;
	@Expose
	private String answer;
	@Expose
	private int marks;
	@Transient
	private MultipartFile testPaperImage;	
	
	public MultipartFile getTestPaperImage() {
		return testPaperImage;
	}
	public void setTestPaperImage(MultipartFile testPaperImage) {
		this.testPaperImage = testPaperImage;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	private String testPaperSyllabusId;
	@ManyToOne
	@JoinColumn(name="testPaperSyllabusId",nullable=false, insertable=false, updatable=false)
	private TestPaperSyllabus testPaperSyllabus;
	
	
	@Column(name = "courseId")
	private String courseId;
	@ManyToOne
	@JoinColumn(name="courseId",nullable=false, insertable=false, updatable=false)
	private Course course;
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getTestPaperId() {
		return testPaperId;
	}
	public void setTestPaperId(String testPaperId) {
		this.testPaperId = testPaperId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getTestPaperSyllabusId() {
		return testPaperSyllabusId;
	}
	public void setTestPaperSyllabusId(String testPaperSyllabusId) {
		this.testPaperSyllabusId = testPaperSyllabusId;
	}
	public TestPaperSyllabus getTestPaperSyllabus() {
		return testPaperSyllabus;
	}
	public void setTestPaperSyllabus(TestPaperSyllabus testPaperSyllabus) {
		this.testPaperSyllabus = testPaperSyllabus;
	}
	

}
