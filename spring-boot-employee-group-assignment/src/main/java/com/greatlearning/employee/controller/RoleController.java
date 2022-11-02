package com.greatlearning.employee.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.model.Role;
import com.greatlearning.employee.service.RoleService;

@RestController
@RequestMapping("/registration/role")
public class RoleController {
	private final RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@PostMapping("addRole")
	@ResponseStatus(HttpStatus.CREATED)
	public Role addRole(@RequestBody Role newRole) {
		return this.roleService.addRole(newRole);

	}

	@GetMapping("list")
	public Set<Role> listRoles() {
		return this.roleService.listRoles();
	}
}
