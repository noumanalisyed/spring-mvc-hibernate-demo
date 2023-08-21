package com.techno.service;

import com.techno.bean.Course;
import com.techno.dao.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("courseService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCourse(Course course) {
		courseDao.addCourse(course);
	}

	@Override
	public List<Course> getCourses() {
		return courseDao.getCourses();
	}

	@Override
	public Course getCourse(int courseId) {
		return courseDao.getCourse(courseId);
	}

	@Override
	public void deleteCourse(int courseId) {
		courseDao.deleteCourse(courseId);
	}

}
