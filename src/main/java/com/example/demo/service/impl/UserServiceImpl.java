package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.model.entity.UserRole;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.Hash;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<UserDto> findAllUsers() {
		return userRepository.findAll()
				.stream()
				.map(userMapper::toDto)
				.toList();
	}

	@Override
	public UserDto addUserAndReturn(UserDto userDto) {
		User user = userMapper.toEntity(userDto);
		String password = userDto.getPassword();
		String hashSalt = Hash.getSalt();
		String hashPassword = Hash.getHash(password, hashSalt);
		user.setHashPassword(hashPassword);
		user.setHashSalt(hashSalt);
		user.setCompleted(false);
		user.setRole(UserRole.ADMIN);
		User userSaved = userRepository.save(user);
		return userMapper.toDto(userSaved);
	}

	@Override
	public void updateUser(Integer userId, UserDto userDto) {
		Optional<User> optUser = userRepository.findById(userId);
		if (optUser.isEmpty()) {
			throw new UserNotFoundException("更新失敗: 會員編號 " + userId + " 不存在");
		}
		User user = optUser.get();
		modelMapper.map(userDto, user);
		
		userRepository.save(user);		
	}

	@Override
	public void deleteUser(Integer userId) {
		Optional<User> optUser = userRepository.findById(userId);
		if (optUser.isEmpty()) {
			throw new UserNotFoundException("刪除失敗: 會員編號 " + userId + " 不存在");
		}
		User user = optUser.get();
		
		userRepository.deleteById(userId);		
	}

}
