package com.project.sms.controller;
import java.util.List;
import com.project.sms.entity.User;
import com.project.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {	
@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public Iterable<User> getusers(){
		return this.userService.listAll();
		}
	
	@PostMapping("/save")
	private int saveUser(@RequestBody User users) {
		userService.saveorupdate(users);
		return users.getId();
	}
	
	@RequestMapping("/user/{id}")
	private User getUser(@PathVariable (name="id") int id) {
		
		return userService.getUserId(id);
	}
	
	@PutMapping("/edit/{id}")
private User update(@RequestBody User users,@PathVariable int id) {
		users.setId(id);
		userService.saveorupdate(users);
		return users;
	}
	
	@DeleteMapping("delete/{id}")
	private void deleteuser(@PathVariable ("id") int id) {
		userService.delete(id);
	}
}
	/*@RestController
	public class UserController {

	    @Autowired
	    private service service;

	    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public @ResponseBody
	    List<User> getAll() {
	        return service.getAll();
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public @ResponseBody
	   User get(@PathVariable Long id) {
	        return service.get(id);
	    }

	    @RequestMapping(value = "/filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public @ResponseBody
	   User get(@RequestParam String name) {
	        return service.get(name);
	    }

	    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public ResponseEntity<?> create(@RequestBody User company) {
	    	service.create(company);
	        HttpHeaders headers = new HttpHeaders();
	        ControllerLinkBuilder linkBuilder = linkTo(methodOn(UserController.class).get(company.getId()));
	        headers.setLocation(linkBuilder.toUri());
	        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	    }

	    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public void update(@RequestBody User company) {
	    	service.update(company);
	    }

	    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(value = HttpStatus.OK)
	    public void delete(@PathVariable Long id) {
	    	service.delete(id);
	    }
	}*/