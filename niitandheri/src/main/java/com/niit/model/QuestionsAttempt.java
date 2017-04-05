package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.google.gson.annotations.Expose;

@Entity
public class QuestionsAttempt {
	@Id
	@GenericGenerator(name="seq_id", strategy="com.niit.config.QuestionsAttemptGenerator")
	@GeneratedValue(generator="seq_id")
	@Column(name = "questionsAttemptId", unique = true, nullable = false)
	private String questionsAttemptId;
	@Expose
	private String testPaperId;
	@Expose
	private String question;
	@Expose
	private String attemptedAnswer;
	@Expose
	private String correctAnswer;
	@Expose
	private String studentId;
	@Column(columnDefinition="date")
	private Date dateOfAttempt;
	@Column(columnDefinition="timestamp")
	private Date timeOfAttempt;
	private int marks;	
	private String testAttemptId;
	
	@ManyToOne
	@JoinColumn(name="testAttemptId", insertable=false, updatable=false, nullable=true)
	@Expose
	private TestAttempt testAttempt;
	
	public String getTestAttemptId() {
		return testAttemptId;
	}

	public void setTestAttemptId(String testAttemptId) {
		this.testAttemptId = testAttemptId;
	}

	public TestAttempt getTestAttempt() {
		return testAttempt;
	}

	public void setTestAttempt(TestAttempt testAttempt) {
		this.testAttempt = testAttempt;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@ManyToOne
	@JoinColumn(name="testPaperId",nullable=false, insertable=false, updatable=false)
	@Expose
	private TestPaper testPaper;
	
	@ManyToOne
	@JoinColumn(name="studentId",nullable=false, insertable=false, updatable=false)
	private Student student;

	public QuestionsAttempt() {
		
		Date d=new Date();
		dateOfAttempt=d;
		timeOfAttempt=d;
		
	}

	public String getQuestionsAttemptId() {
		return questionsAttemptId;
	}

	public void setQuestionsAttemptId(String questionsAttemptId) {
		this.questionsAttemptId = questionsAttemptId;
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

	public String getAttemptedAnswer() {
		return attemptedAnswer;
	}

	public void setAttemptedAnswer(String attemptedAnswer) {
		this.attemptedAnswer = attemptedAnswer;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Date getDateOfAttempt() {
		return dateOfAttempt;
	}

	public void setDateOfAttempt(Date dateOfAttempt) {
		this.dateOfAttempt = dateOfAttempt;
	}

	public Date getTimeOfAttempt() {
		return timeOfAttempt;
	}

	public void setTimeOfAttempt(Date timeOfAttempt) {
		this.timeOfAttempt = timeOfAttempt;
	}

	public TestPaper getTestPaper() {
		return testPaper;
	}

	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}	

}
