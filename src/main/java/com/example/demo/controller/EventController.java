package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.EventDto;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/admin/events")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class EventController {

	@Autowired
	private EventService eventService;
		
	@GetMapping
	public ResponseEntity<ApiResponse<List<EventDto>>> findAllEvents() {
		List<EventDto> eventDtos = eventService.findAllEvents();
		String message = eventDtos.isEmpty() ? "查無活動" : "查詢成功";
		return ResponseEntity.ok(ApiResponse.success(message, eventDtos));
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse<EventDto>> addEvent(@Valid @RequestBody EventDto eventDto) {
		EventDto createdEvent = eventService.addEventAndReturn(eventDto);
		return ResponseEntity.ok(ApiResponse.success("新增成功", createdEvent));
	}
	
	@GetMapping("/{eventId}")
	public ResponseEntity<ApiResponse<EventDto>> getEvent(@PathVariable Integer eventId){
		EventDto eventDto = eventService.getEventById(eventId);
		return ResponseEntity.ok(ApiResponse.success("查詢成功", eventDto));
	}
	
	@PutMapping("/{eventId}")
	public ResponseEntity<ApiResponse<EventDto>> updateEvent(@PathVariable Integer eventId, @Valid @RequestBody EventDto eventDto) {
		eventService.updateEvent(eventId, eventDto);
		return ResponseEntity.ok(ApiResponse.success("更新成功", eventDto));
	}
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<ApiResponse<Integer>> deleteEvent(@PathVariable Integer eventId) {
		eventService.deleteEvent(eventId);
		return ResponseEntity.ok(ApiResponse.success("刪除成功", eventId));
	}
	
}
