package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.EventDto;
import com.example.demo.model.entity.Event;

@Component // 此物件由 Springboot 來管理
public class EventMapper {

	@Autowired
	private ModelMapper modelMapper;

	public EventDto toDto(Event event) {
		// Entity 轉 DTO
		return modelMapper.map(event, EventDto.class);
	}	

	public Event toEntity(EventDto eventDto) {
		// DTO 轉 Entity
		return modelMapper.map(eventDto, Event.class);
	}
}
