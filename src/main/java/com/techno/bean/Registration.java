package com.techno.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the registration database table.
 * 
 */
@Entity
@NamedQuery(name="Registration.findAll", query="SELECT r FROM Registration r")
public class Registration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="registration_id")
	private int registrationId;

	//bi-directional many-to-one association to Course
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;

	public Registration() {
	}

	public int getRegistrationId() {
		return this.registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
