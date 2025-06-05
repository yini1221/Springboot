package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.EventCategoryDto;
import com.example.demo.model.dto.EventDto;

public interface EventCategoriesService {
	public List<EventCategoryDto> findAllEventCategories(); // 查詢所有分類
	public List<EventDto> getEventById(Integer CategoryId); // 查詢該分類所包含的活動列表
	public EventCategoryDto addEventCategoryAndReturn(EventCategoryDto eventCategoryDto); // 新增分類
	public void addEventCategory(String name); // 新增分類
	public void updateEventCategory(Integer CategoryId, EventCategoryDto eventCategoryDto); // 修改分類名稱
	public void updateEventCategory(Integer CategoryId, String name);// 修改分類名稱
	public void deleteEventCategory(Integer CategoryId); // 刪除活動
}
