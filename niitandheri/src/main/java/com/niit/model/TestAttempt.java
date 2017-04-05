package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;
@Entity
public class TestAttempt {
	@Id
	@GenericGenerator(name="seq_id", strategy="com.niit.config.TestAttemptGenerator")
	@GeneratedValue(generator="seq_id")
	@Column(name = "testAttemptId", unique = true, nullable = false)
	@Expose
	private String testAttemptId;
	
	private String studentId;
	@Expose
	private int totalNoOfQuestions;
	@Expose
	private int totalNoOfCorrect;
	@Expose
	private int totalNoOfWrong;
	@Expose
	private String testPaperSyllabusId;
	@Expose
	private int totalMarks;
	@Expose
	private int marksObtained;
	@Expose
	private double percentageObtained;
	@Column(columnDefinition="timestamp")
	private Date attemptedDate;
	@ManyToOne
	@JoinColumn(name="studentId",nullable=false, insertable=false, updatable=false)
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="testPaperSyllabusId",nullable=false, insertable=false, updatable=false)
	private TestPaperSyllabus testPaperSyllabus;

	public String getTestAttemptId() {
		return testAttemptId;
	}

	public void setTestAttemptId(String testAttemptId) {
		this.testAttemptId = testAttemptId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getTotalNoOfQuestions() {
		return totalNoOfQuestions;
	}

	public void setTotalNoOfQuestions(int totalNoOfQuestions) {
		this.totalNoOfQuestions = totalNoOfQuestions;
	}

	public int getTotalNoOfCorrect() {
		return totalNoOfCorrect;
	}

	public void setTotalNoOfCorrect(int totalNoOfCorrect) {
		this.totalNoOfCorrect = totalNoOfCorrect;
	}

	public int getTotalNoOfWrong() {
		return totalNoOfWrong;
	}

	public void setTotalNoOfWrong(int totalNoOfWrong) {
		this.totalNoOfWrong = totalNoOfWrong;
	}

	public String getTestPaperSyllabusId() {
		return testPaperSyllabusId;
	}

	public void setTestPaperSyllabusId(String testPaperSyllabusId) {
		this.testPaperSyllabusId = testPaperSyllabusId;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int temp) {
		this.marksObtained = temp;
	}

	public double getPercentageObtained() {
		return percentageObtained;
	}

	public void setPercentageObtained(double percentageObtained) {
		this.percentageObtained = percentageObtained;
	}

	public Date getAttemptedDate() {
		return attemptedDate;
	}

	public void setAttemptedDate(Date attemptedDate) {
		this.attemptedDate = attemptedDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TestPaperSyllabus getTestPaperSyllabus() {
		return testPaperSyllabus;
	}

	public void setTestPaperSyllabus(TestPaperSyllabus testPaperSyllabus) {
		this.testPaperSyllabus = testPaperSyllabus;
	}
	
}
