package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.exception.EventNotFoundException;
import com.example.demo.mapper.EventMapper;
import com.example.demo.model.dto.EventDto;
import com.example.demo.model.entity.EventCategories;
import com.example.demo.model.entity.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;

public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventMapper eventMapper;
	
	@Override
	public List<EventDto> findAllEvents() {
		return eventRepository.findAll() // event 集合
							  .stream() // event 串流
							  .map(eventMapper::toDto) //.map(event -> eventMapper.toDto(event))
							  .toList(); // eventDto 集合
	}

	@Override
	public EventDto getEventById(Integer eventId) {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new EventNotFoundException("找不到活動: eventId=" + eventId));
		return eventMapper.toDto(event);
	}

	@Override
	public void addEvent(EventDto eventDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEvent(String title, String description, String location, LocalDateTime startTime,
			LocalDateTime endTime, Integer maxParticipants, EventCategories eventCategories, String imageBase64) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEvent(EventDto eventDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEvent(String title, String description, String location, LocalDateTime startTime,
			LocalDateTime endTime, Integer maxParticipants, String imageBase64) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEvent(Integer eventId) {
		// TODO Auto-generated method stub
		
	}

}
