package com.teamroles.app.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Team {
	
	@Id
	private UUID teamId;
	private int name;
	
	
	public UUID getId() {
		return teamId;
	}
	public void setId(UUID id) {
		this.teamId = id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	
	

}
