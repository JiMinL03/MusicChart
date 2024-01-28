package com.example.musicchart.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//register 테이븘 생성
public class User {
	// 컬럼추가
	@Id
	@Column(columnDefinition = "VARCHAR(255)")
	private String id;

	@Column(columnDefinition = "TEXT")
	private String name;

	@Column(columnDefinition = "TEXT")
	private String mail;

	@Column(columnDefinition = "TEXT")
	private String password;
}
