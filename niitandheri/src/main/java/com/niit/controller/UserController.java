package com.niit.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.StudentDAO;
import com.niit.model.Student;

@Controller
public class UserController {
	@Autowired
	private StudentDAO studentDAO;
	
	@RequestMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("student", new Student());
		return "registerandlogin";
	}
	
	@RequestMapping("/register")
	public String getRegistrationPage(Model model) {
		model.addAttribute("student", new Student());
		return "registerandlogin";
	}
	
	@RequestMapping("/addStudent")
	public String addUser(@ModelAttribute("student")Student student) {
		Date d=new Date();
		//student.setDob(d);
		studentDAO.addUser(student);
		return "redirect:/";
	}

}
