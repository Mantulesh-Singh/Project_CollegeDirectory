package com.practice.CollegeDirectory.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.CollegeDirectory.model.Users;
import com.practice.CollegeDirectory.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // For encoding and verifying passwords

    // Authenticate the user based on username and password
    public Users authenticateUser(String username, String password) {
        Optional<Users> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;  // Authentication successful
            }
        }
        return null;  // Authentication failed
    }

    // Create a new user (for Admin role use)
    public Users createUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
