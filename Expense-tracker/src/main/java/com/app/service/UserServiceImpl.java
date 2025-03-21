package com.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.UserDto;
import com.app.entity.User;
import com.app.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public String addUser(UserDto user) {
		User newUser = mapper.map(user,User.class);
		User savedUser = Optional.ofNullable(userRepo.save(newUser)).orElseThrow(()-> new RuntimeException("Failed to save user"));
		return "user created successfully";
		
		
	}
	

}
