package com.buzz.dbfactory;

import com.buzz.dbfactory.HibernateSessionFactory;
import com.buzz.exception.ConnectionException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Data access object (DAO) for domain model
 * 
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {

	public Session getSession() throws HibernateException, ConnectionException {
		return HibernateSessionFactory.getSession();
	}

	public void closeSession() throws HibernateException, ConnectionException {
		HibernateSessionFactory.closeSession();
	}
}