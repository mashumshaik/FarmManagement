package com.mgmt.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgmt.model.Farmer;
import com.mgmt.service.FarmerService;

@RestController
public class FarmerController {
	
	private final static Logger logger = Logger.getLogger(FarmerController.class.getName());
			
	@Autowired
	FarmerService farmerService;
	
	@GetMapping("/get-farmer/{id}")
	public ResponseEntity<Farmer> getFarmer(@PathVariable int id) {
		Farmer farmer = farmerService.getFarmer(id);
		if(farmer != null) {
			logger.info(farmer.toString());
			return new ResponseEntity<Farmer>(farmer, HttpStatus.OK);
		} else {
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add-farmer")
	public ResponseEntity<String> saveFarmer (@RequestBody Farmer farmer) {
		int id = farmerService.saveFarmer(farmer);
		if( id == -1) {
			return  new ResponseEntity<>("Mobile number already exists", HttpStatus.BAD_REQUEST);
		} else if(id != 0 ){
			return  new ResponseEntity<>("Successfully added farmer details ", HttpStatus.OK);
		} else {
			return  new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
