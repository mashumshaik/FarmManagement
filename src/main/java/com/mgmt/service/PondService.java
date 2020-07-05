package com.mgmt.service;

import java.util.List;

import com.mgmt.model.Pond;

public interface PondService {

	boolean savePondList(List<Pond> pondList);

	List<Pond> getPondList(int farmerId);

}
