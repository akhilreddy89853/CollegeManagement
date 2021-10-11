package com.collegemanagement.rest.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "college")
public class College implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7554517169365451027L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	

}
