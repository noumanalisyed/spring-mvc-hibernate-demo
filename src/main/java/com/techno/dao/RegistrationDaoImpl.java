package com.techno.dao;

import com.techno.bean.Registration;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
@Repository("registrationDao")
public class RegistrationDaoImpl implements RegistrationDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addRegistration(Registration categoryBean) {
		sessionFactory.getCurrentSession().saveOrUpdate(categoryBean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registration> getRegistrations() {
		return (List<Registration>) sessionFactory.getCurrentSession().createCriteria(Registration.class).list();
	}

	@Override
	public Registration getRegistration(int registrationId) {
		return (Registration) sessionFactory.getCurrentSession().get(Registration.class, registrationId);
	}

	@Override
	public void deleteRegistration(int registrationId) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Registration WHERE registrationId = "+registrationId).executeUpdate();
	}

}
