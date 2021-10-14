package com.collegemanagement.rest.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegemanagement.rest.entity.CollegeEntity;
import com.collegemanagement.rest.entity.DepartmentEntity;
import com.collegemanagement.rest.model.DepartmentModel;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

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
	public int assignHod(String hodName, Integer deptId) {
		return getSession().createSQLQuery("UPDATE department set hodName=:hodName where deptId=:deptId")
				.setParameter("hodName", hodName).setParameter("deptId", deptId).executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Integer getDeptId(String name) {
		DepartmentEntity deptEntity = (DepartmentEntity) getSession().createQuery(
				"Select new DepartmentEntity(deptId, departmentName, hodName) from DepartmentEntity where departmentName=:departmentName")
				.setParameter("departmentName", name).uniqueResult();
		return deptEntity.getDeptId();

	}

	@Override
	public String getHodName(Integer deptId) {
		DepartmentEntity deptEntity = (DepartmentEntity) getSession().createQuery(
				"Select new DepartmentEntity(deptId, departmentName, hodName) from DepartmentEntity where deptId=:deptId")
				.setParameter("deptId", deptId).uniqueResult();
		return deptEntity.getHodName();

	}

}
