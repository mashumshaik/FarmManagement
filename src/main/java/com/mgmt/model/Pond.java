package com.mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pond {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pondId;

	@Column
	private String pondName;

	@Column
	private double pondSize;
	
	@Column
	private boolean active ;

	
	@Column
	private int farmerId;
	
	
	
	
	public String getPondName() {
		return pondName;
	}

	public void setPondName(String pondName) {
		this.pondName = pondName;
	}

	public double getPondSize() {
		return pondSize;
	}

	public void setPondSize(double pondSize) {
		this.pondSize = pondSize;
	}



	public int getPondId() {
		return pondId;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	public void setPondId(int pondId) {
		this.pondId = pondId;
	}

	@Override
	public String toString() {
		return "Pond [pondId=" + pondId + ", pondName=" + pondName + ", pondSize=" + pondSize + ", active=" + active
				+ ", farmerId=" + farmerId + "]";
	}

}
