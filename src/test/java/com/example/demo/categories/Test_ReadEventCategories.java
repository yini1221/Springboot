package com.example.demo.categories;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Event;
import com.example.demo.model.entity.EventCategories;
import com.example.demo.repository.EventCategoriesRepository;
import com.example.demo.repository.EventRepository;

@SpringBootTest
public class Test_ReadEventCategories {

	@Autowired
	private EventCategoriesRepository eventCategoriesRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
//	@Test
//	public void Read() {
//		List<EventCategories> eventCategories = eventCategoriesRepository.findAll();
//		eventCategories.forEach(categories -> {
//			System.out.printf("分類編號: %d, 分類名稱: %s%n", categories.getId(), categories.getName());
//		});
//	}
	
	@Test
	public void ReadEventByCategoryId() {
		List<Event> events = eventRepository.findByEventCategoriesId(302);
		events.forEach(event -> {
			System.out.printf("活動編號: %d, 活動名稱: %s%n", event.getId(), event.getTitle());
		});
	}
}
