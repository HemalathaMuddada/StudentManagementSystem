package com.project.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sms.entity.Principal;
import com.project.sms.repository.PrincipalRepository;


@Service
public class PrincipalService {
	@Autowired
	private PrincipalRepository principalRepository;

//retrieving all the details of principals
public Iterable<Principal>listAll(){
	return this.principalRepository.findAll();
	}


//saving the details..........
public void saveorupdate(Principal principal ) {
	principalRepository.save(principal);	
}

//reading the details....
public Principal getPrincipalId(int id) {
	return principalRepository.findById(id).get();
}

// Updating Details.....
public void update(Principal principals,int id) {
	principalRepository.save(principals);
}

//Deleting Details........
public void delete(int id) {
	principalRepository.deleteById(id);
}
}

