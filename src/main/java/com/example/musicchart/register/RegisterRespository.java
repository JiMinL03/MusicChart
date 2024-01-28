package com.example.musicchart.register;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.musicchart.user.User;

public interface RegisterRespository extends JpaRepository<User,String>{
	List<User> findAllById(String id);
}
