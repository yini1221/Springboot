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

import com.example.demo.model.dto.EventCategoryDto;
import com.example.demo.model.dto.EventDto;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.EventCategoriesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/admin/event-categories")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class EventCategoriesController {

	@Autowired
	private EventCategoriesService eventCategoriesService;
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<EventCategoryDto>>> findAllEventCategories(){
		List<EventCategoryDto> eventCategoryDtos = eventCategoriesService.findAllEventCategories();
		String message = eventCategoryDtos.isEmpty() ? "查無分類" : "查詢成功";
		return ResponseEntity.ok(ApiResponse.success(message, eventCategoryDtos));
	}

	@PostMapping
	public ResponseEntity<ApiResponse<EventCategoryDto>> addEventCategory(@Valid @RequestBody EventCategoryDto eventCategoryDto) {
		EventCategoryDto createdEventCategoryDto = eventCategoriesService.addEventCategoryAndReturn(eventCategoryDto);
		return ResponseEntity.ok(ApiResponse.success("新增成功", createdEventCategoryDto));
	}
	
	@GetMapping("/{CategoryId}")
	public ResponseEntity<ApiResponse<List<EventDto>>> getEvent(@PathVariable Integer CategoryId){
		List<EventDto> eventDtos = eventCategoriesService.getEventById(CategoryId);
		return ResponseEntity.ok(ApiResponse.success("查詢成功", eventDtos));
	}
	
	@PutMapping("/{CategoryId}")
	public ResponseEntity<ApiResponse<EventCategoryDto>> updateEventCategory(@PathVariable Integer CategoryId, @Valid @RequestBody EventCategoryDto eventCategoryDto) {
		eventCategoriesService.updateEventCategory(CategoryId, eventCategoryDto);
		return ResponseEntity.ok(ApiResponse.success("更新成功", eventCategoryDto));
	}
	
	@DeleteMapping("/{CategoryId}")
	public ResponseEntity<ApiResponse<Integer>> deleteEventCategory(@PathVariable Integer CategoryId) {
		eventCategoriesService.deleteEventCategory(CategoryId);
		return ResponseEntity.ok(ApiResponse.success("刪除成功", CategoryId));
	}
	
	
	
	
}
