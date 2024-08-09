package com.app.dto;

import com.app.pojos.Role;
import com.app.pojos.UserValidity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegisterDTO {
	private String username;
	private String password;
	private Role userRole;
	private UserValidity validity;
	

}
