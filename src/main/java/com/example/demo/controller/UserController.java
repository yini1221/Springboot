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

import com.example.demo.model.dto.UserDto;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/admin/members")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<UserDto>>> findAllUsers() {
		List<UserDto> userDtos = userService.findAllUsers();
		return ResponseEntity.ok(ApiResponse.success("查詢成功", userDtos));
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse<UserDto>> addUser(@Valid @RequestBody UserDto userDto) {
		UserDto createdUser = userService.addUserAndReturn(userDto);
		return ResponseEntity.ok(ApiResponse.success("新增成功", createdUser));
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<ApiResponse<UserDto>> updateUser(@PathVariable Integer userId, @Valid @RequestBody UserDto userDto) {
		userService.updateUser(userId, userDto);
		return ResponseEntity.ok(ApiResponse.success("更新成功", userDto));
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse<Integer>> deleteUser(Integer userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok(ApiResponse.success("刪除成功", userId));
	}
}
