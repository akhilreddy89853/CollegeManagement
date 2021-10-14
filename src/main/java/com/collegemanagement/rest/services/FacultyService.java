package com.collegemanagement.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagement.rest.dao.FacultyDao;
import com.collegemanagement.rest.entity.FacultyEntity;
import com.collegemanagement.rest.model.CollegeResponse;

@Service
public class FacultyService {

	@Autowired
	private FacultyDao facultyDao;

	@Autowired
	private DepartmentService departmentService;

	public CollegeResponse updateFacultWithDept(Integer deptId, Integer facultyId) {
		int count = facultyDao.addFacultyTodDep(deptId, facultyId);
		if (count == 0) {
			return new CollegeResponse(204, "Faculty not found based on id: " + facultyId);
		}
		return new CollegeResponse(201, "Faculty Added to the department");
	}

	public CollegeResponse getFacultyList(String name) {
		Integer deptid = departmentService.getDeptId(name);
		System.out.println(deptid);
		List<FacultyEntity> facultyList = facultyDao.getFacultyByDptName(deptid);
		if (facultyList.isEmpty()) {
			return new CollegeResponse(204, "No faculty found based on college name: " + name);
		}
		return new CollegeResponse(200, "Faculty list fetched successfully!", facultyList);
	}

}
