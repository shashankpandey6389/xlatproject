package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	User saveUser(User user) ;
	List<User> getAllUser();
	User updateUser(User user,Integer id);
	void deleteUser(Integer id);
	User getUser(String email , String password);

}