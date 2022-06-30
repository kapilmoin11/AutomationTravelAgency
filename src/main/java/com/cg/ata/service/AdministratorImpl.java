package com.cg.ata.service;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ata.been.DriverBean;
import com.cg.ata.been.ReservationBean;
import com.cg.ata.been.RouteBean;
import com.cg.ata.been.VehicleBean;
import com.cg.ata.dao.DriverDAO;
import com.cg.ata.dao.RouteDAO;
import com.cg.ata.dao.VehicleDAO;
@Service
@Transactional
public class AdministratorImpl implements Administrator
{
	@Autowired
	private  VehicleDAO vehicledao;
	@Autowired
	private DriverDAO driverdao;
	
	@Autowired
	private RouteDAO routedao;

	public VehicleDAO getVehicledao() {
		return vehicledao;
	}

	public void setVehicledao(VehicleDAO vehicledao) {
		this.vehicledao = vehicledao;
	}

	public DriverDAO getDriverdao() {
		return driverdao;
	}

	public void setDriverdao(DriverDAO driverdao) {
		this.driverdao = driverdao;
	}

	public RouteDAO getRoutedao() {
		return routedao;
	}

	public void setRoutedao(RouteDAO routedao) {
		this.routedao = routedao;
	}

	@Override
	public String addVehicle(VehicleBean vehicleBean) 
	{
		int generatedseqNum = vehicledao.generateVehicleId();
		String id = vehicleBean.getName().substring(0, 2)+generatedseqNum;
		vehicleBean.setVehicleID(id);
		String result=vehicledao.createVehicle(vehicleBean);
		return result;
	}

	@Override
	public int deleteVehicle(ArrayList<String> vehicleID) 
	{
		int num=vehicledao.deleteVehicle(vehicleID);
		return num;
	}

	@Override
	public ArrayList<VehicleBean> viewVehicle()
	{		
		//VehicleBean vehiclebean=vehicledao.findByID(vehicleID);
		ArrayList<VehicleBean> arr=vehicledao.findAll();
		return arr;
	}
	
	
	
	
	@Override
	public boolean modifyVehicle(VehicleBean vehicleBean)
	{
		boolean updateResult=vehicledao.updateVehicle(vehicleBean);
		return updateResult;
	}

	@Override
	public String addDriver(DriverBean driverBean) 
	{
		int generatedseqNum = driverdao.generateDriverId();
		String id = driverBean.getName().substring(0, 2)+generatedseqNum;
		driverBean.setDriverID(id);
		String str=driverdao.createDriver(driverBean);
		return str;
		
	}
	
	@Override
	public ArrayList<DriverBean> viewDriver()
	{		
		//VehicleBean vehiclebean=vehicledao.findByID(vehicleID);
		ArrayList<DriverBean> arr=driverdao.findAll();
		return arr;
	}
	
	
	@Override
	public int deleteDriver(ArrayList<String> driverID)
	{
		int deleteStatus=driverdao.deleteDriver(driverID);
		  return deleteStatus;
		
		
	}

	@Override
	public boolean allotDriver(String reservationID, String driverID) 
	{
		
		return false;
	}

	@Override
	public boolean modifyDriver(DriverBean driverBean) 
	{

		if(driverBean!=null)
		{
			if(driverdao.updateDriver(driverBean))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}

	@Override
	public String addRoute(RouteBean routeBean)
	{
		if(routeBean!=null)
		{
			int id=routedao.generateRouteId();
			String route_id=routeBean.getSource().substring(0, 2)+id;
			routeBean.setRouteID(route_id);
			return(routedao.createRoute(routeBean));
		}
		return "FAIL";
	}

	@Override
	public int deleteRoute(ArrayList<String> routeID)
	{
		if(routeID!=null)
		{
		return(routedao.deleteRoute(routeID));
		}
		return 0;
	}

	@Override
	public ArrayList<RouteBean> viewRoute() 
	{
		ArrayList<RouteBean> arr=routedao.findAll();
		return arr;
	}

	@Override
	public boolean modifyRoute(RouteBean routeBean)
	{

		if(routeBean!=null)
		{
			return (routedao.updateRoute(routeBean));
		}
		return false;
	}

	@Override
	public ArrayList<ReservationBean> viewBookingDetails(Date journeyDate, String source, String destination)
	{
		// TODO Auto-generated method stu
		return null;
	}
	

}

