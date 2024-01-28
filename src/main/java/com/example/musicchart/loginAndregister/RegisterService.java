package com.example.musicchart.loginAndregister;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.musicchart.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegisterService {
	private final LoginAndRegisterRespository registerrespository;
	
	public boolean isIdAlreadyExistsId(String userId) { //이미 존재하는 아이디인지 확인
		Optional<User> oq = this.registerrespository.findById(userId);
		return oq.isPresent();
	}
	
	public void saveData(String userName, String userEmail, String userId, String userPassword) {
		User user = new User();
		user.setName(userName);
		user.setMail(userEmail);
		user.setId(userId);
		user.setPassword(userPassword);
		this.registerrespository.save(user);
	}
}
