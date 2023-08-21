package com.techno.service;

import com.techno.bean.Student;

import java.util.List;

public interface StudentService {
	
	public void addStudent(Student student);
	
	public List<Student> getStudents();
	
	public Student getStudent(int studentId);
	
	public void deleteStudent(int studentId);
}
