package com.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.ExceptionHandler.UserNotFoundException;
import com.app.dto.RequestUserDto;
import com.app.dto.ResponseUserDto;
import com.app.entity.Role;
import com.app.entity.User;
import com.app.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	private PasswordEncoder passwordEcncoder;

	@Override
	public String addUser(RequestUserDto user) {
		User newUser = mapper.map(user,User.class);
		newUser.setRole(Role.USERS);
		newUser.setPassword(passwordEcncoder.encode(newUser.getPassword()));
		User savedUser = Optional.ofNullable(userRepo.save(newUser)).orElseThrow(()-> new RuntimeException("Failed to save user"));
		return "user created successfully";
		
		
	}

	@Override
	public ResponseUserDto logInUser(long id) {
		User user = userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User not found"));
		ResponseUserDto userDTO = mapper.map(user, ResponseUserDto.class);
		return userDTO;
	}
	

}
