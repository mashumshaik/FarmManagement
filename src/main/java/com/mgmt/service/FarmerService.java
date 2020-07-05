package com.mgmt.service;

import com.mgmt.model.Farmer;

public interface FarmerService {

	Farmer getFarmer(int farmerId);

	int saveFarmer(Farmer farmer);
	
	boolean getByMobileNumberAndPassword(String mobile,String password);
}
