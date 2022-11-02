package com.greatlearning.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.model.DomainUserDetails;
import com.greatlearning.employee.model.Users;
import com.greatlearning.employee.repository.UserRepository;

@Service
public class DomainUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = this.userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid User"));
		System.out.println("User from the repository ");
		System.out.println(user);
		// convert into UserDetails object which Spring Security can understand
		return new DomainUserDetails(user);
	}
}
