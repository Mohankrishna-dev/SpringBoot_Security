package com.jsp.Spring_Security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Spring_Security.entity.UserEntity;
import com.jsp.Spring_Security.service.UserService;

@RestController
public class UserController {
//@GetMapping("/")
//	public String msg() {
//		return "Spring Security classs";
//	}
//@GetMapping("/public")
//public String user1() {
//	return "this is public";
//}
//@GetMapping("/private")
//public String hello() {
//	return "this is private";
//}
//@GetMapping("/admin")
//public String admin() {
//	return "adminLogin";
//}
//@GetMapping("/user")
//public String user() {
//	return "User Login";
//}
	@Autowired
	private UserService us;
	
	@PostMapping("/save")
	public UserEntity saveUser(@RequestBody UserEntity u) {
		return us.saveUser(u);
	}

}
