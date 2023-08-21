package com.techno.dao;

import com.techno.bean.Registration;

import java.util.List;

public interface RegistrationDao {
	
	public void addRegistration(Registration categoryBean);
	
	public List<Registration> getRegistrations();
	
	public Registration getRegistration(int registrationId);
	
	public void deleteRegistration(int registrationId);
}
