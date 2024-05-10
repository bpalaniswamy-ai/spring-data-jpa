package com.example.spring.data.jpa.controller;

import com.example.spring.data.jpa.entity.User;
import com.example.spring.data.jpa.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/ping")
	public String ping() {
		log.info("UserController::ping");
		return "Service is up";
	}

	@GetMapping("/users")
	public List<User> getUsers(){
		log.info("UserController::getUsers");
		return userService.getUsers();
	}

	@GetMapping("/users/usersByProfession/{profession}")
	public List<User> getUsersByProfession(@PathVariable String profession){
		log.info("UserController::getUsersByProfession : {}", profession);
		return userService.getUsersByProfession(profession);
	}
	@GetMapping("/users/countByAge/{age}")
	public String getCountByAge(@PathVariable String age){
		log.info("UserController::getCountByAge : {}", age);
		return "total no Of Records : " + userService.countByAge(age);
	}

	@DeleteMapping("/users/{name}")
	public List<User> deleteUser(@PathVariable String name){
		log.info("UserController::deleteUser : {}", name);
		return userService.deleteUser(name);
	}
}
