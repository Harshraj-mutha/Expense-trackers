package com.app.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
	//acts as a primary key for all entity
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  id;

}
