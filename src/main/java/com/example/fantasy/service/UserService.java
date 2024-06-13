package com.example.fantasy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fantasy.model.User;

@Service
public interface UserService {
	
	public List<User> getAllUser();
	public User getUserById(Long id);
	public void createUser(User user);
	public void updateUser(Long id, User user);
	public void deleteUser(Long id);
	
}
