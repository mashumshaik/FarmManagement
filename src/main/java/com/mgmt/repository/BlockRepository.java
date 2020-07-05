package com.mgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mgmt.model.Block;

@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {
	
	@Query("select b from Block b where b.farmerId = :farmerId order by b.blockId")
	List<Block> fetchBlockListByFarmerId(@Param("farmerId")int farmerId);
	
}
