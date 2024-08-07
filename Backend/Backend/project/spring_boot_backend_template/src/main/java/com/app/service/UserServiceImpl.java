package com.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dto.UserLoginDTO;
import com.app.dto.UserRegisterDTO;
import com.app.entities.User;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper map;
	
	
//	@Override
//	public User registerAdmin(UserRegistrerDTO dto) {
//
	

	@Override
	public User register(UserRegisterDTO adminDto) {
		User user=map.map(adminDto, User.class);
		User u = userDao.save(user);
		return u;
	}


	@Override
	public User login(UserLoginDTO userDto) {
		Optional<User> optionalUser=userDao.findByUsername(userDto.getUsername());
		if(optionalUser.isPresent()&& optionalUser.get().getPassword().equals(userDto.getPassword())) {
			return optionalUser.get();
		}
		return null;
	}

}
