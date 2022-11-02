package com.greatlearning.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.model.Users;
import com.greatlearning.employee.service.UserService;

@RestController
@RequestMapping("/registration/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

//	Create
	@PostMapping("addUser")
	@ResponseStatus(HttpStatus.CREATED)
	public Users addUser(@RequestBody Users newUser) {
		System.out.println("The New User is added: " + newUser);
		return this.userService.addUser(newUser);
	}

//	ListUsers
	@GetMapping("list")
	public List<Users> listUsers() {
		return this.userService.listUsers();
	}
}
