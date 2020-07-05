package com.mgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Block {
	
	@Column
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int blockId;
	
	//unique at farmer level
	@Column(nullable = false)
	private String blockName;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "BLOCK_POND", 
				joinColumns = { @JoinColumn(name = "BLOCK_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "POND_ID") })
	List<Pond> pondList = new ArrayList<Pond>();
	
	@Column
	private int farmerId;
	
	

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	


	public int getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	public List<Pond> getPondList() {
		return pondList;
	}

	public void setPondList(List<Pond> pondList) {
		this.pondList = pondList;
	}

	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	
	@Override
	public String toString() {
		return "Block [blockId=" + blockId + ", blockName=" + blockName + ", pondList=" + pondList + ", farmerId="
				+ farmerId + "]";
	}

	
}
