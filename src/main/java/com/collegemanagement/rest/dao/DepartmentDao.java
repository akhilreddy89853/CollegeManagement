package com.collegemanagement.rest.dao;

import java.util.List;

import com.collegemanagement.rest.entity.DepartmentEntity;

public interface DepartmentDao {

	public int assignHod(String hodName, Integer deptId);

	public Integer getDeptId(String name);

	public String getHodName(Integer deptId);

}
