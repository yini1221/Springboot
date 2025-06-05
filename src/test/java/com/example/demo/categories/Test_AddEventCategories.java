package com.example.demo.categories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.EventCategories;
import com.example.demo.repository.EventCategoriesRepository;

@SpringBootTest
public class Test_AddEventCategories {

	@Autowired
	private EventCategoriesRepository eventCategoriesRepository;
	
	@Test
	public void addEventCategories() {
		EventCategories eventCategories = new EventCategories();
		eventCategories.setName("歷史");
		
		EventCategories saved = eventCategoriesRepository.save(eventCategories);		
		System.out.println("新增成功! 分類ID: " + saved.getId());
	}
}
