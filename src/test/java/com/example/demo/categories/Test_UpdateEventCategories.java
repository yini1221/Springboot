package com.example.demo.categories;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.EventCategories;
import com.example.demo.repository.EventCategoriesRepository;

@SpringBootTest
public class Test_UpdateEventCategories {

	@Autowired
	private EventCategoriesRepository eventCategoriesRepository;
	
	@Test
	public void updateCategory() {
		Optional<EventCategories> eOptional = eventCategoriesRepository.findById(305);
		if(eOptional.isEmpty()) {
			System.out.println("查無此活動分類");
			return;
		}
		
		EventCategories eventCategories = eOptional.get();
		eventCategories.setName("手作");
		EventCategories saved = eventCategoriesRepository.save(eventCategories);
		System.out.printf("修改成功! 分類編號: %d 分類名稱: %s%n", saved.getId(), saved.getName());
		
	}
}
