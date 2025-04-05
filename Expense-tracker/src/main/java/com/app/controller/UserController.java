package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginRequestDTO;
import com.app.dto.RequestUserDto;
import com.app.jwt.utils.JwtUtils;
import com.app.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUpNewUser(@RequestBody @Valid RequestUserDto user){
		return  ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> logInUser(@RequestBody @Valid LoginRequestDTO loginReq ){
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginReq.getUserName(), loginReq.getPassword());
		try {
			Authentication principal = authManager.authenticate(authToken);
			return new ResponseEntity<>(jwtUtils.generateToken(principal),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

	}

}
