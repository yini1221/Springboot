package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.EventDto;

public interface EventService {
	public List<EventDto> findAllEvents(); // 查詢所有活動
	public EventDto getEventById(Integer eventId); // 查詢單筆活動
	public EventDto addEventAndReturn(EventDto eventDto); // 新增活動
	public void updateEvent(Integer eventId, EventDto eventDto); // 修改活動
	public void deleteEvent(Integer eventId); // 刪除活動
}
