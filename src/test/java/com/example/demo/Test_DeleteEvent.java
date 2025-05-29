package com.example.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Event;
import com.example.demo.repository.EventRepository;

@SpringBootTest
public class Test_DeleteEvent {

	@Autowired
	private EventRepository eventRepository;
	
	@Test
	public void deleteEvent() {
		Optional<Event> optEvent = eventRepository.findById(2);
		if (optEvent.isEmpty()) {
			System.out.println("查無此活動:" + 2);
			return;
		}
		Event event = optEvent.get();
		eventRepository.delete(event);
		System.out.println("刪除成功!活動編號: " + event.getId());
	}
}
