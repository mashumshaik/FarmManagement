package com.mgmt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Farmer {

	@Column
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int farmerId;
	
	@Column(nullable = false)
	private String farmerName;
	
	@Column(nullable = false)
	private String farmName;
	
	@Column(nullable = false)
	private boolean corporate;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address address;
	
	@Column(unique = true, nullable = false)
	private String mobileNumber;
	
	@Column(nullable = false)
	private String password;

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	

	public boolean isCorporate() {
		return corporate;
	}

	public void setCorporate(boolean corporate) {
		this.corporate = corporate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFarmerId() {
		return farmerId;
	}

	
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}

	@Override
	public String toString() {
		return "Farmer [farmerId=" + farmerId + ", farmerName=" + farmerName + ", farmName=" + farmName
				+ ", isCorporate=" + corporate + ", address=" + address + ", mobileNumber=" + mobileNumber
				+ ", password=" + password + "]";
	}

	
}
