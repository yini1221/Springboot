package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
public class Test_AddEvent{
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventCategoriesRepository eventCategoriesRepository;
	
	@Test
	public void addEvent(){
		//尋找分類
		Optional<EventCategories> optEventCategories = eventCategoriesRepository.findById(301);
		if(optEventCategories.isEmpty()) {
			System.out.println("查無此分類");
			return;
		}
		
		LocalDateTime startTime = LocalDateTime.of(2025, 6, 7, 14, 0);
		LocalDateTime endTime = LocalDateTime.of(2025, 6, 7, 17, 0);
				
		Event event = new Event();
		event.setTitle("【茶香繚繞・仕紳雅聚】手作茶香袋體驗");
		event.setDescription("這是內容");
		event.setLocation("這是地點");
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		event.setMaxParticipants(40);
		
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
		
		event.setEventCategories(optEventCategories.get());
		
		Event saved = eventRepository.save(event);
		System.out.println("新增成功！活動ID: " + saved.getId());
	}
}
