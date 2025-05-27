package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.model.entity.Event;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class EventCategoriesDto {

	@Id
	private Integer categoryId;

	private String categoryName;
	
	private List<Event> events;
}
