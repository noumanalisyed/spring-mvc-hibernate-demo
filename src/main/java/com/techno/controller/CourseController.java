package com.techno.controller;

import com.techno.bean.Course;
import com.techno.service.CourseService;
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
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/saveCourse", method = RequestMethod.POST)
	public ModelAndView saveCourse(@ModelAttribute("command") Course course,
								   BindingResult result) {
		courseService.addCourse(course);
		return new ModelAndView("redirect:/addCourse.html");
	}
	
	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public ModelAndView addCourse(@ModelAttribute("command")  Course course,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("courses",  courseService.getCourses());
		return new ModelAndView("addCourse", model);
	}
	
	@RequestMapping(value = "/deleteCourse", method = RequestMethod.GET)
	public ModelAndView deleteCourse(@ModelAttribute("command")  Course course,
			BindingResult result) {
		courseService.deleteCourse(course.getCourseId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("courses",  courseService.getCourses());
		return new ModelAndView("addCourse", model);
	}
	
	@RequestMapping(value = "/editCourse", method = RequestMethod.GET)
	public ModelAndView editCourse(@ModelAttribute("command")  Course course,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("course",  courseService.getCourse(course.getCourseId()));
		model.put("courses",  courseService.getCourses());
		return new ModelAndView("addCourse", model);
	}
	
	@RequestMapping(value="/courses", method = RequestMethod.GET)
	public List<Course> getCourses() {
		return courseService.getCourses();
	}
}
