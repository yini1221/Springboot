package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.example.demo.model.entity.EventCategories;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventDto {
	
	private Integer id;
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private String location;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;

	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	@NotNull
	private Integer maxParticipants;
	
	@NotEmpty
	private String imageBase64;
	
	@NotNull
	private EventCategories eventCategories;

	public EventDto(String title, String description, String location, LocalDateTime startTime, LocalDateTime endTime,
			Integer maxParticipants, String imageBase64, EventCategories eventCategories) {
		this.title = title;
		this.description = description;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.maxParticipants = maxParticipants;
		this.imageBase64 = imageBase64;
		this.eventCategories = eventCategories;
	}

	public EventDto(Integer id, @NotEmpty String title, @NotEmpty String description, @NotEmpty String location,
			LocalDateTime startTime, LocalDateTime endTime, @NotNull Integer maxParticipants,
			@NotEmpty String imageBase64, @NotEmpty EventCategories eventCategories) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.maxParticipants = maxParticipants;
		this.imageBase64 = imageBase64;
		this.eventCategories = eventCategories;
	}
	
}
