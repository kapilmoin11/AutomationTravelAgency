package com.cg.ata.service;

import java.util.ArrayList;

import com.cg.ata.been.ReservationBean;
import com.cg.ata.been.RouteBean;
import com.cg.ata.been.VehicleBean;

public interface Customer 
{
	ArrayList<VehicleBean> viewVehiclesByType(String vehicleType);
	ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats);
	ArrayList<RouteBean> viewAllRoutes();
	String bookVehicle(ReservationBean reservationBean);
	boolean cancelBooking(String userID, String reservationID);
	ReservationBean viewBookingDetails(String reservationID);
	ReservationBean printBookingDetails(String reservationID);
	boolean checkBalance(float balance);
	void payMoney(String creditCardNumber, Double totalFare);

}

