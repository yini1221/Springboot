package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Event;
import com.example.demo.model.entity.EventCategories;
import com.example.demo.repository.EventCategoriesRepository;
import com.example.demo.repository.EventRepository;

@SpringBootTest
public class Test_UpdateEvent {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventCategoriesRepository eventCategoriesRepository;
	
	@Test
	public void updateEvent() {
		Optional<Event> optEvent = eventRepository.findById(1);
		if(optEvent.isEmpty()) {
			System.out.println("查無活動");
			return;
		}
		
		Optional<EventCategories> optEventCategories = eventCategoriesRepository.findById(302);
		if(optEventCategories.isEmpty()) {
			System.out.println("查無此活動分類");
			return;
		}
				
		Event event = optEvent.get();
		event.setTitle("♡ (粉紅湖)|油性粉彩創作");
		event.setDescription("繪畫是一件美好有趣的事。 生活中有很多的快樂、煩悶都能透過簡單的手繪，將情感表達在作品裡，記錄心情或療癒自己。");
		event.setLocation("台北市的租借空間");
		
		LocalDateTime startTime = LocalDateTime.of(2025, 6, 22, 14, 0);
		LocalDateTime endTime = LocalDateTime.of(2025, 6, 22, 16, 0);				
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		
		event.setMaxParticipants(50);
		
		try (InputStream is = getClass().getClassLoader().getResourceAsStream("test.png")) {
		    if (is == null) {
		        System.out.println("圖片讀取失敗");
		        return;
		    }
		    byte[] imageBytes = is.readAllBytes();
		    String imageBase64 = Base64.getEncoder().encodeToString(imageBytes);
		    event.setImageBase64(imageBase64);
		} catch (IOException e) {
		    e.printStackTrace();
		    System.out.println("圖片讀取失敗");
		    return;
		}		
		event.setEventCategories(eventCategoriesRepository.findById(302).get());
		
		Event saved = eventRepository.save(event);
		System.out.println("修改成功！活動ID: " + saved.getId());
	}
}
