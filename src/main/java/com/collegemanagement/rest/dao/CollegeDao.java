package com.collegemanagement.rest.dao;

import java.util.List;

import com.collegemanagement.rest.model.College;
 

public interface CollegeDao {
	
	public String addCollege(College college);
	public List<College> getCollegeList();
	public College getCollegeById(int id);

}
