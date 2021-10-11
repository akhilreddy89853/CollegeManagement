package com.collegemanagement.rest.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagement.rest.dao.CollegeDao;
import com.collegemanagement.rest.model.College;

@Service
@Transactional
public class CollegeService {

	@Autowired
	private CollegeDao collegeDao;
	
	public String addCollege(College college) {
		return collegeDao.addCollege(college);
	}
	
	public List<College> getCollegeList(){
		return collegeDao.getCollegeList();
	}
	
	public College collegeById(int id) {
		return collegeDao.getCollegeById(id);
	}
	
}
