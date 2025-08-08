package com.infybuzz.controller;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@PostMapping("///")
	public String getById() {
		
		return "Success";
	}
}
