package com.example.demo.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;

import jakarta.annotation.PostConstruct;

@Component // 此物件由 Springboot 來管理
public class UserMapper {

	@Autowired
	private ModelMapper modelMapper;
	
    @PostConstruct
    public void init() {
        modelMapper.typeMap(UserDto.class, User.class).addMappings(mapper -> {
            mapper.skip(User::setId);         
            mapper.skip(User::setCreatedAt);  
        });
    }
	
	public UserDto toDto(User user) {
		UserDto dto = modelMapper.map(user, UserDto.class);
		return dto;
	}
	
	public User toEntity(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}
}
