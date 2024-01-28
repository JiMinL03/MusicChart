package com.example.musicchart.register;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.musicchart.DataNotFoundException;
import com.example.musicchart.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegisterService {
	private final RegisterRespository registerrespository;
	
	public boolean isIdAlreadyExistsId(String userId) { //이미 존재하는 아이디인지 확인
		Optional<User> oq = this.registerrespository.findById(userId);
		return oq.isPresent();
	}
	
	public List<User> getData(String id) {//id 키값과 같은 행의 데이터를 리턴한다.
		List<User> allData = this.registerrespository.findAllById(id);
		if (!allData.isEmpty()) {
			return allData;
		} else {
			throw new DataNotFoundException("user not found");
		}
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
