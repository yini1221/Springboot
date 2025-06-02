package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.model.dto.EventCategoryDto;
import com.example.demo.model.dto.EventDto;

public interface EventService {
	public List<EventDto> findAllEvents(); // 查詢所有活動
	public EventDto getEventById(Integer eventId); // 查詢單筆活動
	public EventDto addEventAndReturn(EventDto eventDto); // 新增活動
	public void addEvent(String title, String description, String location, LocalDateTime startTime, LocalDateTime endTime, Integer maxParticipants, String imageBase64, EventCategoryDto eventCategory); // 新增活動
	public void updateEvent(Integer eventId, EventDto eventDto); // 修改活動
	public void updateEvent(Integer eventId, String title, String description, String location, LocalDateTime startTime, LocalDateTime endTime, Integer maxParticipants, String imageBase64, EventCategoryDto eventCategory);// 修改活動
	public void deleteEvent(Integer eventId); // 刪除活動
}
