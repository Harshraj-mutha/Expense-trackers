package com.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@NotBlank(message = "The first name cannot be blank.")
	private String firstName;	
	
	@NotBlank(message = "The last name cannot be blank.")
	private String lastName;
	
	@NotBlank(message = "The email cannot be blank.")
	@Email(message = "Please enter a valid e-mail format")
	private String email;	
	
	
	private long mobileNumber;
	
	@NotBlank(message = "The username cannot be blank.")
	private String userName;
	
	
	@NotBlank(message = "The password cannot be blank.")	
	private String password;
	
	
	@NotBlank(message = "The password cannot be blank.")
	private String confirmPassword;
	
	
	
	
}
