package com.teamroles.app.model;

import javax.persistence.Entity;

@Entity
public class Role {
	
	private int id;
	private int name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	
	
	
	

}
