package com.collegemanagement.rest.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "college")
public class CollegeEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7554517169365451027L;
	@Id
	@GeneratedValue
	private Integer collegeId;
	private String name;
	private String location;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "college_id", referencedColumnName = "collegeId")
	private List<DepartmentEntity> dept=new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "college_id", referencedColumnName = "collegeId")
	private List<FacultyEntity> faculty=new ArrayList<>();

	public Integer getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<DepartmentEntity> getDept() {
		return dept;
	}

	public void setDept(List<DepartmentEntity> dept) {
		this.dept = dept;
	}

	public List<FacultyEntity> getFaculty() {
		return faculty;
	}

	public void setFaculty(List<FacultyEntity> faculty) {
		this.faculty = faculty;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CollegeEntity [collegeId=" + collegeId + ", name=" + name + ", location=" + location + ", dept=" + dept
				+ ", faculty=" + faculty + "]";
	}


	
	
	

}
