package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("api/v1")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUser(){
		
		List<User> allUsers = userservice.getAllUsers();
		if(allUsers!=null) {
			return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("List is empty",HttpStatus.NO_CONTENT);
	}
	
}
