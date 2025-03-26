package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class LoginRequestDTO {
	private String username;
	private String password;

}
