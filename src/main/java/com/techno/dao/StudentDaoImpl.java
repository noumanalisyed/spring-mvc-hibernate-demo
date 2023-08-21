package com.techno.dao;

import com.techno.bean.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudents() {
		return (List<Student>) sessionFactory.getCurrentSession().createCriteria(Student.class).list();
	}

	@Override
	public Student getStudent(int studentId) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, studentId);
	}

	@Override
	public void deleteStudent(int studentId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Student WHERE studentId = "+studentId).executeUpdate();
	}

}
