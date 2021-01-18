package com.teamroles.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamroles.app.model.Membership;

public interface MembershipRepository extends JpaRepository<Membership, UUID> {

}
