package com.app.service;

import com.app.dto.UserRegisterDTO;
import com.app.entities.User;

public interface UserService {
	User register(UserRegisterDTO userDto);

}
