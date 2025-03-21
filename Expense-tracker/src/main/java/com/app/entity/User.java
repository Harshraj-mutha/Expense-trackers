package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
	
	@Column(name = "first_name" , nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "mobile_number", length = 10, nullable = false)
	private long mobileNumber;
	
	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Transient
	@Column(name = "confirm_password",insertable = false)
	private String confirmPassword;

}
