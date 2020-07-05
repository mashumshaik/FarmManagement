package com.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mgmt.service.FarmerService;

@RestController
public class LoginController {

	@Autowired
	FarmerService farmerService;
	
	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestParam String mobileNumber,@RequestParam String password) {
		
		if(farmerService.getByMobileNumberAndPassword(mobileNumber,password)) {
			return new ResponseEntity<String>("Successfully authenticated", HttpStatus.OK);
		} else {
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
