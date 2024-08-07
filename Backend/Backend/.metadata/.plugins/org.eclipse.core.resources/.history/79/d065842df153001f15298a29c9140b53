package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserRegisterDTO;
import com.app.entities.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/admin")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public User registerAdmin(@RequestBody UserRegisterDTO dto) {
		System.out.println(dto);
		return userService.register(dto);
	}
	

}
