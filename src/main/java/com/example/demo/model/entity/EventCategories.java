package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventCategories {
	
	@Id
	private Integer categoryId;

	private String categoryName;
	
	@OneToMany(mappedBy = "eventCategories")
	private List<Event> events;
}
