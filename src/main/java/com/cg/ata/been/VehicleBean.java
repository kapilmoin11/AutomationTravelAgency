package com.cg.ata.been;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ATA_TBL_VEHICLE")
public class VehicleBean 
{  
	@Id
	private String vehicleID;
	@Column
	private String name;
	@Column
	private String type;
	@Column
	private String registrationNumber;
	@Column
	private int seatingCapacity;
	@Column
	private double farePerKM ;
	
	
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public double getFarePerKM() {
		return farePerKM;
	}
	public void setFarePerKM(double farePerKM) {
		this.farePerKM = farePerKM;
	}

}

