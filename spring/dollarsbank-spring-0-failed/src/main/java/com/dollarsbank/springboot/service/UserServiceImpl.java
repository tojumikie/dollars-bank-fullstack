package com.dollarsbank.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dollarsbank.springboot.model.User;
import com.dollarsbank.springboot.repository.UserRepository;
import com.dollarsbank.springboot.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getName(), registrationDto.getUserid(), 
				passwordEncoder.encode(registrationDto.getPin()), registrationDto.getAmount());
		return userRepository.save(user);
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserid(username);
        if(user == null) {
            throw new UsernameNotFoundException("invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserid(), user.getPin(), null);
    }
    
    
}
