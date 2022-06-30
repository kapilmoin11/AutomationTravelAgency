package com.cg.ata.been;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="ATA_TBL_RESERVATION")
public class ReservationBean<CredentialsBean> 
{
	@OneToOne(cascade = CascadeType.ALL)
  	@JoinColumn(name ="routeID")
    private RouteBean routeBean;
  
	private Date bookingDate;
	private Date journeyDate;
	
    @OneToOne(cascade = CascadeType.ALL)
  	@JoinColumn(name ="vehicleID")
	private VehicleBean vehicleBean;
    
    @OneToOne(cascade = CascadeType.ALL)
  	@JoinColumn(name ="driverID")
	private DriverBean driverBean;
    
	private String	bookingStatus;
	
	private Double totalFare ;
	private String boardingPoint ;
	private String dropPoint;
	public String getReservationID() {
		return getReservationID();
	}
	public void setReservationID(String reservationID) {
		this.boardingPoint = reservationID;
	}
	
	public RouteBean getRouteBean() {
		return routeBean;
	}
	public void setRouteBean(RouteBean routeBean) {
		this.routeBean = routeBean;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public VehicleBean getVehicleBean() {
		return vehicleBean;
	}
	public void setVehicleBean(VehicleBean vehicleBean) {
		this.vehicleBean = vehicleBean;
	}
	public DriverBean getDriverBean() {
		return driverBean;
	}
	public void setDriverBean(DriverBean driverBean) {
		this.driverBean = driverBean;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public Double getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}
	public String getBoardingPoint() {
		return boardingPoint;
	}
	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}
	public String getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}
	

}

