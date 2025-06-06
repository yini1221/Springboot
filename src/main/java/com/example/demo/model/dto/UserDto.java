package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.example.demo.model.entity.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Integer id;
	
	private String username;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;	
	
	private String email;
	
	private Boolean completed;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime createdAt;

	@JsonProperty(access = Access.READ_ONLY)
	private UserRole role;
}
