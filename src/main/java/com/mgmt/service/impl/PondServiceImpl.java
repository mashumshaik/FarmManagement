package com.mgmt.service.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgmt.model.Pond;
import com.mgmt.repository.PondRepository;
import com.mgmt.service.PondService;

@Service
public class PondServiceImpl implements PondService {

	private static final Logger logger = Logger.getLogger(PondServiceImpl.class.getName());
	@Autowired
	PondRepository pondRepository;
	@Override
	public boolean savePondList(List<Pond> pondList) {
		logger.info("Before save \n" + pondList);
		List<Pond> newList = pondRepository.saveAll(pondList) ;
		logger.info("After save: "+pondList);
		return newList != null;
	}
	@Override
	public List<Pond> getPondList(int farmerId) {
		List<Pond> ponds = pondRepository.fetchPondListByFarmerId(farmerId);
		logger.info("Farmer :"+farmerId+" PondList : "+ponds);
		if(null != ponds) {
			return ponds;
		}
		return null;
	}

}
