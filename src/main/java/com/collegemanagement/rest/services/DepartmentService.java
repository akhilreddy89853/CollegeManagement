package com.collegemanagement.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagement.rest.dao.DepartmentDao;
import com.collegemanagement.rest.entity.DepartmentEntity;
import com.collegemanagement.rest.model.CollegeResponse;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao dao;

	public CollegeResponse assignHodForDep(String hodName, Integer deptId) {
		int count = dao.assignHod(hodName, deptId);
		if (count == 0) {
			return new CollegeResponse(204, "Department not found based on id: " + deptId);
		}
		return new CollegeResponse(201, "HOD Added to the department");
	}

	public Integer getDeptId(String name) {
		return dao.getDeptId(name);
	}

	public String getDeptHodName(Integer deptId) {
		return dao.getHodName(deptId);
	}

}
