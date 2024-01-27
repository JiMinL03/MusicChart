package com.example.user;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity
//register 테이븘 생성
public class User {
	// 컬럼추가
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@Column(columnDefinition = "TEXT")
	private String name;

	@Column(columnDefinition = "TEXT")
	private String mail;

	@Column(columnDefinition = "TEXT")
	private String password;
}
