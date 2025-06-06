package com.example.demo.user;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.Event;
import com.example.demo.model.entity.EventCategories;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.UserRole;
import com.example.demo.repository.EventCategoriesRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@SpringBootTest
public class Test_UpdateUser {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
		
	@Test
	public void updateUser() {	
		
		Optional<User> optUser = userRepository.findById(3);
		if (optUser.isEmpty()) {
			System.out.println("查無會員");
		}
		User user = optUser.get();
		
		UserDto userDto = new UserDto();
		userDto.setId(10);
		userDto.setUsername("John");
		userDto.setEmail("mary@gmail.com");
		userDto.setPassword("abcdef123456");
		userDto.setCompleted(false);
		userDto.setCreatedAt(LocalDateTime.now());
		userDto.setRole(UserRole.GUEST);
		
		userService.updateUser(3, userDto);
		
		System.out.println("修改成功！會員編號: " + user.getId());
	}
}
