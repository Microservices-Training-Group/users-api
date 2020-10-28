package com.users.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.users.model.Users;
import com.users.service.Service;

@RestController
@CrossOrigin("http://localhost:3000")
public class UsersController {
	
	@Autowired
	private Service service;
	
	@GetMapping("/users")
	public List<Users> fetchallnews() {
		return service.getAllUsers();
		
		
	}
	@GetMapping("/users/{id}")
	public Object getById(@PathVariable("id") int id) {
	 return service.getById(id);	
	}
	
	@PutMapping("/users/{id}")
	public Optional<Object> editUser(@RequestBody Users users, @PathVariable("id") int id) {
	 return service.userEdit(users, id);	
	}
	
//	@GetMapping("/users/{name}")
//	public List<Users> getByName(@PathVariable("name")String name) { 
//		return service.getByName(name);
//	}
	
	@PostMapping("/users")
	public Users addUsers(@RequestBody Users users) {
	 return service.addUsers(users);
	}
	
	 @DeleteMapping(value="/users/{id}")
	 public ResponseEntity<?> delete(@PathVariable("id") int id) {
		 return service.DeleteUser(id);
	 }
	
}