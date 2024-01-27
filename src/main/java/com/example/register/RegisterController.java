package com.example.register;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegisterController {
	@Autowired
	private final RegisterService registerservice;
	
	@PostMapping("/register")
	public String checkExistsId(@RequestParam String userId, RedirectAttributes redirectAttributes) {
	    String existsIdMessage = "이미 존재하는 아이디입니다.";
	    String nonExistsIdMessage = "사용할 수 있는 아이디입니다.";

	    if (this.registerservice.isIdAlreadyExistsId(userId)) {
	        redirectAttributes.addFlashAttribute("existsIdMessage", existsIdMessage);
	    } else {
	        redirectAttributes.addFlashAttribute("nonExistsIdMessage", nonExistsIdMessage);
	    }
	    return "redirect:/Login_Register";
	}
}
