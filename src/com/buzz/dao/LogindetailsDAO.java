package com.buzz.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.buzz.dbfactory.BaseHibernateDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Logindetails;

/**
 * A data access object (DAO) providing persistence and search support for
 * Logindetails entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mapping.LogindetailsBean
 * @author MyEclipse Persistence Tools
 */

public class LogindetailsDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(LogindetailsDAO.class);
	// property constants
	public static final String LOGINID = "loginid";
	public static final String PASSWORD = "password";
	public static final String LOGINTYPE = "logintype";
	public static final String STATUS = "status";

	public void save(Logindetails transientInstance) throws ConnectionException {
		log.debug("saving Logindetails instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Logindetails persistentInstance)
			throws ConnectionException {
		log.debug("deleting Logindetails instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}finally {
			try {
				closeSession();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Logindetails findById(java.math.BigDecimal id)
			throws ConnectionException {
		log.debug("getting Logindetails instance with id: " + id);
		try {
			Logindetails instance = (Logindetails) getSession().get(
					"mapping.Logindetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Logindetails instance) throws ConnectionException {
		log.debug("finding Logindetails instance by example");
		try {
			List results = getSession().createCriteria("mapping.Logindetails")
					.add(Example.create(instance)).list();
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
		log.debug("finding Logindetails instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Logindetails as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLoginid(Object loginid) throws ConnectionException {
		return findByProperty(LOGINID, loginid);
	}

	public List findByPassword(Object password) throws ConnectionException {
		return findByProperty(PASSWORD, password);
	}

	public List findByLogintype(Object logintype) throws ConnectionException {
		return findByProperty(LOGINTYPE, logintype);
	}

	public List findByStatus(Object status) throws ConnectionException {
		return findByProperty(STATUS, status);
	}

	public List findAll() throws ConnectionException, CommonException {
		log.debug("finding all Logindetails instances");
		try {
			String queryString = "from Logindetails";
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

	public Logindetails merge(Logindetails detachedInstance)
			throws ConnectionException {
		log.debug("merging Logindetails instance");
		try {
			Logindetails result = (Logindetails) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Logindetails instance) throws ConnectionException {
		log.debug("attaching dirty Logindetails instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Logindetails instance) throws ConnectionException {
		log.debug("attaching clean Logindetails instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}