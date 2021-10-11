package com.collegemanagement.rest.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegemanagement.rest.entity.CollegeEntity;
import com.collegemanagement.rest.entity.DepartmentEntity;

@Repository
public class CollegeDataImpl implements CollegeDao {

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
	public String addCollege(CollegeEntity college) {
		getSession().save(college);
		return "College has been added successfully!";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CollegeEntity> getCollegeList() {
		return getSession().createCriteria(CollegeEntity.class).list();
	}

	@Override
	public CollegeEntity getCollegeById(int id) {
		return (CollegeEntity) getSession().get(CollegeEntity.class, id);
	}

	@Override
	public void addDept(CollegeEntity college) {
		System.out.println(college.getCollegeId());
		CollegeEntity collegeData = (CollegeEntity) getSession().get(CollegeEntity.class, college.getCollegeId());
		college.getDept().forEach(data -> {
			collegeData.getDept().add(data);
		});

		getSession().save(collegeData);
	}

}