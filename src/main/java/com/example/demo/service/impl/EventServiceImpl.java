package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.exception.EventNotFoundException;
import com.example.demo.mapper.EventMapper;
import com.example.demo.model.dto.EventDto;
import com.example.demo.model.entity.EventCategories;
import com.example.demo.model.entity.Event;
import com.example.demo.repository.EventCategoriesRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventCategoriesRepository eventCategoriesRepository;
	
	@Autowired
	private EventMapper eventMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
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
				.orElseThrow(() -> new EventNotFoundException("查詢失敗: 活動編號 " + eventId + " 不存在"));
		return eventMapper.toDto(event);
	}
	
	@Override
	public EventDto addEventAndReturn(EventDto eventDto) {
		Event event = eventMapper.toEntity(eventDto);
		Event eventSaved = eventRepository.save(event);
		return eventMapper.toDto(eventSaved);
	}

	@Override
	public void updateEvent(Integer eventId, EventDto eventDto) {
		Optional<Event> optEvent = eventRepository.findById(eventId);
		if(optEvent.isEmpty()) {
			throw new EventNotFoundException("更新失敗: 活動編號 " + eventId + " 不存在");
		}
		Event event = optEvent.get();
		modelMapper.map(eventDto, event);
		
	    Integer categoryId = eventDto.getEventCategory().getId();
	    EventCategories category = eventCategoriesRepository.findById(categoryId)
	            .orElseThrow(() -> new CategoryNotFoundException("查無此分類: " + categoryId));	 
	    event.setEventCategories(category);
		eventRepository.save(event);
	}

	@Override
	public void deleteEvent(Integer eventId) {
		Optional<Event> optEvent = eventRepository.findById(eventId);
		if(optEvent.isEmpty()) {
			throw new EventNotFoundException("刪除失敗: 活動編號 " + eventId + " 不存在");
		}
		eventRepository.deleteById(eventId);
	}

}
