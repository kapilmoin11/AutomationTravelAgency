package com.cg.ata.controller;

import java.util.ArrayList;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.cg.ata.been.DriverBean;

import com.cg.ata.been.ReservationBean;
import com.cg.ata.been.RouteBean;
import com.cg.ata.been.VehicleBean;
import com.cg.ata.service.Administrator;
import com.cg.ata.service.Customer;

@Controller
public class ATAController 
{
	@Autowired
	private Administrator admin;
	@Autowired
	private Customer customer;
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@RequestMapping("/add_vehicle")
	public ModelAndView goTOAddVehicle(@ModelAttribute("vehicledata") VehicleBean VehicleBean,HttpSession session)
	{
	
		if(session.getAttribute("Uid")==null)
			return new ModelAndView("logout");
			else
				return new ModelAndView("add_vehicle");
	}


  	@RequestMapping("/update_vehicle")
  	public ModelAndView update_vehicle(@ModelAttribute("upvehicle") VehicleBean VehicleBean,HttpSession session)
  	{
  		
  		boolean result = admin.modifyVehicle(VehicleBean);
  		/*if(admin.addVehicle(VehicleBean).contains("SUCCESS"))
  	  {
  		  return new ModelAndView("success");
  	  }*/
         if(result==false)
  	  	  return new ModelAndView("failure");
         else
        	 return new ModelAndView("success");
  	}
      
      @RequestMapping("/view_vehicle")
  	public ModelAndView goTOViewVehicle(@ModelAttribute("upvehicle") VehicleBean VehicleBean,HttpSession session)
  	{
    	  if(session.getAttribute("Uid")==null)
  			return new ModelAndView("logout");
    	 
    	  ArrayList<VehicleBean> arr=admin.viewVehicle();
    	  return new ModelAndView("view_vehicle","arr",arr);
  	}
      
      
      @RequestMapping("/viewusr_vehicle")
    	public ModelAndView goTOViewUsrVehicle(HttpSession session)
    	{
    	  if(session.getAttribute("Uid")==null)
    			return new ModelAndView("logout");
      	  ArrayList<VehicleBean> arr=admin.viewVehicle();
      	
    		return new ModelAndView("viewusr_vehicle","arr",arr);
    	}
      
      @RequestMapping("/delete_vehicle")
    	public ModelAndView goTODeleteVehicle(@ModelAttribute("upvehicle") VehicleBean VehicleBean,HttpServletRequest request,HttpServletResponse response)
    	{
    	  String s[]=request.getParameterValues("c1");
    	  ArrayList<String> arr=new ArrayList<String>();
    	  for(int counter=0;counter<s.length;counter++)
    	  {
    		  arr.add(s[counter]);
    	  }
    	  //deleting 
    	  admin.deleteVehicle(arr);
    	  ArrayList<VehicleBean> arr2=admin.viewVehicle();
    	  
      	  //view again
    		return new ModelAndView("view_vehicle","arr",arr2);
    	} 
      
      @RequestMapping("/view_route")
    	public ModelAndView goTOViewRoute(@ModelAttribute("uproute") RouteBean routeBean,HttpSession session)
    	{
    	  if(session.getAttribute("Uid")==null)
  			return new ModelAndView("logout");
      	  ArrayList<RouteBean> arr=admin.viewRoute();
      	
    		return new ModelAndView("view_route","arr",arr);
    	} 
     
      
      @RequestMapping("/delete_route")
  	public ModelAndView goTODeleteRoute(@ModelAttribute("uproute") RouteBean routeBean,HttpServletRequest request,HttpServletResponse response)
  	{
    	  String s[]=request.getParameterValues("c1");
    	 ArrayList<String> arr=new ArrayList<String>();
    	  for(int counter=0;counter<s.length;counter++)
    	 {
    		 arr.add(s[counter]);
    	 }
    	  admin.deleteRoute(arr);
    	  ArrayList<RouteBean> arr2=admin.viewRoute();
    	  
    	 	return new ModelAndView("view_route","arr",arr2);
  	}
      
      
      
      @RequestMapping("/add_route")
  	public ModelAndView goToAddRoute(@ModelAttribute("Routedata") RouteBean routeBean,HttpSession session)
  	{
    	  System.out.println(session.getAttribute("Uid"));
    	  if(session.getAttribute("Uid")==null)
  			return new ModelAndView("logout");
  			else
  				return new ModelAndView("add_route");
  	}


        @RequestMapping("/addRoute")
  	public ModelAndView AddRoute(@ModelAttribute("Routedata") RouteBean routeBean)
  	{
          if(admin.addRoute(routeBean).equals("SUCCESS"))
          {
        	  return new ModelAndView("success");
          }
      	  	return new ModelAndView("failure");
  		
      }
        
        
        @RequestMapping("/up_route")
    	public ModelAndView Update_route(@ModelAttribute("uproute") RouteBean routeBean,HttpSession session)
    	{
        	 if(admin.addRoute(routeBean).equals("SUCCESS"))
             {
           	  return new ModelAndView("success");
             }
         	  	return new ModelAndView("failure");
    	}  
      
     
        @RequestMapping("/add_driver")
    	public ModelAndView goToAddDriver(@ModelAttribute("driverdata") DriverBean driverBean,HttpSession session)
    	{
        	if(session.getAttribute("Uid")==null)
    			return new ModelAndView("logout");
    			else
    		return new ModelAndView("add_driver");
    	}


          @RequestMapping("/view_driver")
      	public ModelAndView goToViewDriver(@ModelAttribute("driverdata") DriverBean driverBean,HttpSession session)
      	{
        	  if(session.getAttribute("Uid")==null)
        			return new ModelAndView("logout");
          	 
          	  ArrayList<DriverBean> arr=admin.viewDriver();
          	  return new ModelAndView("view_drivers","arr",arr);
        	  
      	} 
          
          @RequestMapping("/book_vehicle")
        	public ModelAndView goToBookVehicle(@ModelAttribute("BookingData") ReservationBean ReservationBean,HttpSession session)
        	{
        	  if(session.getAttribute("Uid")==null)
      			return new ModelAndView("logout");
      			else
      				
      				return new ModelAndView("book_vehicle");
            }
          
          


}
