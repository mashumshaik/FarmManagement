package com.mgmt.service.impl;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mgmt.model.Farmer;
import com.mgmt.repository.FarmerRepository;
import com.mgmt.service.FarmerService;

@Service
public class FarmerServiceImpl implements FarmerService {

	private static final Logger logger = Logger.getLogger(FarmerServiceImpl.class.getName());
	@Autowired
	FarmerRepository farmerRepository;
	
	@Override
	public Farmer getFarmer(int farmerId) {
		Farmer farmer = farmerRepository.findById(farmerId).orElse(null);
			if(farmer != null)
				return farmer;
			return null;
	
	}

	@Override
	public int saveFarmer(Farmer farmer) {
		Farmer farmer2 = null;
		try {
			farmer2 = farmerRepository.save(farmer);
		}catch(DataIntegrityViolationException e) {
			return -1;
		}
		if( farmer2 != null) {
			return farmer2.getFarmerId();
		}
		return 0;
	}

	@Override
	public boolean getByMobileNumberAndPassword(String mobile,String password) {
		logger.info("mobileNumber :"+mobile+" password : "+password);
		List<Farmer> farmers =  farmerRepository.findByMobileNumberAndPassword(mobile,password);
		logger.info("farmers :"+farmers);
		return farmers.size() != 0;
	}
	
	

}
