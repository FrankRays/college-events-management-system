package com.buzz.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.buzz.dbfactory.BaseHibernateDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Discussionforum;
import com.buzz.pojo.Events;
import com.buzz.pojo.Logindetails;

/**
 * A data access object (DAO) providing persistence and search support for
 * Discussionforum entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mapping.DiscussionforumBean
 * @author MyEclipse Persistence Tools
 */

public class DiscussionforumDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(DiscussionforumDAO.class);
	// property constants
	public static final String EVENTDESC = "eventdesc";
	Session session;
	Transaction transaction;

	public void save(Discussionforum transientInstance)
			throws ConnectionException, CommonException {
		log.debug("saving Discussionforum instance");
		try {
			session = getSession();
			Transaction transaction = session.beginTransaction();
			System.out.println(transientInstance.getEvents().getEventid());
			transientInstance.setPosteddate(new Date());
			transientInstance.setLogindetails(new Logindetails(
					transientInstance.getLogindetails().getUserid()));
			// transientInstance.setEvents(new
			// Events(transientInstance.getEvents().getEventid()));
			session.save(transientInstance);
			transaction.commit();
			log.debug("save successful");
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} catch (Exception re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		}
	}

	public void delete(Discussionforum persistentInstance)
			throws ConnectionException {
		log.debug("deleting Discussionforum instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Discussionforum findById(int id) throws ConnectionException {
		log.debug("getting Discussionforum instance with id: " + id);
		try {
			Discussionforum instance = (Discussionforum) getSession().get(
					"mapping.Discussionforum", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Discussionforum instance)
			throws ConnectionException {
		log.debug("finding Discussionforum instance by example");
		try {
			List results = getSession().createCriteria(
					"mapping.Discussionforum").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws ConnectionException {
		log.debug("finding Discussionforum instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Discussionforum as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEventdesc(Object eventdesc) throws ConnectionException {
		return findByProperty(EVENTDESC, eventdesc);
	}

	public List findAll() throws ConnectionException {
		log.debug("finding all Discussionforum instances");
		try {
			String queryString = "from Discussionforum";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Discussionforum merge(Discussionforum detachedInstance)
			throws ConnectionException {
		log.debug("merging Discussionforum instance");
		try {
			Discussionforum result = (Discussionforum) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Discussionforum instance)
			throws ConnectionException {
		log.debug("attaching dirty Discussionforum instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Discussionforum instance)
			throws ConnectionException {
		log.debug("attaching clean Discussionforum instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}