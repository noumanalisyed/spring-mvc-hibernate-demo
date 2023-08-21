package com.techno.service;

import com.techno.bean.Course;

import java.util.List;

public interface CourseService {
	
	public void addCourse(Course course);
	
	public List<Course> getCourses();
	
	public Course getCourse(int courseId);
	
	public void deleteCourse(int courseId);

}
