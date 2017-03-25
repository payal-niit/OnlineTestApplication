package com.niit.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class QuestionsAttempt {
	@Id
	private String questionsAttemptId;
	private String testPaperId;
	private String question;
	private String attemptedAnswer;
	private String correctAnswer;
	private String studentId;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dateOfAttempt;
	@DateTimeFormat(pattern="hh:mm:ss")
	private Date timeOfAttempt;
	
	
	@ManyToOne
	@JoinColumn(name="testPaperId",nullable=false, insertable=false, updatable=false)
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
