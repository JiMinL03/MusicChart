package com.example.register;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity(name = "Register")
//register 테이븘 생성
public class Register {
	//컬럼추가
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String mail;
	
	@Column(columnDefinition = "TEXT")
	private String password;
}
