package com.example.musicchart.loginAndregister;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.musicchart.user.User;

public interface LoginAndRegisterRespository extends JpaRepository<User,String>{
}
