package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginForm;
import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	public UserServiceImpl userService;

	@PostMapping("/login")
	public ResponseEntity<?> getUser(@RequestBody LoginForm log) {
		User user = userService.getUser(log.getEmail(), log.getPassword());
		if (user == null) {
			return new ResponseEntity<>("user not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/register")

	public ResponseEntity<?> registerUser(@RequestBody User log) {
		User user = userService.saveUser(log);

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}