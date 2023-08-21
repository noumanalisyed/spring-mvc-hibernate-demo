package com.techno.dao;

import com.techno.bean.Course;

import java.util.List;

public interface CourseDao {
	
	public void addCourse(Course course);
	
	public List<Course> getCourses();
	
	public Course getCourse(int categoryId);
	
	public void deleteCourse(int courseId);
}
