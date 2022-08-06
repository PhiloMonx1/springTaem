package com.week05.springtaem.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {
	private String username;
	private String password;
	private String password2;
}
