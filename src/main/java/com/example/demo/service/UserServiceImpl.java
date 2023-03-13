package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user, Integer id) {
		// TODO Auto-generated method stub
Optional<User> getUser = userRepository.findById(id);

		
		
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
Optional<User> getUser = userRepository.findById(id);
		
		userRepository.deleteById(id);
		
	}

	@Override
	public User getUser(String email, String password) {
		// TODO Auto-generated method stub
		User getUserOptional = userRepository.findByEmailAndPassword(email,password);
		return getUserOptional;
	}

	


}