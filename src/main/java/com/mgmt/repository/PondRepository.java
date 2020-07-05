package com.mgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mgmt.model.Pond;

@Repository
public interface PondRepository extends JpaRepository<Pond, Integer> {

	@Query("select p from Pond p where p.farmerId = :farmerId and p.active = true order by p.pondId")
	List<Pond> fetchPondListByFarmerId(@Param("farmerId") int farmerId);
	
}
