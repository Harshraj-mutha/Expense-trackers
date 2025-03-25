package com.app.service;

import com.app.dto.RequestUserDto;
import com.app.dto.ResponseUserDto;


public interface UserService {
		
	public String addUser(RequestUserDto user);
	
	public ResponseUserDto logInUser(long id);

}
