package com.example.fantasy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fantasy.exception.ResourceNotFoundException;
import com.example.fantasy.model.User;
import com.example.fantasy.repository.UserRepository;
import com.example.fantasy.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		List<User> getAll = userRepository.findAll();
		return getAll;
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> getById = userRepository.findById(id);
		if (getById.isPresent()) {
			return getById.get();
		} else {
			throw new ResourceNotFoundException("Utente", "id", id);
		}
	}

	@Override
	public void createUser(User user) {
		User create = userRepository.save(user);
	}

	@Override
	public void updateUser(Long id, User user) {
		User update = this.getUserById(id);
		update.setNome(user.getNome());
		userRepository.save(update);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}
