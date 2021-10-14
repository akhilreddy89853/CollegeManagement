package com.collegemanagement.rest.dao;

import java.util.List;

import com.collegemanagement.rest.entity.FacultyEntity;

public interface FacultyDao {

	public int addFacultyTodDep(Integer deptId, Integer facultyId);

	public List<FacultyEntity> getFacultyByDptName(Integer deptId);
}
