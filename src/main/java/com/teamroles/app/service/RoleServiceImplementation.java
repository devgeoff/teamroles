package com.teamroles.app.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamroles.app.model.Membership;
import com.teamroles.app.model.Role;
import com.teamroles.app.repository.MembershipRepository;
import com.teamroles.app.repository.RoleRepository;

@Service
public class RoleServiceImplementation implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private MembershipRepository membershipRepository;

	@Override
	public Role saveRole(Role role) {
		
		return roleRepository.save(role);
	}
	

	@Override
	public List<Role> getRoles() {

		return roleRepository.findAll();
	}

	@Override
	public List<Membership> fetchMemberships(UUID roleId) {
		
		//Filtering to get Memberships that match the Role Id
		return membershipRepository.findAll()
				.stream()
				.filter(membership -> membership.getRoleId().equals(roleId))
				.collect(Collectors.toList());
	}


	@Override
	public void assignRole(Membership membership) {
		membershipRepository.save(membership);		
	}


	@Override
	public Role lookupRole(UUID userId, UUID teamId) {
		Role role = new Role();
		
		//Setting up default Role which is Developer
		role.setName("Developer");
		Membership membership = membershipRepository.findRole(userId, teamId);
		if(membership != null ){
			role.setName("");
			role.setId(membership.getRoleId());
		}
		return role;
	}

}
