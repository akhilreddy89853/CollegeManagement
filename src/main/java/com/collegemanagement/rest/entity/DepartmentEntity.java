package com.collegemanagement.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "department")
public class DepartmentEntity {

	@Id
	@GeneratedValue
	private Integer deptId;
	private String departmentName;
	private String hodName;

	public DepartmentEntity(Integer deptId, String departmentName, String hodName) {
		super();
		this.deptId = deptId;
		this.departmentName = departmentName;
		this.hodName = hodName;
	}
	

	public DepartmentEntity() {
		super();
	}



	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}


	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", departmentName=" + departmentName + ", hodName=" + hodName
				+ "]";
	}

}
