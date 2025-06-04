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
public class Test_AddEvent{
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventCategoriesRepository eventCategoriesRepository;
	
	@Test
	public void addEvent(){
		//尋找分類
		Optional<EventCategories> optEventCategories = eventCategoriesRepository.findById(302);
		if(optEventCategories.isEmpty()) {
			System.out.println("查無此分類");
			return;
		}
		
		LocalDateTime startTime = LocalDateTime.of(2025, 6, 14, 14, 0);
		LocalDateTime endTime = LocalDateTime.of(2025, 6, 14, 16, 0);
				
		Event event = new Event();
		event.setTitle("花兒都去哪裡了_荷蘭藝術之旅分享會");
		event.setDescription("從一幅畫作到一座城市，荷蘭始終是藝術與建築交織的實驗場。 我將帶領學員穿越安塞爾・基弗廢墟般的記憶現場、梵谷的炙熱筆觸與蒙德里安的幾何秩序，深入理解這片低地國度如何以獨特的方式思考「空間」與「存在」。 同時分享這趟荷蘭藝術之旅的精彩景點與實用路線——阿姆斯特丹的水上住宅、馬斯垂克的歷史城鎮、各地美術館路線與交通安排，讓未來想要去荷蘭旅遊的朋友可以在美學與旅行之間自由遊走。");
		event.setLocation("台灣台北市中正區南陽街38巷2號");
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		event.setMaxParticipants(40);
		
		try (InputStream is = getClass().getClassLoader().getResourceAsStream("event.jpg")) {
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
