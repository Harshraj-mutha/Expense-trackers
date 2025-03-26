package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequestDTO;
import com.app.dto.RequestUserDto;
import com.app.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private AuthenticationManager authenticationMgr;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUpNewUser(@RequestBody @Valid RequestUserDto user){
		return  ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> logInUser(@RequestBody LoginRequestDTO loginRequest){
		authenticationMgr
		.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
