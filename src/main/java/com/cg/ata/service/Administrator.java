package com.cg.ata.service;

import java.util.ArrayList;
import java.util.Date;

import com.cg.ata.been.DriverBean;
import com.cg.ata.been.ReservationBean;
import com.cg.ata.been.RouteBean;
import com.cg.ata.been.VehicleBean;

public interface Administrator 
{
	String addVehicle(VehicleBean vehicleBean);
	int deleteVehicle(ArrayList<String> vehicleID);
	ArrayList<VehicleBean> viewVehicle();
	boolean modifyVehicle(VehicleBean vehicleBean);
	String addDriver(DriverBean driverBean);
	int deleteDriver(ArrayList<String> driverID);
	boolean allotDriver(String reservationID, String driverID);
	boolean modifyDriver(DriverBean driverBean);
	String addRoute(RouteBean routeBean);
	int deleteRoute(ArrayList<String> routeID) ;
	ArrayList<RouteBean> viewRoute();
	boolean modifyRoute(RouteBean routeBean);
	ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination);
	ArrayList<DriverBean> viewDriver();

}

