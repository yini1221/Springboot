package com.example.demo.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eventId;

	@Column(length = 200, nullable = false)
	private String title;

	@Column(length = 255, columnDefinition = "TEXT", nullable = false)
	private String description;

	@Column(length = 255, nullable = false)
	private String location;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	private Integer maxParticipants;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String imageBase64;
	
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private EventCategories eventCategories;
	
}
