package com.mgmt.service;

import java.util.List;

import com.mgmt.model.Block;


public interface BlockService {
	
	List<Block> getBlockList(int farmerId);

	boolean saveBlockList(Block block);

}
