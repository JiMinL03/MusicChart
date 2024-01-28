package com.example.musicchart.loginAndregister;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.musicchart.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginService {
	private final LoginAndRegisterRespository loginrespository;

	// 입력한 아이디와 비밀번호를 조회하여 참과 거짓을 리턴한다.
	public boolean isExistsIdAndPw(String id, String pw) {
		
		Optional<User> userData = this.loginrespository.findById(id);
		
		if (userData.isPresent()) {
			User user = userData.get();
			String storedPassword = user.getPassword();
			if (pw.equals(storedPassword)) {
				return true;
			} else
				return false;
		}
		return false;
	}
}
