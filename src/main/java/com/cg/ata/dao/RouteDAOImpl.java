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
import com.cg.ata.been.RouteBean;
import com.cg.ata.been.VehicleBean;

@Repository
@Transactional
public class RouteDAOImpl implements RouteDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	// ========================implemented methods=================================
	@Override
	public String createRoute(RouteBean routeBean) 
	{
		if(routeBean!=null)
		{
			try
			{
				
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.save(routeBean);
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
	public int deleteRoute(ArrayList<String> RouteList) 
	{
		if(RouteList!=null)
		{
			Iterator<String> itr=RouteList.iterator();
			while(itr.hasNext())
			{
				try{
					String id=itr.next();
					Session session=sessionFactory.openSession();
					Transaction tx=session.beginTransaction();
					Query query=session.createQuery("delete from RouteBean where routeID=:rid");
					query.setParameter("rid",id);
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
	public boolean updateRoute(RouteBean routeBean) 
	{
		if(routeBean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.saveOrUpdate(routeBean);
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
	public RouteBean findByID(String id)
	{
		if(id!=null)
		{
			Session session=sessionFactory.openSession();
			RouteBean record=(RouteBean) session.get(RouteBean.class,id);
			return record;
			
			
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public ArrayList<RouteBean> findAll() 
	{
		try{
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query q=session.createQuery("from RouteBean");
		ArrayList<RouteBean> list=(ArrayList<RouteBean>) q.list();
		return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int generateRouteId() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		SQLQuery q=session.createSQLQuery("select ata_seq_routeId.nextval from dual");
		return (Integer.parseInt(q.uniqueResult().toString()));
	}
	

}

