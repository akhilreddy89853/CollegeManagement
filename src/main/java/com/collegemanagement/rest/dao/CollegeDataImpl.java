package com.collegemanagement.rest.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegemanagement.rest.model.College;

@Repository
public class CollegeDataImpl implements CollegeDao{

	@Autowired
	private SessionFactory factory;
	
	
	private Session getSession() {
		Session session = null;
		try {
			session = factory.getCurrentSession();
		} catch (HibernateException ex) {
			session = factory.openSession();
		}
		return session;
	}

	@Override
	public String addCollege(College college) {
		getSession().save(college);
		return "College has been added successfully!";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<College> getCollegeList() {	
		  return getSession().createCriteria(College.class).list();
	}
	
	@Override
	public College getCollegeById(int id) {
		return (College) getSession().get(College.class, id);
	}
}