package com.collegemanagement.rest.dao;

import java.util.List;

import com.collegemanagement.rest.entity.CollegeEntity;
import com.collegemanagement.rest.entity.DepartmentEntity;
import com.collegemanagement.rest.entity.FacultyEntity;

public interface CollegeDao {

	public String addCollege(CollegeEntity college);

	public List<CollegeEntity> getCollegeList();

	public CollegeEntity getCollegeById(int id);

	public void addDept(CollegeEntity college);

	public CollegeEntity getColegeByName(String collegeName);

	public int updateCollege(String name, Integer id);

	public String deleteById(Integer id);

	public String addFaculty(CollegeEntity college);

	public List<DepartmentEntity> getDeparmentList(String name);

	public List<FacultyEntity> getFacultyList(Integer id);

}
