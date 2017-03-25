package com.niit.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.config.SubmitMultipleQuestions;
import com.niit.dao.StudentDAO;
import com.niit.dao.TestPaperSyllabusDAO;
import com.niit.model.Course;
import com.niit.model.QuestionsAttempt;
import com.niit.model.TestAttempt;
import com.niit.model.TestPaper;
import com.niit.model.TestPaperSyllabus;

@Controller
public class MainController {
	@Autowired
	TestPaperSyllabusDAO testPaperSyllabusDAO;
	@Autowired
	StudentDAO studentDAO;
	
	@RequestMapping("/")
	public ModelAndView getHome(Principal p,Model model) {
		
		try {
			String fname=studentDAO.getStudentByName(p.getName()).getFname();
			String lname=studentDAO.getStudentByName(p.getName()).getLname();
			model.addAttribute("name", fname+" "+lname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView m=new ModelAndView("index");
		return m;
	}
	
	@RequestMapping("/testsyllabus")
	public ModelAndView getTestPaperSyllabusPage(Model model) {
		model.addAttribute("testPaperSyllabus", new TestPaperSyllabus());
		
		ModelAndView m=new ModelAndView("testsyllabus");
		return m;
	}
	
	@RequestMapping("/addtestsyllabus")
	public ModelAndView addTestPaperSyllabus(@ModelAttribute("testPaperSyllabus")TestPaperSyllabus testPaperSyllabus) {
		testPaperSyllabus.setTestPaperSyllabusId(testPaperSyllabusDAO.generateIdForTestPaperSyllabus());
		testPaperSyllabusDAO.addTestPaperSyllabus(testPaperSyllabus);
		ModelAndView m=new ModelAndView("redirect:/testsyllabus");
		return m;
	}
	
	
	@RequestMapping("/testpaper")
	public ModelAndView getTestPaperPage(Model model) {
		model.addAttribute("testPaper", new TestPaper());
		
		ModelAndView m=new ModelAndView("testpaper");
		return m;
	}
	
	@RequestMapping("/addtestpaper")
	public ModelAndView addTestPaper(@ModelAttribute("testPaper")TestPaper testPaper) {
		testPaper.setTestPaperId(testPaperSyllabusDAO.generateIdForTestPaper());
		testPaperSyllabusDAO.addTestPaper(testPaper);
		ModelAndView m=new ModelAndView("redirect:/testpaper");
		return m;
	}
	
	
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public @ResponseBody
	Set<Course> findAllCourses() {
		
		return this.testPaperSyllabusDAO.CourseName();
	}
	
	@RequestMapping("/test-{testPaperSyllabusId}")
	public ModelAndView generateTestPaper(@PathVariable("testPaperSyllabusId")String testPaperSyllabusId,Model model) {
		model.addAttribute("questionSet", testPaperSyllabusDAO.generateQuestionPaper(testPaperSyllabusId));
		
		SubmitMultipleQuestions submitMultipleQuestions=new SubmitMultipleQuestions();
		model.addAttribute("submitMultipleQuestions", submitMultipleQuestions);
		
		List<QuestionsAttempt> noOfAttempts = new ArrayList<QuestionsAttempt>();
		for(int i=0; i<10; i++) {
			noOfAttempts.add(new QuestionsAttempt());
	    }
		submitMultipleQuestions.setNoOfAttempts(noOfAttempts);
		
		//model.addAttribute("questionsAttempt", new QuestionsAttempt());
		model.addAttribute("testPaperTopic", testPaperSyllabusDAO.getTestPaperSyllabusName(testPaperSyllabusId));
		
		ModelAndView m=new ModelAndView("questionset");
		
		return m;
	}
	
	
	@RequestMapping("/submitTest")
	public ModelAndView submitTest(@ModelAttribute("submitMultipleQuestions")SubmitMultipleQuestions submitMultipleQuestions,Principal p) {
		
		for(QuestionsAttempt questionsAttempt : submitMultipleQuestions.getNoOfAttempts()) {
			questionsAttempt.setQuestionsAttemptId(testPaperSyllabusDAO.generateIdForTestPaperAttempt());
			questionsAttempt.setStudentId(p.getName());
			testPaperSyllabusDAO.saveAnswers(questionsAttempt);
		    }
				
		ModelAndView m=new ModelAndView("redirect:/");
		return m;
	}

}
