package com.example.demo.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eventId;

	private String title;

	private String description;

	private String location;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private Integer maxParticipants;
	
	private String imageBase64;
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private EventCategories eventCategories;
	
}
