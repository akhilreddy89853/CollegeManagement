package com.collegemanagement.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "faculty")
public class FacultyEntity {

	@Id
	@GeneratedValue
	private Integer facultyID;
	private String facultyName;
	private String subject;
	private Integer deptId;
	
	

	public FacultyEntity() {
		super();
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(Integer facultyID) {
		this.facultyID = facultyID;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "FacultyEntity [facultyID=" + facultyID + ", facultyName=" + facultyName + ", subject=" + subject + "]";
	}

}
