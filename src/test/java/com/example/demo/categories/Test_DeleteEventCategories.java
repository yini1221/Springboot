package com.example.demo.categories;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.EventCategories;
import com.example.demo.repository.EventCategoriesRepository;

@SpringBootTest
public class Test_DeleteEventCategories {

	@Autowired
	private EventCategoriesRepository eventCategoriesRepository;
	
	@Test
	public void deleteCategories() {
		Optional<EventCategories> eOptional = eventCategoriesRepository.findById(304);
		if(eOptional.isEmpty()) {
			System.out.println("查無此活動分類");
			return;
		}
		EventCategories eventCategories = eOptional.get();
		eventCategoriesRepository.delete(eventCategories);
		System.out.printf("刪除成功! 分類編號: %d 分類名稱: %s%n", eventCategories.getId(), eventCategories.getName());
		
	}
}
