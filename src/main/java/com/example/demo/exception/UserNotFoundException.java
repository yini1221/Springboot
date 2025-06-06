package com.example.demo.exception;

public class UserNotFoundException extends EventException {

	public UserNotFoundException(String message) {
		super(message);
	}
}
