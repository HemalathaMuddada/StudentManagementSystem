package com.project.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.sms.entity.User;
import com.project.sms.repository.UserRepository;

@Service
public class UserService {
	  @Autowired
	    private UserRepository repo;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public void save(User user){
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        repo.save(user);
	    }

	}


