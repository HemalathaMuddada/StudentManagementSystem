package com.project.sms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sms.entity.Principal;
import com.project.sms.service.PrincipalService;


@RestController
public class PrincipalController {
	@Autowired
	private PrincipalService principalService;
	
	@GetMapping("/")
	public Iterable<Principal> getemployees(){
		return this.principalService.listAll();
		}
	
	@PostMapping("principal/save")
	private int saveStudent(@RequestBody Principal principals) {
		principalService.saveorupdate(principals);
		return principals.getId();
	}
	
	@RequestMapping("/principal/{id}")
	private Principal getPrincipal(@PathVariable (name="id") int id) {
		
		return principalService.getPrincipalId(id);
	}
	
	@PutMapping("principal/edit/{id}")
private Principal update(@RequestBody Principal principals,@PathVariable int id) {
		principals.setId(id);
		principalService.saveorupdate(principals);
		return principals;
	}
	
	@DeleteMapping("principal/delete/{id}")
	private void deleteprincipal(@PathVariable ("id") int id) {
		principalService.delete(id);
	}
}

