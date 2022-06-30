package com.cg.ata.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cg.ata.been.VehicleBean;

@Repository
@Transactional
public class VehicleDAOImpl implements VehicleDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	//===============implementing methods==========================
	@Override
	public String createVehicle(VehicleBean vehicleBean) 
	{
		if(vehicleBean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.save(vehicleBean);
				tx.commit();
				session.close();
		
		
				return "SUCCESS";
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return "FAIL";
			}
		}
		else
		{
			return "FAIL";
		}
		
	
	}

	@Override
	public int deleteVehicle(ArrayList<String> VehicleList)
	{
		if(VehicleList!=null)
		{
			Iterator<String> itr=VehicleList.iterator();
			while(itr.hasNext())
			{
				try{
					String id=itr.next();
					Session session=sessionFactory.openSession();
					Transaction tx=session.beginTransaction();
					Query query=session.createQuery("delete from VehicleBean where vehicleID=:vid");
					query.setParameter("vid",id);
					query.executeUpdate();
					tx.commit();
					session.close();

				}
				catch(Exception e)
				{
					e.printStackTrace();
					return 0;
				}
			}
			return 1;
		}
		else
		{
			return 0;
		}
	}

	@Override
	public boolean updateVehicle(VehicleBean VehicleBean)
	{

		if(VehicleBean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.saveOrUpdate(VehicleBean);
				tx.commit();
				session.close();
				return true;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		}
		else
		{
			return false;	
		}
	}

	@Override
	public VehicleBean findByID(String id) 
	{
		if(id!=null)
		{
			Session session=sessionFactory.openSession();
			VehicleBean record=(VehicleBean) session.get(VehicleBean.class,id);
			return record;
			
			
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public ArrayList<VehicleBean> findAll() 
	{
		try{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from VehicleBean");
		ArrayList<VehicleBean> list=(ArrayList<VehicleBean>) q.list();
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<VehicleBean> findAll(int noOfSeats) 
	{
		try{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from VehicleBean where seatingCapacity>:num");
		q.setParameter("num", noOfSeats);
		ArrayList<VehicleBean> list=(ArrayList<VehicleBean>) q.list();
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<VehicleBean> findAll(String bustype) 
	{
		try{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from VehicleBean where type=:btype");
		q.setParameter("btype", bustype);
		ArrayList<VehicleBean> list=(ArrayList<VehicleBean>) q.list();
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int generateVehicleId()
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		SQLQuery q=session.createSQLQuery("select ata_seq_vehicleId.nextval from dual");
		return (Integer.parseInt(q.uniqueResult().toString()));
		
		
	}

	public int getTotalSeats(String vehicleid)
	{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		if(vehicleid!=null)
		{
			Query query=session.createQuery("select r.seatingCapacity from VehicleBean r where r.vehicleID=:vehicleid");
			query.setString("vehicleid",vehicleid);
			Iterator it=query.iterate();
			while(it.hasNext())
			{
				return (int) it.next();
			}
		}
		return 0;

	}
		
	
	

}
		
	
	