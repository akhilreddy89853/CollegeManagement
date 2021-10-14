package com.collegemanagement.rest.model;

public class DepartmentModel {

	private Integer deptId;
	private String departmentName;
	private String hodName;
	
	

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
