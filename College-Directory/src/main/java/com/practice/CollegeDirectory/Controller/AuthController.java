package com.practice.CollegeDirectory.Controller;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.CollegeDirectory.Service.UserService;
import com.practice.CollegeDirectory.model.Users;

//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
//        Users user = userService.authenticateUser(username, password);
//        if (user != null) {
//            String role = user.getRole().name();
//            return ResponseEntity.ok("Login successful! Redirect to " + role + " dashboard.");
//        } else {
//            return ResponseEntity.status(401).body("Invalid credentials");
//        }
//    }
//}

//package com.example.collegedirectory.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    // Method to fetch the name of the currently authenticated user
    @GetMapping("/api/auth/name")
    public String name() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();  // Returns the username or principal name
        }
        return "Anonymous";
    }
}



