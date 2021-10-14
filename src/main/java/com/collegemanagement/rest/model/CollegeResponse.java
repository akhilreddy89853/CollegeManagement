package com.collegemanagement.rest.model;

public class CollegeResponse {
	private int status;
	
	private String message;
	
	private Object res;
	
	
	
	
	public CollegeResponse() {
		super();
	}
	
	public Object getRes() {
		return res;
	}
	
	public void setRes(Object res) {
		this.res = res;
	}
	
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
	
	public CollegeResponse(int status, String message, Object res) {
		this.status = status;
		this.message = message;
		this.res = res;
	}

}
