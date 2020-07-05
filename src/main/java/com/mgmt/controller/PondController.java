package com.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgmt.model.Pond;
import com.mgmt.service.PondService;

@RestController
public class PondController {

	@Autowired
	PondService pondService;
	
	@GetMapping("/get-pondList/{farmerId}")
	public ResponseEntity<List<Pond>> getPondList(@PathVariable int farmerId) {
		List<Pond> pondList = pondService.getPondList(farmerId);
		if(pondList != null) {
			return new ResponseEntity<List<Pond>>(pondList, HttpStatus.OK);
		} else {
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/save-pondlist")
	public ResponseEntity<String> savePondList (@RequestBody List<Pond> pondList) {
		if( pondService.savePondList(pondList)) {
			return  new ResponseEntity<>("Successfully saved pond details ", HttpStatus.OK);
		} else {
			return  new ResponseEntity<>("Add pond details failed", HttpStatus.BAD_REQUEST);
		}	
	}
}
