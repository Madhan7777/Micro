package com.madhan.restapp.controller;

import java.util.HashMap;
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


import com.madhan.restapp.model.Admin;
import com.madhan.restapp.service.AdminService;

@RestController
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private AdminService service;

	@PostMapping("/registerAdmin")
	public ResponseEntity<String> register(@RequestBody Admin admin) {
		try {

			if (admin.getEmail() == null || admin.getPassword() == null || admin.getPhoneno() == null
					|| admin.getAdminName() == null) {
				return ResponseEntity.badRequest().body("All fields are required.");
			}

			service.addAdmin(admin);

			return ResponseEntity.ok("Admin registered successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error occurred during registration: " + e.getMessage());
		}
	}

	@PostMapping("/loginAdmin")
	public ResponseEntity<?> login(@RequestBody Admin admin) {
		try {
			Optional<Admin> adminOptional = service.findByemail(admin.getEmail());
			if (!adminOptional.isPresent()) {
				return ResponseEntity.badRequest().body("Invalid email");
			}

			Admin sellerFound = adminOptional.get();
			Map<String, Long> map=new HashMap<>();
            map.put("adminId", sellerFound.getAdminId());

			if (!admin.getPassword().equals(sellerFound.getPassword())) {
				return ResponseEntity.badRequest().body("Invalid password");
			}

			return ResponseEntity.ok(map);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error occurred during login: " + e.getMessage());
		}
	}
	
	@GetMapping("/adminLogin/{email}/{password}	")
	public ResponseEntity<?>  validateLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
		try {
			Optional<Admin>  user=service.adminLogin(email, password);
			if(user != null) {
				return ResponseEntity.ok(user);
			}
		} catch (Exception e) {
			
		}
		
		return (ResponseEntity<?>) ResponseEntity.badRequest();
	}

}
