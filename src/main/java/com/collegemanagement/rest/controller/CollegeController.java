package com.collegemanagement.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegemanagement.rest.entity.CollegeEntity;
import com.collegemanagement.rest.entity.DepartmentEntity;
import com.collegemanagement.rest.entity.FacultyEntity;
import com.collegemanagement.rest.model.CollegeResponse;
import com.collegemanagement.rest.services.CollegeService;
import com.collegemanagement.rest.services.DepartmentService;
import com.collegemanagement.rest.services.FacultyService;

@RestController
@RequestMapping("/collegeService")
public class CollegeController {

	@Autowired
	private CollegeService collegeService;

	@Autowired
	private DepartmentService deptService;

	@Autowired
	private FacultyService facultyService;

	@PostMapping("/add-college")
	public CollegeResponse saveCollege(@RequestBody CollegeEntity college) {
		collegeService.addCollege(college);
		return new CollegeResponse(200, "College has been added Successfully!");
	}

	@GetMapping("/college-list")
	public CollegeResponse getCollegeList() {
		return collegeService.getCollegeList();
	}

	@GetMapping("/college-by-id/{id}")
	public CollegeResponse collegeById(@PathVariable int id) {
		return collegeService.collegeById(id);
	}

	@GetMapping("/collegeByName/{name}")
	public CollegeResponse collegeByName(@PathVariable String name) {
		return collegeService.collegeByName(name);
	}

	@PutMapping("/updateByName/{name}/{id}")
	public CollegeResponse updateByName(@PathVariable("name") String name, @PathVariable("id") Integer id) {
		return collegeService.updateName(name, id);
	}

	@PostMapping("/saveDept")
	public ResponseEntity<String> saveDeptDetails(@RequestBody CollegeEntity entity) {
		System.out.println(entity.toString());
		collegeService.addDept(entity);
		String status = "Department Details added successfully";

		return new ResponseEntity<String>(status, HttpStatus.CREATED);

	}

	@GetMapping("/depts/{collegeName}")
	public ResponseEntity<List<DepartmentEntity>> getDeptDetailsByCollgeName(
			@PathVariable("collegeName") String collegeName) {
		List<DepartmentEntity> listOfDepts = collegeService.getDocumetList(collegeName);
		return new ResponseEntity<List<DepartmentEntity>>(listOfDepts, HttpStatus.OK);

	}

	@PostMapping("/saveFaculty")
	public ResponseEntity<String> saveFaculty(@RequestBody CollegeEntity entity) {
		collegeService.addFaculty(entity);
		String status = "Faculty Details added successfully";
		return new ResponseEntity<String>(status, HttpStatus.CREATED);

	}

	@GetMapping("/facultyList/{id}")
	public CollegeResponse getFacultyList(@PathVariable Integer id) {
		return collegeService.getFacultyList(id);
	}

	@PutMapping("/assignFaculty/{deptId}/{facultyId}")
	public CollegeResponse assignFacultyToDep(@PathVariable Integer deptId, @PathVariable Integer facultyId) {
		return facultyService.updateFacultWithDept(deptId, facultyId);
	}

	@PutMapping("/assingHod/{hodName}/{deptId}")
	public CollegeResponse assigHod(@PathVariable String hodName, @PathVariable Integer deptId) {
		return deptService.assignHodForDep(hodName, deptId);
	}

	@GetMapping("/facultyListByDepName/{deptName}")
	public CollegeResponse getFacultyList(@PathVariable String deptName) {
		return facultyService.getFacultyList(deptName);
	}

	@GetMapping("/hodName/{deptId}")
	public ResponseEntity<String> getHodName(@PathVariable Integer deptId) {
		return new ResponseEntity<String>(deptService.getDeptHodName(deptId), HttpStatus.OK);
	}

}
