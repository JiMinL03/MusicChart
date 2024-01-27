package com.example.register;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user.User;
public interface RegisterRespository extends JpaRepository<User,String>{
	List<User> findAllByRelatedId(String id);
}
