package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.UserDto;

public interface UserService {
	public List<UserDto> findAllUsers(); // 查詢所有使用者
	public UserDto addUserAndReturn(UserDto userDto); // 新增使用者
	public void updateUser(Integer userId, UserDto userDto); // 修改會員資料(更改權限)
	public void deleteUser(Integer userId); // 刪除使用者

}
