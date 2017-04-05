package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Student;
import com.niit.model.TestPaper;

@Repository
public class StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addUser(Student student) {
		sessionFactory.getCurrentSession().save(student);
	}
	
	@Transactional
	public Student getStudentByName(String studentId) {
		List<Student>list = sessionFactory.getCurrentSession().createQuery("from Student where studentId = "+"'"+studentId+"'").list();
		
		return list.get(0);
	}
	
	@Transactional
	public List<Student> getStudents() {
		List<Student>list = sessionFactory.getCurrentSession().createQuery("from Student").list();
		
		return list;
	}

}
