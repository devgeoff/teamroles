package com.teamroles.app.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamroles.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {

}
