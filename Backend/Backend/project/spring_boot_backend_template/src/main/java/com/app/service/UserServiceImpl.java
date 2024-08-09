package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dto.UserLoginDTO;
import com.app.dto.UserRegisterDTO;
import com.app.pojos.User;
import com.app.pojos.UserValidity;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper map;
	
	@Override
	public User findUserDetails(String username,String password) {
		return userDao.findUserByUsernameAndPassword(username, password).orElse(null);
	}

	@Override
	public void deleteUser(int id) {
		User u=userDao.findById(id).orElse(null);
		if(u.getValidity()==UserValidity.ACTIVE) {
			u.setValidity(UserValidity.INACTIVE);
		}
	}

	@Override
	public User register(UserRegisterDTO adminDto) {
	    User user = map.map(adminDto, User.class); // Assuming 'map' is an instance of ModelMapper or similar
	    return userDao.save(user); // Save the user to the database
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
