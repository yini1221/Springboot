package com.example.demo.user;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.Event;
import com.example.demo.model.entity.User;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.UserService;


@SpringBootTest
public class Test_ReadUser {

	@Autowired
	private UserService userService; 
	
	@Test
	@Transactional
	public void read() {
		List<UserDto> users = userService.findAllUsers();
		users.forEach(user -> {
			System.out.printf("會員編號: %d%n會員名稱: %s%n會員信箱: %s%n驗證狀態: %s%n會員密碼: %s%n加入時間: %s%n會員權限: %s%n", 
					user.getId(), user.getUsername(), user.getEmail(), user.getCompleted(), user.getPassword(), user.getCreatedAt(), user.getRole());
		});
	}
}
