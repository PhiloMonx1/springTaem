package com.week05.springtaem.controller;

import com.week05.springtaem.model.Users;
import com.week05.springtaem.model.dto.UserRequestDto;
import com.week05.springtaem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("{username}")
	public Users readUser(@PathVariable String username){
		return userService.readUser(username);
	}

	@PostMapping("/signup")
	public String signUp(@RequestBody UserRequestDto userRequestDto){
		return userService.signUp(userRequestDto);
	}
}
