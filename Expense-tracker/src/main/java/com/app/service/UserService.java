package com.app.service;

import com.app.dto.UserDto;


public interface UserService {
		
	public String addUser(UserDto user);
	
	public UserDto logInUser(long id);

}
