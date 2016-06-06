package com.buzz.dbfactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.buzz.exception.ConnectionException;


/**
 * Data access interface for domain model
 * @author MyEclipse Persistence Tools
 */
public interface IBaseHibernateDAO {
	public Session getSession() throws HibernateException, ConnectionException;
}