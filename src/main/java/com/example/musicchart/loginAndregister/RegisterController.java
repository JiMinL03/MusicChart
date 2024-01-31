package com.example.musicchart.loginAndregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private final RegisterService registerservice;
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	@PostMapping
	@ResponseBody
	public String saveData(@RequestParam (name = "userName") String userName, @RequestParam (name = "userEmail") String userEmail, @RequestParam (name = "userId")String userId,
			@RequestParam (name = "userPassword") String userPassword) {
		boolean checkExistsId = registerservice.isIdAlreadyExistsId(userId);
		String existsIdMessage = "이미 존재하는 아이디입니다.";
		String nonExistsIdMessage = "사용할 수 있는 아이디입니다.";
		if (!checkExistsId) {
	        this.registerservice.saveData(userName, userEmail, userId, userPassword);
	        messagingTemplate.convertAndSend("/topic/registration", nonExistsIdMessage);
	        return nonExistsIdMessage;
	    } else {
	        messagingTemplate.convertAndSend("/topic/registration", existsIdMessage);
	        return existsIdMessage;
	    }
	}
}
