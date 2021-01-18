package com.teamroles.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teamroles.app.model.Membership;

public interface MembershipRepository extends JpaRepository<Membership, UUID> {

	
	@Query("SELECT e from Membership e where e.userId =:userId AND e.teamId =:teamId")
	Membership findRole(UUID userId, UUID teamId);

}
