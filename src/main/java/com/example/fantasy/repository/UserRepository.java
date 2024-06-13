package com.example.fantasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fantasy.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
