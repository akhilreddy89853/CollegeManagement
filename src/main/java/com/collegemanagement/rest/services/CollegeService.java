package com.collegemanagement.rest.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagement.rest.dao.CollegeDao;
import com.collegemanagement.rest.entity.CollegeEntity;

@Service
@Transactional
public class CollegeService {

	@Autowired
	private CollegeDao collegeDao;
	
	public String addCollege(CollegeEntity college) {
		return collegeDao.addCollege(college);
	}
	
	public List<CollegeEntity> getCollegeList(){
		return collegeDao.getCollegeList();
	}
	
	public CollegeEntity collegeById(int id) {
		return collegeDao.getCollegeById(id);
	}
	
	public void addDept(CollegeEntity college) {
		collegeDao.addDept(college);
	}
	
}
