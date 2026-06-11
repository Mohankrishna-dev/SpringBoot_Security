package com.jsp.Spring_Security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Security {
@GetMapping("/")
	public String msg() {
		return "Spring Security classs";
	}
@GetMapping("/public")
public String user1() {
	return "this is public";
}
@GetMapping("/private")
public String hello() {
	return "this is private";
}
@GetMapping("/admin")
public String admin() {
	return "adminLogin";
}
@GetMapping("/user")
public String user() {
	return "User Login";
}


}
