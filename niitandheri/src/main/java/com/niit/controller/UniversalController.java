package com.niit.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.niit.dao.StudentDAO;
import com.niit.dao.TestPaperSyllabusDAO;

@ControllerAdvice
public class UniversalController {
	
	@Autowired
	TestPaperSyllabusDAO testPaperSyllabusDAO;
	@Autowired
	StudentDAO studentDAO;
	
	@ModelAttribute
	public void globalAttribute(Model model, HttpSession session,Principal p) {
		try {
			model.addAttribute("courseList", testPaperSyllabusDAO.getCourseList());
			model.addAttribute("syllabusList", testPaperSyllabusDAO.TestPaperSyllabusList());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		model.addAttribute("logout", "You have been successfully logged out");

		try {
			String fname=studentDAO.getStudentByName(p.getName()).getFname();
			String lname=studentDAO.getStudentByName(p.getName()).getLname();
			model.addAttribute("name", fname+" "+lname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
