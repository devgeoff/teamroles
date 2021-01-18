package com.teamroles.app.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teamroles.app.model.Membership;
import com.teamroles.app.model.Role;
import com.teamroles.app.service.RoleService;


@RestController
@RequestMapping(value = "/api")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	public ResponseEntity<?> addRole(@RequestBody Role role) {
		
		roleService.saveRole(role);		
		return new ResponseEntity<>(role, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/lookupRole/{userId}/{teamId}", method = RequestMethod.GET)
	public ResponseEntity<?> lookupRole(@PathVariable("userId") UUID userId, @PathVariable("teamId") UUID teamId) {
		
		Role role  = roleService.lookupRole(userId,teamId);		
		return new ResponseEntity<>(role, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/fetchMemberships/{roleId}", method = RequestMethod.GET)
	public ResponseEntity<?> fetchMemberships(@PathVariable UUID roleId) {
		
		List<Membership> memberships = roleService.fetchMemberships(roleId);		
		return new ResponseEntity<>(memberships, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/assignRole", method = RequestMethod.POST)
	public ResponseEntity<?> assignRole(@RequestBody Membership membership) {
		
		roleService.assignRole(membership);		
		return new ResponseEntity<>(membership, HttpStatus.OK);
	}
		
		 

}
