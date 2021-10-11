package com.collegemanagement.rest.model;

public class CollegeResponse {
	
	private int status;
	private String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CollegeResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	

}
