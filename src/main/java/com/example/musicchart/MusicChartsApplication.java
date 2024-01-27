package com.example.musicchart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.user")
public class MusicChartsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicChartsApplication.class, args);
	}

}
//여긴 신경 안 써도 됨~