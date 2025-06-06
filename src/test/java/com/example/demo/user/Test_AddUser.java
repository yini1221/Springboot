package com.example.demo.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.UserDto;
import com.example.demo.service.UserService;

@SpringBootTest
public class Test_AddUser{
		
	@Autowired
	private UserService userService; 
	
	@Test
	public void addUser(){
		UserDto userDto = new UserDto();
		userDto.setUsername("Yini");
		userDto.setPassword("abc123");
		userDto.setEmail("yini1221@gmail.com");
		userDto.setCompleted(false);
		UserDto saved = userService.addUserAndReturn(userDto);
		System.out.printf("會員編號: %d%n會員名稱: %s%n會員信箱: %s%n驗證狀態: %s%n", saved.getId(), saved.getUsername(), saved.getEmail(), saved.getCompleted());
		
	}
}
