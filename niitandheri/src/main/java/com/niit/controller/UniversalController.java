package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.niit.dao.TestPaperSyllabusDAO;

@ControllerAdvice
public class UniversalController {
	
	@Autowired
	TestPaperSyllabusDAO testPaperSyllabusDAO;
	
	@ModelAttribute
	public void globalAttribute(Model model, HttpSession session) {
		model.addAttribute("courseList", testPaperSyllabusDAO.getCourseList());
		model.addAttribute("syllabusList", testPaperSyllabusDAO.TestPaperSyllabusList());
		
	}

}
