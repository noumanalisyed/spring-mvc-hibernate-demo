package com.techno.service;

import com.techno.bean.Course;
import com.techno.bean.Registration;
import com.techno.dao.RegistrationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("registrationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private RegistrationDao registrationDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addRegistration(Registration registration) {
		registrationDao.addRegistration(registration);
	}

	@Override
	public List<Registration> getRegistrations() {
		return registrationDao.getRegistrations();
	}

	@Override
	public Registration getRegistration(int registrationId) {
		return registrationDao.getRegistration(registrationId);
	}

	@Override
	public void deleteRegistration(int registrationId) {
		registrationDao.deleteRegistration(registrationId);
	}

}
