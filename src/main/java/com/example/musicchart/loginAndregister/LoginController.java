package com.example.musicchart.loginAndregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping("/login")
@RequiredArgsConstructor
@Controller
public class LoginController {
	@Autowired
	private final LoginService loginservice;

	@PostMapping
	public String successLogin(@RequestParam(name = "userId") String userId,
			@RequestParam(name = "userPassword") String userPassword, Model model) {

		boolean isExistsName = this.loginservice.isExistsIdAndPw(userId, userPassword);
		

		if (isExistsName) {
			model.addAttribute("isExistsName", isExistsName);
			return "MusicCharts";
		} else
			return "Login_Register";
	}
}
