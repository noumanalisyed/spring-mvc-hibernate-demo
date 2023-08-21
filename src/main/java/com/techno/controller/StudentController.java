package com.techno.controller;

import com.techno.bean.Student;
import com.techno.service.CourseService;
import com.techno.service.RegistrationService;
import com.techno.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("command") Student student,
			BindingResult result) {
		studentService.addStudent(student);
		return new ModelAndView("redirect:/addStudent.html");
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public ModelAndView addStudent(@ModelAttribute("command")  Student student,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students",  studentService.getStudents());
		model.put("registrations",  registrationService.getRegistrations());
		return new ModelAndView("addStudent", model);
	}
	
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@ModelAttribute("command")  Student student,
			BindingResult result) {
		studentService.deleteStudent(student.getStudentId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("students",  studentService.getStudents());
		model.put("registrations",  registrationService.getRegistrations());
		return new ModelAndView("addStudent", model);
	}
	
	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	public ModelAndView editStudent(@ModelAttribute("command")  Student student,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("student",  studentService.getStudent(student.getStudentId()));
		model.put("students",  studentService.getStudents());
		model.put("registrations",  registrationService.getRegistrations());
		return new ModelAndView("addStudent", model);
	}
	
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
}
