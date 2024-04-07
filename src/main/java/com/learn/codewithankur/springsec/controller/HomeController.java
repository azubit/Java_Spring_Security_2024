package com.learn.codewithankur.springsec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {


	@GetMapping("/in")
	public String home() {
		return "this is home page";
	}
	@GetMapping("/login")
	public String login() {
		return "this is login page";
	}
	@GetMapping("/logout")
	public String logout() {
		return "this is logout page";
	}
}
