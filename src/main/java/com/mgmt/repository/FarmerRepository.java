package com.mgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mgmt.model.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer>  {

	@Query("select f from Farmer f where f.mobileNumber = :mobile and f.password = :password")
	List<Farmer> findByMobileNumberAndPassword(String mobile,String password);
}
