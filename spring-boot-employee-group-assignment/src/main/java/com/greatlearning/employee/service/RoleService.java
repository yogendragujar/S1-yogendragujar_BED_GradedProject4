package com.greatlearning.employee.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.greatlearning.employee.model.Role;
import com.greatlearning.employee.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {
	private final RoleRepository roleRepository; // For Role

//	Create Role
	public Role addRole(Role role) {
		System.out.println("Saving Role " + role);
		Role savedRole = this.roleRepository.save(role);
		return savedRole;
	}
	
//	list Role
	public Set<Role> listRoles() {
		return new HashSet<>(this.roleRepository.findAll());
	}

//	findROle By Name
	public Set<Role> findRoleByRoleName(String roleName) {
		return new HashSet<>(this.roleRepository.fetchRoleByRoleName(roleName));
	}

}
