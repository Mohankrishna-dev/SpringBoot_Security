package com.jsp.Spring_Security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jsp.Spring_Security.entity.UserEntity;
import com.jsp.Spring_Security.repository.UserRepository;
@Service
public class UserService {
	 @Autowired
	private UserRepository userrepository;
	@Autowired
	private PasswordEncoder encoder;
	
	public UserEntity saveUser(UserEntity u) {
		u.setPassword(encoder.encode(u.getPassword()));
		return userrepository.save(u);
	}

}
