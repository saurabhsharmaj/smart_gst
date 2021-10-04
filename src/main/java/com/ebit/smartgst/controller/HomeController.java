package com.ebit.smartgst.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/403")
	public ResponseEntity<String> Forbidden() {
		try {
			

			return new ResponseEntity<>("FORBIDDEN", HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
}
