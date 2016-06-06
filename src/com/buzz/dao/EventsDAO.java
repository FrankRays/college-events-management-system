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
import com.buzz.pojo.Events;
import com.buzz.util.DateWrapper;

/**
 * A data access object (DAO) providing persistence and search support for
 * Events entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mapping.Events
 * @author MyEclipse Persistence Tools
 */

public class EventsDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(EventsDAO.class);
	// property constants
	public static final String EVENTNAME = "eventname";
	public static final String EVENTDESC = "eventdesc";
	public static final String EVENTONCOLLEGE = "eventoncollege";
	public static final String EVENTONADDRESS = "eventonaddress";
	public static final String EVENTTIME = "eventtime";
	public static final String URL = "url";
	Session session;
	Transaction transaction;

	public void save(Events transientInstance) throws CommonException {
		log.debug("saving Events instance");
		try {

			session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(transientInstance);
			transaction.commit();
			log.debug("save successful");
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} finally {
			try {
				closeSession();
			} catch (Exception e) {

				System.out.println(e);
			}
		}
	}

	public void delete(Events persistentInstance) throws CommonException {
		log.debug("deleting Events instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		}
	}

	public Events findById(int id) throws CommonException {
		log.debug("getting Events instance with id: " + id);
		try {
			Events instance = (Events) getSession().get("com.buzz.pojo.Events", id);
			return instance;
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			log.error("save failed", re);
			throw new CommonException("No Data");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("No Data");
		}
	}

	public List findByExample(Events instance) throws CommonException {
		log.debug("finding Events instance by example");
		try {
			List results = getSession().createCriteria("mapping.Events").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		}
	}

	public List findByProperty(String propertyName, Object value)
			throws CommonException {
		log.debug("finding Events instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Events as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		}
	}

	public List findByEventname(Object eventname) throws CommonException {
		return findByProperty(EVENTNAME, eventname);
	}

	public List findByEventdesc(Object eventdesc) throws CommonException {
		return findByProperty(EVENTDESC, eventdesc);
	}

	public List findByEventoncollege(Object eventoncollege)
			throws CommonException {
		return findByProperty(EVENTONCOLLEGE, eventoncollege);
	}

	public List findByEventonaddress(Object eventonaddress)
			throws CommonException {
		return findByProperty(EVENTONADDRESS, eventonaddress);
	}

	public List findByEventtime(Object eventtime) throws CommonException {
		return findByProperty(EVENTTIME, eventtime);
	}

	public List findByUrl(Object url) throws CommonException {
		return findByProperty(URL, url);
	}

	public List findAll() throws CommonException {
		log.debug("finding all Events instances");
		try {
			String queryString = "from Events";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		}
	}

	public Events merge(Events detachedInstance) throws ConnectionException {
		log.debug("merging Events instance");
		try {
			Events result = (Events) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(Events instance) throws CommonException {
		log.debug("attaching dirty Events instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		}
		return true;
	}

	public void attachClean(Events instance) throws CommonException {
		log.debug("attaching clean Events instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		}
	}
}