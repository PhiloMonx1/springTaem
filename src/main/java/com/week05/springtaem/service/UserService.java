package com.week05.springtaem.service;

import com.week05.springtaem.model.Users;
import com.week05.springtaem.model.dto.UserRequestDto;
import com.week05.springtaem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public String signUp(UserRequestDto userRequestDto) {
		String username = userRequestDto.getUsername();
		String password = userRequestDto.getPassword();
		String password2 = userRequestDto.getPassword2();

		if(password.equals(password2)){
			Optional<Users> oldUser = userRepository.findById(username);
			if(!oldUser.isPresent()){
				Users newUser = new Users(username, password);
				userRepository.save(newUser);
				return username + "님! 회원가입을 축하드려요";
			}else return "이미 존재하는 유저입니다.";
		}else return "비밀번호가 일치하지 않습니다.";
	}

	public Users readUser(String username) {
		return userRepository.findById(username)
				.orElseThrow(() -> new NullPointerException("존재하지 않는 사용자입니다."));
	}
}


