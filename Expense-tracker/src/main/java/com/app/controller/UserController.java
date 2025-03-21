package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUpNewUser(@RequestBody @Valid UserDto user){
		System.out.println("new user");
		return  ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
	}
	
	@GetMapping()
	public ResponseEntity<?> home(){
		return new ResponseEntity<>("home",HttpStatus.OK);
	}

}
