package com.cg.ata.dao;

import java.util.ArrayList;
import java.util.Iterator;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.cg.ata.been.DriverBean;


@Repository
@Transactional
public abstract class DriverDAOImpl implements DriverDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String createDriver(DriverBean driverbean) 
	{
		if(driverbean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.save(driverbean);
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
	public int deleteDriver(ArrayList<String> DriverList) 
	{
		if(DriverList!=null)
		{
			Iterator<String> i=DriverList.iterator();
			while(i.hasNext())
			{
				try{
					String id=i.next();
					Session session=sessionFactory.openSession();
					Transaction tx=session.beginTransaction();
					Query q=session.createQuery("delete from DriverBean where driverID=:a");
					q.setParameter("a",id);
					q.executeUpdate();
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
	public boolean updateDriver(DriverBean driverbean) 
	{
		if(driverbean!=null)
		{
			try
			{
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.saveOrUpdate(driverbean);
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
	public  boolean setdriverstatus(DriverBean bean,String driverid) 
	{
		bean.setStatus("Unavailable");
		
				return updateDriver(bean);
		 
	}
}

