package com.cg.ata.been;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ATA_TBL_ROUTE")
public class RouteBean 
{
	@Id
	private String routeID;
	@Column
	private String source;
	@Column
	private String destination;
	@Column
	private int distance;
	@Column
	private int travelDuration;
	
	
	public String getRouteID() {
		return routeID;
	}
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getTravelDuration() {
		return travelDuration;
	}
	public void setTravelDuration(int travelDuration) {
		this.travelDuration = travelDuration;
	}
   

}

