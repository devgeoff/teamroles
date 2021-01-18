package com.teamroles.app.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;


public class User {
	
	@Id
	private UUID userId;
	private String name;
	private List<Team> teams;
		
	public UUID getId() {
		return userId;
	}
	public void setId(UUID id) {
		this.userId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	
}
