package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event_categories")
public class EventCategories {
	
	@Id
	@Column(name = "id")
	private Integer categoryId;

	@Column(name = "name")
	private String categoryName;
	
	@OneToMany(mappedBy = "eventCategories")
	private List<Event> events;
}
