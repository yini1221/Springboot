package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.entity.Event;
import com.example.demo.repository.EventRepository;


@SpringBootTest
public class Test_ReadEvent {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Test
	@Transactional
	public void read() {
		List<Event> events = eventRepository.findAll();
		events.forEach(event -> {
			System.out.printf("活動編號: %d, 活動名稱: %s%n活動地點: %s%n開始時間: %s%n結束時間: %s%n建立時間: %s%n更新時間: %s%n人數上限: %d%n 圖片:%s%n 活動分類: %s%n"
							  , event.getId(), event.getTitle(), event.getLocation(), event.getStartTime(), event.getEndTime(), event.getCreatedAt(), event.getUpdatedAt(), event.getMaxParticipants(), event.getImageBase64(), event.getEventCategories().getName());
		});
	}
}
