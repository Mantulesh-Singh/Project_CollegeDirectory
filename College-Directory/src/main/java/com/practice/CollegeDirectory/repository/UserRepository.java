package com.practice.CollegeDirectory.repository;

import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.CollegeDirectory.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    
    // Custom query to find a user by username
    Optional<Users> findByUsername(String username);

    // You can also create a method to find by email, etc., if needed
    Optional<Users> findByEmail(String email);

	
}