package com.teamroles.app.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Membership {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "membership_id")
	private UUID membershipId;
	
	@Column(name = "user_id", nullable = false)
	private UUID userId;
	
	@Column(name = "team_id")
	private UUID teamId;
	
	@Column(name = "role_id")
	private UUID roleId;	

	
	
	
	public Membership() {
		super();
	}

	public Membership(UUID userId, UUID teamId, UUID roleId) {		
		this.userId = userId;
		this.teamId = teamId;
		this.roleId = roleId;
	}
	
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public UUID getTeamId() {
		return teamId;
	}
	public void setTeamId(UUID teamId) {
		this.teamId = teamId;
	}
	public UUID getRoleId() {
		return roleId;
	}
	public void setRoleId(UUID roleId) {
		this.roleId = roleId;
	}
	
}
