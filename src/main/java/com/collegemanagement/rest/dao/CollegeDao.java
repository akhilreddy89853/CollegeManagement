package com.collegemanagement.rest.dao;

import java.util.List;

import com.collegemanagement.rest.entity.CollegeEntity;
 

public interface CollegeDao {
	
	public String addCollege(CollegeEntity college);
	public List<CollegeEntity> getCollegeList();
	public CollegeEntity getCollegeById(int id);
	public void addDept(CollegeEntity college);
	

}
