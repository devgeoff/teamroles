package com.teamroles.app.service;

import java.util.List;
import java.util.UUID;

import com.teamroles.app.model.Membership;
import com.teamroles.app.model.Role;

public interface RoleService {
	
	 Role saveRole(Role role);
     List<Role> getRoles();
	 List<Membership> fetchMemberships(UUID roleId);
	 void assignRole(Membership membership);
	 Role lookupRole(UUID userId, UUID teamId);
}
