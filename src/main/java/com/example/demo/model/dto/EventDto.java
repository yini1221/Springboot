package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.example.demo.model.entity.EventCategories;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Integer id;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private String location;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime createdAt;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime updatedAt;
	
	@NotNull
	private Integer maxParticipants;
	
	@NotEmpty
	private String imageBase64;
	
	@NotNull
	private EventCategoryDto eventCategory;

	public EventDto(String title, String description, String location, LocalDateTime startTime, LocalDateTime endTime,
			Integer maxParticipants, String imageBase64, EventCategoryDto eventCategory) {
		this.title = title;
		this.description = description;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.maxParticipants = maxParticipants;
		this.imageBase64 = imageBase64;
		this.eventCategory = eventCategory;
	}

	public EventDto(Integer id, @NotEmpty String title, @NotEmpty String description, @NotEmpty String location,
			LocalDateTime startTime, LocalDateTime endTime, @NotNull Integer maxParticipants,
			@NotEmpty String imageBase64, @NotEmpty EventCategoryDto eventCategory) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.maxParticipants = maxParticipants;
		this.imageBase64 = imageBase64;
		this.eventCategory = eventCategory;
	}
	
}
