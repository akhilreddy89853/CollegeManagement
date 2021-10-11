package com.collegemanagement.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegemanagement.rest.model.College;
import com.collegemanagement.rest.services.CollegeService;

@RestController
@RequestMapping("/collegeService")
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	@PostMapping("/add-college")
	public String saveCollege(@RequestBody College college) {
		return collegeService.addCollege(college);
	}

	@GetMapping("/college-list")
	public List<College> getCollegeList() {
		return collegeService.getCollegeList();
	}
	
	@GetMapping("/college-by-id/{id}")
	public College collegeById(@PathVariable int id) {
		return collegeService.collegeById(id);
	}
}
