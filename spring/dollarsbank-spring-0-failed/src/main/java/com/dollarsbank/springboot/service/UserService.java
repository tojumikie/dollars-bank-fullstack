package com.dollarsbank.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.dollarsbank.springboot.model.User;
import com.dollarsbank.springboot.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}
