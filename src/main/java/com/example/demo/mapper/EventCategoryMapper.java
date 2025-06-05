package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.EventCategoryDto;
import com.example.demo.model.entity.EventCategories;

@Component // 此物件由 Springboot 來管理
public class EventCategoryMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EventCategoryDto toDto(EventCategories eventCategories) {
		EventCategoryDto dto = modelMapper.map(eventCategories, EventCategoryDto.class);
		return dto;
	}
	
	public EventCategories toEntity(EventCategoryDto eventCategoryDto) {
		EventCategories eventCategories = modelMapper.map(eventCategoryDto, EventCategories.class);
		return eventCategories;
	}
}
