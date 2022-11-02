package com.greatlearning.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.employee.model.Users;
import com.greatlearning.employee.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository; // For User

//	Create
	public Users addUser(Users user) {
		System.out.println("Saving the Employee to the set...." + user);
		Users savedUser = this.userRepository.save(user);
		System.out.println("Added Data: " + savedUser);
		return savedUser;
	}

//	ListAll
	public List<Users> listUsers() {
		return new ArrayList<>(this.userRepository.findAll());
	}

}
