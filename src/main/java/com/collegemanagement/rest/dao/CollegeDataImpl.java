package com.collegemanagement.rest.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collegemanagement.rest.entity.CollegeEntity;
import com.collegemanagement.rest.entity.DepartmentEntity;
import com.collegemanagement.rest.entity.FacultyEntity;

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

		CollegeEntity collegeEntity = (CollegeEntity) getSession()
				.createQuery(
						"Select new CollegeEntity(collegeId, name, location) from CollegeEntity where collegeId=:id")
				.setParameter("id", id).uniqueResult();
		return collegeEntity;
//		
//		Example example = Example.create(CollegeEntity.class)
//			    .excludeZeroes()           //exclude zero valued properties
//			    .excludeProperty("dept")
//			    .excludeProperty("faculty")//exclude the property named "color"
//			    .ignoreCase()              //perform case insensitive string comparisons
//			    .enableLike();  
//		return (CollegeEntity) getSession().get(CollegeEntity.class, id).add();
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

	@Override
	public CollegeEntity getColegeByName(String collegeName) {
		CollegeEntity collegeEntity = (CollegeEntity) getSession()
				.createQuery("Select new CollegeEntity(collegeId, name, location) from CollegeEntity where name=:name")
				.setParameter("name", collegeName).uniqueResult();
		return collegeEntity;
	}

	@Override
	public int updateCollege(String name, Integer id) {
		int count = getSession().createSQLQuery("UPDATE college set name=:name where collegeId=:id")
				.setParameter("name", name).setParameter("id", id).executeUpdate();
		return count;
	}

	@Override
	public String deleteById(Integer id) {
		try {
			Session session = getSession();
			CollegeEntity myObject;

			myObject = (CollegeEntity) session.load(CollegeEntity.class, id);
			getSession().delete(myObject);

			// This makes the pending delete to be done
			session.flush();
			return "College has been deleted successfully!";
		} catch (Exception E) {
			System.out.println("Interanal server error" + E);
			return E.toString();
		}
	}

	@Override
	public String addFaculty(CollegeEntity college) {
		CollegeEntity collegeData = (CollegeEntity) getSession().get(CollegeEntity.class, college.getCollegeId());
		college.getFaculty().forEach(data -> {
			collegeData.getFaculty().add(data);
		});

		getSession().save(collegeData);
		return null;
	}

	@Override
	public List<DepartmentEntity> getDeparmentList(String name) {
		CollegeEntity collegeEntity = (CollegeEntity) getSession()
				.createQuery("Select new CollegeEntity(collegeId, name, location) from CollegeEntity where name=:name")
				.setParameter("name", name).uniqueResult();
		Integer id = collegeEntity.getCollegeId();
		collegeEntity = (CollegeEntity) getSession().get(CollegeEntity.class, id);
		return collegeEntity.getDept();
	}

	@Override
	public List<FacultyEntity> getFacultyList(Integer id) {
		CollegeEntity collegeEntity = (CollegeEntity) getSession().get(CollegeEntity.class, id);
		return collegeEntity.getFaculty();
	}

}