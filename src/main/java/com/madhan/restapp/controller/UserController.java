package com.madhan.restapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.madhan.restapp.model.User;
import com.madhan.restapp.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/registerUser")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            
            if (user.getEmail() == null || user.getPassword() == null || user.getPhoneNo() == null  || user.getUserName() == null) {
                return ResponseEntity.badRequest().body("All fields are required.");
            }
 
            
            service.addUser(user);
 
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error occurred during registration: " + e.getMessage());
        }
    }
 
    @PostMapping("/loginUser")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            Optional<User> userOptional = service.findbyemail(user.getEmail());
            if (!userOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Invalid email");
            }
 
            User userFound = userOptional.get();
            Map<String, Long> map=new HashMap<>();
            map.put("userId", userFound.getUserId());
 
            if (!user.getPassword().equals(userFound.getPassword())) {
                return ResponseEntity.badRequest().body("Invalid password");
            }
 
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error occurred during login: " + e.getMessage());
        }
    }
    
    @GetMapping("/userLogin/{email}/{password}	")
	public ResponseEntity<?>  validateLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
		try {
			Optional<User> user=service.UserLogin(email, password);
			if(user != null) {
				return ResponseEntity.ok(user);
			}
		} catch (Exception e) {
			
		}
		
		return (ResponseEntity<?>) ResponseEntity.badRequest();
	}
	@GetMapping("/findAllUser")
	public List<User> findAllUser() {
		return service.findAllUser();
	}
}
