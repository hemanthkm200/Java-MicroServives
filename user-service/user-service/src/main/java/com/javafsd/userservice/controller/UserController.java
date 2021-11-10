package com.javafsd.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javafsd.userservice.entity.User;
import com.javafsd.userservice.service.UserService;
import com.javafsd.userservice.vo.ResponceTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private  UserService userservice;	

	@PostMapping("/")
	public User saveUser(@RequestBody User userId)
	{
		return userservice.saveUser(userId);

	}
	@GetMapping("/{id}")	
	public ResponceTemplate getuserByDepartmentId(@Validated @PathVariable("id") Long userId) {
		log.info("User With Department");
		return userservice.getUserWithDepartment(userId);
	}


}
