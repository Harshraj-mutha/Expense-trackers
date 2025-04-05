package com.app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoginRequestDTO {
	@NotBlank(message = "The username cannot be blank.")
	private String userName;
	@NotBlank(message = "The password cannot be blank.")
	private String password;

}
