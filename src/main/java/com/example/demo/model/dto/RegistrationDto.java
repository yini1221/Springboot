package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.example.demo.model.entity.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Data
public class RegistrationDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Integer id;
	
	private Integer userId;
	
	private Integer eventId;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime registeredAt;
	
	private Status status;
}
