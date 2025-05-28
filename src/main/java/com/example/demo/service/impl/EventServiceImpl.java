package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EventNotFoundException;
import com.example.demo.mapper.EventMapper;
import com.example.demo.model.dto.EventDto;
import com.example.demo.model.entity.EventCategories;
import com.example.demo.model.entity.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
@Service
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
	public EventDto addEventAndReturn(EventDto eventDto) {
		Event event = eventMapper.toEntity(eventDto);
		Event eventSaved = eventRepository.save(event);
		return eventMapper.toDto(eventSaved);
	}

	@Override
	public void addEvent(String title, String description, String location, LocalDateTime startTime,
			LocalDateTime endTime, Integer maxParticipants, String imageBase64, EventCategories eventCategories) {
		EventDto eventDto = new EventDto(title, description, location, startTime, endTime, maxParticipants, imageBase64, eventCategories);
		addEventAndReturn(eventDto);
	}

	@Override
	public void updateEvent(Integer eventId, EventDto eventDto) {
		Optional<Event> optEvent = eventRepository.findById(eventId);
		if(optEvent.isEmpty()) {
			throw new EventNotFoundException("更新失敗: 活動 " + eventId + "不存在");
		}
		eventDto.setEventId(eventId);
		Event event = eventMapper.toEntity(eventDto);
		eventRepository.save(event);
	}

	@Override
	public void updateEvent(Integer eventId, String title, String description, String location, LocalDateTime startTime, LocalDateTime endTime,
			Integer maxParticipants, String imageBase64, EventCategories eventCategories) {
		EventDto eventDto = new EventDto(eventId, title, description, location, startTime, endTime, maxParticipants, imageBase64, eventCategories);
		updateEvent(eventId, eventDto);
	}

	@Override
	public void deleteEvent(Integer eventId) {
		Optional<Event> optEvent = eventRepository.findById(eventId);
		if(optEvent.isEmpty()) {
			throw new EventNotFoundException("刪除失敗: 活動 " + eventId + "不存在");
		}
		eventRepository.deleteById(eventId);
	}

}
