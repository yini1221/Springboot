package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.mapper.EventCategoryMapper;
import com.example.demo.mapper.EventMapper;
import com.example.demo.model.dto.EventCategoryDto;
import com.example.demo.model.dto.EventDto;
import com.example.demo.model.entity.EventCategories;
import com.example.demo.repository.EventCategoriesRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventCategoriesService;

@Service
public class EventCategoriesServiceImpl implements EventCategoriesService{

	@Autowired
	private EventCategoriesRepository eventCategoriesRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventCategoryMapper eventCategoryMapper;

	@Autowired
	private EventMapper eventMapper;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<EventCategoryDto> findAllEventCategories() {
		return eventCategoriesRepository.findAll()
				.stream()
				.map(eventCategoryMapper::toDto)
				.toList();
	}

	@Override
	public List<EventDto> getEventById(Integer CategoryId) {		
		return eventRepository.findByEventCategoriesId(CategoryId)
				.stream()
				.map(eventMapper::toDto)
				.toList();
	}

	@Override
	public EventCategoryDto addEventCategoryAndReturn(EventCategoryDto eventCategoryDto) {
		EventCategories eventCategories = eventCategoryMapper.toEntity(eventCategoryDto);
		EventCategories saved = eventCategoriesRepository.save(eventCategories);
		return eventCategoryMapper.toDto(saved);
	}

	@Override
	public void addEventCategory(String name) {
		EventCategoryDto eventCategoryDto = new EventCategoryDto(name);
		addEventCategoryAndReturn(eventCategoryDto);
	}

	@Override
	public void updateEventCategory(Integer CategoryId, EventCategoryDto eventCategoryDto) {
		Optional<EventCategories> optEventCategory = eventCategoriesRepository.findById(CategoryId);
		if (optEventCategory.isEmpty()) {
			throw new CategoryNotFoundException("更新失敗: 分類編號 " + CategoryId + "不存在");
		}
		EventCategories eventCategories = optEventCategory.get();
		modelMapper.map(eventCategoryDto, eventCategories);		
		eventCategoriesRepository.save(eventCategories);
	}

	@Override
	public void updateEventCategory(Integer CategoryId, String name) {
		EventCategoryDto eventCategoryDto = new EventCategoryDto(name);
		updateEventCategory(CategoryId, eventCategoryDto);
	}

	@Override
	public void deleteEventCategory(Integer CategoryId) {
		Optional<EventCategories> optEventCategory = eventCategoriesRepository.findById(CategoryId);
		if (optEventCategory.isEmpty()) {
			throw new CategoryNotFoundException("刪除失敗: 分類編號 " + CategoryId + "不存在");
		}
		eventCategoriesRepository.deleteById(CategoryId);
	}

}
