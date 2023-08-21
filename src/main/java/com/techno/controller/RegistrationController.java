package com.techno.controller;

import com.techno.bean.Registration;
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
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/saveRegistration", method = RequestMethod.POST)
	public ModelAndView saveRegistration(@ModelAttribute("command") Registration registration,
										 BindingResult result) {
		registrationService.addRegistration(registration);
		return new ModelAndView("redirect:/addRegistration.html");
	}
	
	@RequestMapping(value = "/addRegistration", method = RequestMethod.GET)
	public ModelAndView addRegistration(@ModelAttribute("command")  Registration registration,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("registrations",  registrationService.getRegistrations());
		model.put("courses",  courseService.getCourses());
		model.put("students",  studentService.getStudents());
		return new ModelAndView("addRegistration", model);
	}
	
	@RequestMapping(value = "/deleteRegistration", method = RequestMethod.GET)
	public ModelAndView deleteRegistration(@ModelAttribute("command")  Registration registration,
			BindingResult result) {
		registrationService.deleteRegistration(registration.getRegistrationId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("registrations",  registrationService.getRegistrations());
		return new ModelAndView("addRegistration", model);
	}
	
	@RequestMapping(value = "/editRegistration", method = RequestMethod.GET)
	public ModelAndView editRegistration(@ModelAttribute("command")  Registration registration,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("registration",  registrationService.getRegistration(registration.getRegistrationId()));
		model.put("registrations",  registrationService.getRegistrations());
		return new ModelAndView("addRegistration", model);
	}
	
	@RequestMapping(value="/registrations", method = RequestMethod.GET)
	public List<Registration> getRegistrations() {
		return registrationService.getRegistrations();
	}
}
