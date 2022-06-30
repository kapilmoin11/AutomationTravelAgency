package com.cg.ata.dao;

import java.util.ArrayList;

import com.cg.ata.been.RouteBean;


public interface RouteDAO 
{
	String createRoute( RouteBean routeBean);
	int deleteRoute(ArrayList<String> RouteList) ;
	boolean updateRoute(RouteBean routeBean) ;
	RouteBean findByID(String id) ;
	ArrayList<RouteBean> findAll();
	int generateRouteId();


}
