package com.example.login;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.User;

public interface LoginRespository extends JpaRepository<User,Integer> {

}
