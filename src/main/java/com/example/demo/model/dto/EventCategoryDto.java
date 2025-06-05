package com.example.demo.model.dto;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventCategoryDto {

	private Integer id;

	private String name;

	public EventCategoryDto(Integer id, String categoryName) {
		this.id = id;
		this.name = categoryName;
	}

	public EventCategoryDto(String categoryName) {
		this.name = categoryName;
	}
		
}
