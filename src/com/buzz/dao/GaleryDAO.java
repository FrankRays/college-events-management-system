package com.buzz.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.buzz.dbfactory.BaseHibernateDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Galery;

/**
 * A data access object (DAO) providing persistence and search support for
 * Galery entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mapping.GaleryBean
 * @author MyEclipse Persistence Tools
 */

public class GaleryDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(GaleryDAO.class);
	// property constants
	public static final String GALERYFILE = "galeryfile";
	public static final String FALERYFILEEXTENSION = "faleryfileextension";
	Session session;
	Transaction transaction;

	public void save(Galery transientInstance) throws CommonException, HibernateException, ConnectionException {
		log.debug("saving Galery instance");
		try {
			session = getSession();
			Transaction transaction = session.beginTransaction();
			Blob blob = Hibernate
					.createBlob(transientInstance.getGaleryfile1());
			transientInstance.setGaleryfile(blob);
			transientInstance.setGalerydate(new Date());
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
			System.out.println(re);
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} finally {
			closeSession();
		}
	}

	public void delete(Galery persistentInstance) throws CommonException {
		log.debug("deleting Galery instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Deleted");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Deleted");
		}
	}

	public Galery findById(int id) throws CommonException {
		log.debug("getting Galery instance with id: " + id);
		try {
			Galery instance = (Galery) getSession().get("com.cems.pojo.Galery",
					id);
			return instance;
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Deleted");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Deleted");
		}
	}

	public List findByExample(Galery instance) throws ConnectionException {
		log.debug("finding Galery instance by example");
		try {
			List results = getSession().createCriteria("mapping.Galery").add(
					Example.create(instance)).list();
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
		log.debug("finding Galery instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Galery as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGaleryfile(Object galeryfile) throws ConnectionException {
		return findByProperty(GALERYFILE, galeryfile);
	}

	public List findByFaleryfileextension(Object faleryfileextension)
			throws ConnectionException {
		return findByProperty(FALERYFILEEXTENSION, faleryfileextension);
	}

	public List findAll() throws CommonException {
		log.debug("finding all Galery instances");
		try {
			String queryString = "from Galery";
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

	public Galery merge(Galery detachedInstance) throws ConnectionException {
		log.debug("merging Galery instance");
		try {
			Galery result = (Galery) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachClean(Galery instance) throws ConnectionException {
		log.debug("attaching clean Galery instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}