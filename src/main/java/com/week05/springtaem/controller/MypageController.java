package com.week05.springtaem.controller;

import com.week05.springtaem.model.dto.MypageDto;
import com.week05.springtaem.model.dto.UsernameDto;
import com.week05.springtaem.service.MypageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MypageController {
	private final MypageService mypageService;

	@Autowired
	public MypageController(MypageService mypageService) {
		this.mypageService = mypageService;
	}

	@GetMapping("/auth/mypage/{userId}")
	public MypageDto readMypage(@PathVariable Long userId, UsernameDto usernameDto){
		return mypageService.readMypage(userId, usernameDto);
	}

}
