package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String addUser(@Valid @ModelAttribute("student")Student student,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "registerandlogin";
		}
		String dummy=student.getStudentId();
		System.out.println("dummy="+dummy);
		
		List<Student> usersDetailList=studentDAO.getStudents();
        for (int i=0; i< usersDetailList.size(); i++) {
            if(student.getStudentId().equals(usersDetailList.get(i).getStudentId())) {
            	String msg="You have already been registered";   
            	model.addAttribute("msg", msg);
            	System.out.println("reached here / user exist");
            	return "registerandlogin";
            }
        }          	
            	studentDAO.addUser(student);
            	String msg="You have successfully registered";   
            	model.addAttribute("msg", msg);
            	System.out.println("reached here / user created");		
            	return "redirect:/";
	}
	
	@RequestMapping("/perform_logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}		
		return "redirect:/";
		
	}

}
