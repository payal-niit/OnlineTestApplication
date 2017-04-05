package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
				
		ModelAndView m=new ModelAndView("index");
		return m;
	}
	
	@RequestMapping("/course")
	public ModelAndView getCoursePage(Model model) {
		model.addAttribute("course", new Course());
		
		ModelAndView m=new ModelAndView("course");
		return m;
	}
	
	@RequestMapping("/addcourse")
	public ModelAndView addCourse(@ModelAttribute("course")Course course) {
		testPaperSyllabusDAO.addCourse(course);
		ModelAndView m=new ModelAndView("redirect:/course");
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
		//testPaperSyllabus.setTestPaperSyllabusId(testPaperSyllabusDAO.generateIdForTestPaperSyllabus());
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
		//testPaper.setTestPaperId(testPaperSyllabusDAO.generateIdForTestPaper());
		testPaperSyllabusDAO.addTestPaper(testPaper);
		
		/*String path= "E:\\OnlineNIITApplication\\niitandheri\\src\\main\\webapp\\resources\\images\\testpaperimages\\";
		path = path+""+testPaper.getTestPaperId()+".jpg";
		try
		{
		File f = new File(path);
		MultipartFile m = testPaper.getTestPaperImage();
		byte[] b = m.getBytes();
		FileOutputStream fos = new FileOutputStream(f);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write(b);
		bos.close();
		}
		catch (Exception e) {
			System.out.println("ERROR WHILE IMAGE INPUT");
		}*/
		
		ModelAndView m=new ModelAndView("redirect:/testpaper");
		return m;
	}
	
	
	
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public @ResponseBody
	Set<Course> findAllCourses() {
		
		return this.testPaperSyllabusDAO.CourseName();
	}
	
	@RequestMapping("/test-{testPaperSyllabusId}")
	public ModelAndView generateTestPaper(@PathVariable("testPaperSyllabusId")String testPaperSyllabusId,Model model,HttpSession session) {
		//getting the whole set of questions for a particular syllabus
		List<TestPaper> list = testPaperSyllabusDAO.generateQuestionPaperByJSTL(testPaperSyllabusId);
		
		// for shuffling the questions
		Collections.shuffle(list);
		
		//for limiting the list to a particular number
		List<TestPaper> second = new ArrayList<TestPaper>(list.subList(0, 2));
		model.addAttribute("questionSet", second);
		
		/*model.addAttribute("optionSet", testPaperSyllabusDAO.getOptions(testPaperSyllabusId));
		System.out.println("reached here");*/
		SubmitMultipleQuestions submitMultipleQuestions=new SubmitMultipleQuestions();
		model.addAttribute("submitMultipleQuestions", submitMultipleQuestions);
		
		List<QuestionsAttempt> noOfAttempts = new ArrayList<QuestionsAttempt>();
		for(int i=0; i<10; i++) {
			noOfAttempts.add(new QuestionsAttempt());
	    }
		submitMultipleQuestions.setNoOfAttempts(noOfAttempts);
		
		//model.addAttribute("questionsAttempt", new QuestionsAttempt());
		model.addAttribute("testPaperTopic", testPaperSyllabusDAO.getTestPaperSyllabusName(testPaperSyllabusId));
		session.setAttribute("testPaperSyllabusId", testPaperSyllabusId);
		String temp=(String) session.getAttribute("testPaperSyllabusId");
		System.out.println("Test syllabus id: "+temp);
		ModelAndView m=new ModelAndView("questionset");
		
		return m;
	}
	/*@InitBinder("submitMultipleQuestions")
	public void dataBinding(WebDataBinder binder) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "dateOfAttempt", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "timeOfAttempt", new CustomDateEditor(timeFormat, true));
	}*/
	
	@RequestMapping("/submitTest")
	public String submitTest(@ModelAttribute("submitMultipleQuestions")SubmitMultipleQuestions submitMultipleQuestions,Principal p,HttpSession session) {
		int totalMarksPaper = 0;
		int totalMarksObtained = 0;
		int totalQuestionsCount=0;
		int totalQuestionsCorrectCount=0;
		int totalQuestionsNotCorrectCount=0;
		int totalMarksNotObtained=0;
		
		for(QuestionsAttempt questionsAttempt : submitMultipleQuestions.getNoOfAttempts()) {
			//questionsAttempt.setQuestionsAttemptId(testPaperSyllabusDAO.generateIdForTestPaperAttempt());
			questionsAttempt.setStudentId(p.getName());
			testPaperSyllabusDAO.saveAnswers(questionsAttempt);
			questionsAttempt.setCorrectAnswer(testPaperSyllabusDAO.generateTestPaperById(questionsAttempt.getTestPaperId()).getAnswer());
			testPaperSyllabusDAO.saveAnswers(questionsAttempt);
			session.setAttribute("qst", questionsAttempt); 
			
			String q=(String) session.getAttribute(questionsAttempt.getQuestionsAttemptId());
			session.setAttribute("q", q); 
			
			System.out.println("questions are"+q);
			
			int marks=questionsAttempt.getMarks();
			int countQ=1;
			totalQuestionsCount=countQ+totalQuestionsCount;
			totalMarksPaper=marks+totalMarksPaper;
			
			System.out.println("Marks are:"+marks);
			System.out.println("Marks are:"+totalMarksPaper);
			System.out.println("total questions are:"+totalQuestionsCount);
			
			try {
				if(questionsAttempt.getAttemptedAnswer().equals(questionsAttempt.getCorrectAnswer())) {
					int marksOb=questionsAttempt.getMarks();
					int count=1;
					totalQuestionsCorrectCount=count+totalQuestionsCorrectCount;
					totalMarksObtained=marksOb+totalMarksObtained;
					System.out.println("Marks obtained are:"+marksOb);
					System.out.println("Marks obtained are:"+totalMarksObtained);
					System.out.println("total number of Questions correct:"+totalQuestionsCorrectCount);
				}
				else {
					int marksOb=questionsAttempt.getMarks();
					int count=1;
					totalQuestionsNotCorrectCount=count+totalQuestionsNotCorrectCount;
					totalMarksNotObtained=marksOb+totalMarksNotObtained;
					System.out.println("Marks not obtained are:"+marksOb);
					System.out.println("Marks not obtained are:"+totalMarksObtained);
					System.out.println("total number of Questions not correct:"+totalQuestionsNotCorrectCount);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    }
		System.out.println("total Marks paper:"+totalMarksPaper);
		System.out.println("total no of questions:"+totalQuestionsCount);
		System.out.println("---------------------------------------------");
		System.out.println("total Marks Obtained:"+totalMarksObtained);
		System.out.println("total corrent q correct:"+totalQuestionsCorrectCount);
		System.out.println("total number of Questions not correct:"+totalQuestionsNotCorrectCount);
		
		Date d=new Date();
		String temp=(String) session.getAttribute("testPaperSyllabusId");
		
		TestAttempt testAttempt=new TestAttempt();
		
		testAttempt.setAttemptedDate(d);
		testAttempt.setMarksObtained(totalMarksObtained);
		session.setAttribute("totalMarksObtained", totalMarksObtained);
		testAttempt.setPercentageObtained(totalMarksObtained*100/totalMarksPaper);
		session.setAttribute("totalPercentageObtained", totalMarksObtained*100/totalMarksPaper);
		testAttempt.setStudentId(p.getName());		
		testAttempt.setTestPaperSyllabusId(temp);
		testAttempt.setTotalMarks(totalMarksPaper);
		testAttempt.setTotalNoOfCorrect(totalQuestionsCorrectCount);
		testAttempt.setTotalNoOfQuestions(totalQuestionsCount);
		testAttempt.setTotalNoOfWrong(totalQuestionsNotCorrectCount);
		
		testPaperSyllabusDAO.addTestAttemptDetails(testAttempt);
		session.setAttribute("testAttemptId", testAttempt.getTestAttemptId());
		for(QuestionsAttempt questionsAttempt : submitMultipleQuestions.getNoOfAttempts()) {
			questionsAttempt.setTestAttemptId(testAttempt.getTestAttemptId());
			questionsAttempt.setStudentId(p.getName());
			testPaperSyllabusDAO.saveAnswers(questionsAttempt);
		}
		
		
		//testPaperSyllabusDAO.saveAnswers(questionsAttempt);
		return "redirect:/result";
	}
	@RequestMapping("/result")
	public String getResult(HttpSession session,Model model) {
		String testAttemptId=(String) session.getAttribute("testAttemptId");
		System.out.println("Test attempt id:"+testAttemptId);
		model.addAttribute("questionsAttempted",testPaperSyllabusDAO.getAttemptedTestDetails(testAttemptId));
		model.addAttribute("questionsAttemptedJSTL",testPaperSyllabusDAO.getAttemptedTestDetailsByJSTL(testAttemptId));
		
		TestAttempt t=testPaperSyllabusDAO.getAttemptedTest(testAttemptId);
		model.addAttribute("mydata", testPaperSyllabusDAO.getAttemptedTest(testAttemptId));
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String data = gson.toJson(t);
		model.addAttribute("data", data);
		
		return "result";
	}
	
	

}
