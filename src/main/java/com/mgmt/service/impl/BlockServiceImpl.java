package com.mgmt.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgmt.model.Block;
import com.mgmt.repository.BlockRepository;
import com.mgmt.service.BlockService;

@Service
public class BlockServiceImpl implements BlockService {

	private static final Logger logger = Logger.getLogger(PondServiceImpl.class.getName());
	@Autowired
	BlockRepository blockRepository;
	
	@Override
	public List<Block> getBlockList(int farmerId) {
		List<Block> blocks = blockRepository.fetchBlockListByFarmerId(farmerId);
		for(Block b: blocks) {
			b.setPondList(b.getPondList().stream().filter(p->p.isActive()).collect(Collectors.toList()));
		}
		logger.info("Farmer :"+farmerId+" blockList : "+blocks);
		if(null != blocks) {
			return blocks;
		}
		return null;
	}

	@Override
	public boolean saveBlockList(Block block) {
		logger.info("Before save \n" + block);
		Block newBlock = blockRepository.save(block) ;
		logger.info("After save: "+newBlock);
		return newBlock != null;
		
	}

	

}
