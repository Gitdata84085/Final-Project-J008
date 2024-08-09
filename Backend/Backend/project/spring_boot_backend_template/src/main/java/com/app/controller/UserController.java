package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




import com.app.dto.PatientDTO;

import com.app.dto.UserLoginDTO;
import com.app.dto.UserRegisterDTO;
import com.app.pojos.Admin;
import com.app.pojos.Doctor;
import com.app.pojos.Patient;
import com.app.pojos.Receptionist;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.pojos.UserValidity;

import com.app.service.PatientService;
import com.app.service.UserService;

import io.swagger.v3.oas.models.responses.ApiResponse;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/user")

public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PatientService patientService;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody UserRegisterDTO adminDto) {
	    User registeredUser = userService.register(adminDto);
	    return ResponseEntity.ok(registeredUser);
	}

	
	@PostMapping("/login")
	public User login(@RequestBody UserLoginDTO dto) {
		System.out.println(dto);
		return userService.login(dto);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return ResponseEntity.ok("User Deleted");
		
	}
	

}
