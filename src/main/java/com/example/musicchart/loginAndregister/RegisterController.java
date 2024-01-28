package com.example.musicchart.loginAndregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private final RegisterService registerservice;

	@PostMapping
	public String saveData(@RequestParam (name = "userName") String userName, @RequestParam (name = "userEmail") String userEmail, @RequestParam (name = "userId")String userId,
			@RequestParam (name = "userPassword") String userPassword, Model model) {
		boolean checkExistsId = registerservice.isIdAlreadyExistsId(userId);
		String existsIdMessage = "이미 존재하는 아이디입니다.";
		String nonExistsIdMessage = "사용할 수 있는 아이디입니다.";
		if (!checkExistsId) {
			this.registerservice.saveData(userName, userEmail, userId, userPassword);
			model.addAttribute("nonExistsIdMessage", nonExistsIdMessage);
		} else {
			model.addAttribute("existsIdMessage", existsIdMessage);
		}
		return "Login_Register";
	}

//	@PostMapping
//	public String checkExistsId(@RequestParam(name = "userId") String userId, Model model) {
//		String existsIdMessage = "이미 존재하는 아이디입니다.";
//		String nonExistsIdMessage = "사용할 수 있는 아이디입니다.";
//
//		if (registerservice.isIdAlreadyExistsId(userId)) {
//			model.addAttribute("existsIdMessage", existsIdMessage);
//		} else {
//			model.addAttribute("nonExistsIdMessage", nonExistsIdMessage);
//		}
//		return "Login_Register"; // 실제 페이지 이름에 맞게 변경해야 합니다.
//	}
	
}
