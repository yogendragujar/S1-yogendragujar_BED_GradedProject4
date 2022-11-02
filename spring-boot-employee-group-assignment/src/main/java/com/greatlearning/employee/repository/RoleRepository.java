package com.greatlearning.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.employee.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	@Query("select role from Role role where role.roleName=?1")
	public List<Role> fetchRoleByRoleName(String roleName);
}
