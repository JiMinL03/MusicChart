package com.example.musicchart.loginAndregister;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.musicchart.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegisterService {
	private final LoginAndRegisterRespository registerrespository;
	private final PasswordEncoder passwordEncoder;
	
	public boolean isIdAlreadyExistsId(String userId) { //이미 존재하는 아이디인지 확인
		Optional<User> oq = this.registerrespository.findById(userId);
		return oq.isPresent();
	}
	
	public void saveData(String userName, String userEmail, String userId, String userPassword) {
		User user = new User();
		user.setName(userName);
		user.setMail(userEmail);
		user.setId(userId);
		//비밀번호암호화-> build.gradle에 라이브러리 추가하여 설치
		user.setPassword(passwordEncoder.encode(userPassword));
		this.registerrespository.save(user);
	}
}
