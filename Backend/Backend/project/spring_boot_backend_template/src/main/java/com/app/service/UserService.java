package com.app.service;

import com.app.dto.UserLoginDTO;
import com.app.dto.UserRegisterDTO;
import com.app.pojos.User;

public interface UserService {
	User register(UserRegisterDTO userDto);
	User login(UserLoginDTO userDto);
	public User findUserDetails(String username,String password); // To find user details for login.
	public void deleteUser(int id);
}
