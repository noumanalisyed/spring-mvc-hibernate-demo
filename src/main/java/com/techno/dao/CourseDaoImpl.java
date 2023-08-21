package com.techno.dao;

import com.techno.bean.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
@Repository("courseDao")
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCourse(Course course) {
		sessionFactory.getCurrentSession().saveOrUpdate(course);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getCourses() {
		return (List<Course>) sessionFactory.getCurrentSession().createCriteria(Course.class).list();
	}

	@Override
	public Course getCourse(int courseId) {
		return (Course) sessionFactory.getCurrentSession().get(Course.class, courseId);
	}

	@Override
	public void deleteCourse(int courseId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Course WHERE courseId = "+courseId).executeUpdate();
	}

}
