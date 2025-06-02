package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.EventCategoryDto;
import com.example.demo.model.dto.EventDto;
import com.example.demo.model.entity.Event;
import com.example.demo.model.entity.EventCategories;

import jakarta.annotation.PostConstruct;

@Component // 此物件由 Springboot 來管理
public class EventMapper {

	@Autowired
	private ModelMapper modelMapper;

	@PostConstruct
    public void init() {
        // 手動映射 Event -> EventDto
        modelMapper.typeMap(Event.class, EventDto.class).addMappings(mapper -> {
            mapper.map(src -> src.getEventCategories().getId(),
                       (dest, value) -> dest.getEventCategory().setId((Integer) value));

            mapper.map(src -> src.getEventCategories().getCategoryName(),
                       (dest, value) -> dest.getEventCategory().setCategoryName((String) value));
        });

        // 反向映射 DTO -> Entity
        modelMapper.typeMap(EventDto.class, Event.class).addMappings(mapper -> {
            mapper.skip(Event::setEventCategories); // 後續另行處理
        });
    }
	
	public EventDto toDto(Event event) {
		// Entity 轉 DTO
		EventDto dto = modelMapper.map(event, EventDto.class);
		dto.setEventCategory(new EventCategoryDto(event.getEventCategories().getId(), event.getEventCategories().getCategoryName()));
		return dto;
	}	

	public Event toEntity(EventDto eventDto) {
		// DTO 轉 Entity
		Event event = modelMapper.map(eventDto, Event.class);
		EventCategories eventCategories = new EventCategories();
		eventCategories.setId(eventDto.getEventCategory().getId());
		event.setEventCategories(eventCategories);
		return event;
	}
}
