package com.InventoryManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InventoryManagement.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	//Method to find the details of user by email
	  User findByEmail(String email);
	
}
