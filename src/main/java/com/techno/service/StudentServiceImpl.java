package com.techno.service;

import com.techno.bean.Student;
import com.techno.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}

	public List<Student> getStudents() {
		return studentDao.getStudents();
	}

	@Override
	public Student getStudent(int studentId) {
		return studentDao.getStudent(studentId);
	}

	@Override
	public void deleteStudent(int studentId) {
		studentDao.deleteStudent(studentId);
	}

}
