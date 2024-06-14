package com.example.fantasy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.fantasy.model.User;
import com.example.fantasy.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAll() {
		List<User> getAll = service.getAllUser();
		return ResponseEntity.ok().body(getAll);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<User> getById(@PathVariable(value = "id") Long id) {
		User getById = service.getUserById(id);
		return ResponseEntity.ok().body(getById);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		service.createUser(user);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		service.updateUser(id, user);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
		service.deleteUser(id);
		return ResponseEntity.ok().build();
	} 
 	
}
