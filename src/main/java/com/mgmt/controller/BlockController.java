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

import com.mgmt.model.Block;
import com.mgmt.service.BlockService;

@RestController
public class BlockController {
	
	@Autowired
	BlockService blockService;
	
	@GetMapping("/get-blockList/{farmerId}")
	public ResponseEntity<List<Block>> getBlockList(@PathVariable int farmerId) {
		List<Block> blockList = blockService.getBlockList(farmerId);
		if(blockList != null) {
			return new ResponseEntity<List<Block>>(blockList, HttpStatus.OK);
		} else {
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/save-blockList")
	public ResponseEntity<String> saveBlockList (@RequestBody Block block) {
		if( blockService.saveBlockList(block)) {
			return  new ResponseEntity<>("Successfully saved block details ", HttpStatus.OK);
		} else {
			return  new ResponseEntity<>("Add block details failed", HttpStatus.BAD_REQUEST);
		}	
	}
}
