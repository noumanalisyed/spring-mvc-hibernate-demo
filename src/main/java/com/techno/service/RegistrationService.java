package com.techno.service;

import com.techno.bean.Course;
import com.techno.bean.Registration;

import java.util.List;

public interface RegistrationService {
	
	public void addRegistration(Registration registration);
	
	public List<Registration> getRegistrations();
	
	public Registration getRegistration(int registrationId);
	
	public void deleteRegistration(int registrationId);

}
