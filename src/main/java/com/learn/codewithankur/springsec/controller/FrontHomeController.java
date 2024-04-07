package com.learn.codewithankur.springsec.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontHomeController {

	
	@GetMapping("/signin")
	public String signin(){
		
		return "login.html";
	}
}
