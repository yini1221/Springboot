package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.example.demo.model.entity.EventCategories;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
	
	private Integer eventId;

	private String title;

	private String description;

	private String location;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private Integer maxParticipants;
	
	private String imageBase64;
	
	private EventCategories eventCategories;
}
