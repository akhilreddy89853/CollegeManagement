package com.collegemanagement.rest.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegemanagement.rest.entity.FacultyEntity;

@Repository
public class FacultyDaoImpl implements FacultyDao {

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
	public int addFacultyTodDep(Integer deptId, Integer facultyId) {
		return getSession().createSQLQuery("UPDATE faculty set deptId=:deptId where facultyID=:facultyId")
				.setParameter("deptId", deptId).setParameter("facultyId", facultyId).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FacultyEntity> getFacultyByDptName(Integer deptId) {
		System.out.println(deptId);
		return (List<FacultyEntity>) getSession().createCriteria(FacultyEntity.class)
				.add(Restrictions.eq("deptId", deptId)).list();
	}

}
