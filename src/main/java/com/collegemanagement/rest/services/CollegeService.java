package com.collegemanagement.rest.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegemanagement.rest.dao.CollegeDao;
import com.collegemanagement.rest.entity.CollegeEntity;
import com.collegemanagement.rest.entity.DepartmentEntity;
import com.collegemanagement.rest.entity.FacultyEntity;
import com.collegemanagement.rest.model.CollegeResponse;

@Service
@Transactional
public class CollegeService {

	@Autowired
	private CollegeDao collegeDao;
	
	public String addCollege(CollegeEntity college) {
		return collegeDao.addCollege(college);
	}
	
	public CollegeResponse getCollegeList(){
		List<CollegeEntity> collegeList =  collegeDao.getCollegeList();
		if(collegeList.isEmpty()) {
			return new CollegeResponse(204, "College details not found");
		}else {
			return new CollegeResponse(200, "College Details fetched sucessfully",collegeList);
		}
	}
	
	public CollegeResponse collegeById(int id) {
		CollegeEntity college = collegeDao.getCollegeById(id);
		if(college == null){
			return new CollegeResponse(204, "College details not found for id: " + id);
		}else {
			return new CollegeResponse(200, "College Details fetched sucessfully", college);
		}
	}
	
	public CollegeResponse addDept(CollegeEntity college) {
		collegeDao.addDept(college);
		return new CollegeResponse(200, "Department has been added successfully!");
	}
	public CollegeResponse collegeByName(String name) {
		
		CollegeEntity college =  collegeDao.getColegeByName(name);
		if(college == null) {
			return new CollegeResponse(201, "College details not found based on college name:" + name);
		}
		return new CollegeResponse(200, "College Details fetched", college);
	}
	public CollegeResponse updateName(String name, int id) {
		int count = collegeDao.updateCollege(name, id);
		if(count ==  0) {
			return new CollegeResponse(201,"No records found with id :" + id);
		}
			return new CollegeResponse(200,"Name has been updated successfully!");		 
	}
	public String deleteByI(Integer id) {
		return collegeDao.deleteById(id);
	}
	public void addFaculty(CollegeEntity college) {
		collegeDao.addFaculty(college);
		
	}
	
	public List<DepartmentEntity> getDocumetList(String name){
		return collegeDao.getDeparmentList(name);
	}
	
	public CollegeResponse getFacultyList(Integer id){
		List<FacultyEntity> facultyList = collegeDao.getFacultyList(id);
				if(facultyList.isEmpty()) {
					return new CollegeResponse(204, "Faculty details not found based on id:" + id);
				}
		return new CollegeResponse(200, "Faculty List has been fetched successfully!",facultyList	);
	}
	
}
