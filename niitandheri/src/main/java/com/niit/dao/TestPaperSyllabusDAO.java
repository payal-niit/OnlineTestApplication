package com.niit.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.model.Course;
import com.niit.model.QuestionsAttempt;
import com.niit.model.TestAttempt;
import com.niit.model.TestPaper;
import com.niit.model.TestPaperSyllabus;
@Repository
public class TestPaperSyllabusDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*-----------------------For Test Paper Syllabus--------------------------------*/
	
	/*----For Adding Test Paper Syllabus----*/
	@Transactional
	public void addTestPaperSyllabus(TestPaperSyllabus testPaperSyllabus) {
		sessionFactory.getCurrentSession().saveOrUpdate(testPaperSyllabus);
	}
	
	/*----For Dropdown of courses name while adding test paper syllabus----*/
	@Transactional
	public List<Course> getCourseList() {
		List<Course> clist = sessionFactory.getCurrentSession().createQuery("from Course").list();
		return clist;
	}
	
	@Transactional
	public List<TestPaperSyllabus> TestPaperSyllabusList() {
		@SuppressWarnings("unchecked")
		List<TestPaperSyllabus> list = sessionFactory.getCurrentSession()
				.createQuery("from TestPaperSyllabus").list();

		return list;
	}
	
	/*----For getting the count of total added ----*/
	@Transactional
	public int retriveCountForTestPaperSyllabus()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<TestPaperSyllabus> list = session.createQuery("from TestPaperSyllabus").list();
		int count = list.size();
		return count;
	}
	
	/*----For generated auto number series for TestPaperSyllabus----*/
	@Transactional
	public String generateIdForTestPaperSyllabus()
	{
		String id;
		int count = retriveCountForTestPaperSyllabus() + 1;
		if(count < 10)
		{
			id = "TESTP0000" + count;
		}
		else if(count < 100)
		{
			id = "TESTP000" + count;
		}
		else if(count < 1000)
		{
			id = "TESTP00" + count;
		}
		else if(count < 10000)
		{
			id = "TESTP0" + count;
		}
		else
		{
			id = "TESTP" + count;
		}
		return id;
	}
	
	/*-----------------------For Test Paper--------------------------------*/
	@Transactional
	public void addTestPaper(TestPaper testPaper) {
		sessionFactory.getCurrentSession().saveOrUpdate(testPaper);
	}
	
	@Transactional
	public String TestPaperListViaJson(String testPaperSyllabusId) {
		@SuppressWarnings("unchecked")
		List<TestPaper> list = sessionFactory.getCurrentSession()
				.createQuery("from TestPaper where testPaperSyllabusId = " + "'" + testPaperSyllabusId + "'").list();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String testPaperdata = gson.toJson(list);
		return testPaperdata;
	}
	@Transactional
	public Set<Course> CourseName() {
		Session session = sessionFactory.getCurrentSession();
		Set<Course> list = (Set<Course>) session.createQuery("Select courseName from Course").list();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String data = gson.toJson(list);
		return list;
		
	}
	@Transactional
	public List<TestPaperSyllabus> TestPaperSyllabusListByCourse(String courseId) {
		Session session = sessionFactory.getCurrentSession();
		List<TestPaperSyllabus> list = session.createQuery("Select testPaperSyllabusContent from TestPaperSyllabus where courseId = "+"'"+courseId+"'").list();
		return list;
		
	}
	

	@Transactional
	public List<TestPaper> TestPaperList(String testPaperSyllabusId) {
		@SuppressWarnings("unchecked")
		List<TestPaper> list = sessionFactory.getCurrentSession()
				.createQuery("from TestPaper where testPaperSyllabusId = " + "'" + testPaperSyllabusId + "'").list();

		return list;
	}
	
	@Transactional
	public int retriveCountForTestPaper()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<TestPaper> list = session.createQuery("from TestPaper").list();
		int count = list.size();
		return count;
	}
	
	@Transactional
	public String generateIdForTestPaper()
	{
		String id;
		int count = retriveCountForTestPaper() + 1;
		if(count < 10)
		{
			id = "QST0000" + count;
		}
		else if(count < 100)
		{
			id = "QST000" + count;
		}
		else if(count < 1000)
		{
			id = "QST00" + count;
		}
		else if(count < 10000)
		{
			id = "QST0" + count;
		}
		else
		{
			id = "QST" + count;
		}
		return id;
	}
	
	
	/*-----------------------For generating Test Paper--------------------------------*/
	
	@Transactional
	public String generateQuestionPaper(String testPaperSyllabusId) {
		List<TestPaper>list = sessionFactory.getCurrentSession().createQuery("from TestPaper where testPaperSyllabusId = "+"'"+testPaperSyllabusId+"'").list();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String data = gson.toJson(list);
		return data;
	}
	
	@Transactional
	public TestPaper getQuestionById(String testPaperId) {
		List<TestPaper>list = sessionFactory.getCurrentSession().createQuery("from TestPaper where testPaperId = "+"'"+testPaperId+"'").list();
		
		return list.get(0);
	}
	
	@Transactional
	public TestPaperSyllabus getTestPaperSyllabusName(String testPaperSyllabusId) {
		List<TestPaperSyllabus> name = sessionFactory.getCurrentSession().createQuery("from TestPaperSyllabus where testPaperSyllabusId = "+"'"+testPaperSyllabusId+"'").list();
		return name.get(0);
		
	}
	
	@Transactional
	public void saveAnswers(QuestionsAttempt questionsAttempt) {
		sessionFactory.getCurrentSession().saveOrUpdate(questionsAttempt);
	}
	
	@Transactional
	public int retriveCountForTestPaperAttempt()
	{
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<QuestionsAttempt> list = session.createQuery("from QuestionsAttempt").list();
		int count = list.size();
		return count;
	}
	
	@Transactional
	public String generateIdForTestPaperAttempt()
	{
		String id;
		int count = retriveCountForTestPaperAttempt() + 1;
		if(count < 10)
		{
			id = "TST0000" + count;
		}
		else if(count < 100)
		{
			id = "TST000" + count;
		}
		else if(count < 1000)
		{
			id = "TST00" + count;
		}
		else if(count < 10000)
		{
			id = "TST0" + count;
		}
		else
		{
			id = "TST" + count;
		}
		return id;
	}
	
	
}
