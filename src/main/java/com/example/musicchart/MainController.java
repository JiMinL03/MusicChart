package com.example.musicchart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/welcome")
	public String main() {
		return "Login_Register";
	}
}
//이 코드는 웹에서 http://localhost:8080/MusicCharts로 요청이 들어오면
//MusicCharts.html파일로 넘어가게 하는 코드야!
//@GetMapping은 웹에서 요청이 들어오면 서버에서 데이터를 제공하는거!
