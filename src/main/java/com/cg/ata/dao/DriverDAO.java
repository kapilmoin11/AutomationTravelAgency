package com.cg.ata.dao;

import java.util.ArrayList;

import com.cg.ata.been.DriverBean;



public interface DriverDAO 
{
	String createDriver(DriverBean driverbean);
	int deleteDriver(ArrayList<String> DriverList) ;
	boolean updateDriver(DriverBean driverbean) ;
	DriverBean findByID(String id) ;
	ArrayList<DriverBean> findAll();
	int generateDriverId();
	boolean setdriverstatus(DriverBean driverBean, String driverid);
}

