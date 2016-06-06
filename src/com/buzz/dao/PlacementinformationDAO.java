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
import com.buzz.pojo.Branch;
import com.buzz.pojo.Placementinformation;
import com.buzz.util.DateWrapper;

/**
 * A data access object (DAO) providing persistence and search support for
 * Placementinformation entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mapping.Placementinformation
 * @author MyEclipse Persistence Tools
 */

public class PlacementinformationDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(PlacementinformationDAO.class);
	// property constants
	public static final String PLACEMENTCOMPNAYNAME = "placementcompnayname";
	public static final String PLACEMENTDESCRIPTION = "placementdescription";
	public static final String PLACEMENTURL = "placementurl";
	Session session;
	Transaction transaction;

	public void save(Placementinformation transientInstance)
			throws CommonException {
		log.debug("saving Placementinformation instance");
		try {

transientInstance.setPlacementdate(new Date(DateWrapper.parseDate(transientInstance.getPlacementdate())));
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
			System.out.println("asdfas" + re);
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		} finally {
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

	public void delete(Placementinformation persistentInstance)
			throws CommonException {
		log.debug("deleting Placementinformation instance");
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

	public Placementinformation findById(int id) throws CommonException {
		log.debug("getting Placementinformation instance with id: " + id);
		try {
			Placementinformation instance = (Placementinformation) getSession()
					.get("com.buzz.pojo.Placementinformation", id);
			return instance;
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

	public List findByExample(Placementinformation instance)
			throws CommonException {
		log.debug("finding Placementinformation instance by example");
		try {
			List results = getSession().createCriteria(
					"mapping.Placementinformation").add(
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
		log.debug("finding Placementinformation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Placementinformation as model where model."
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

	public List findByPlacementcompnayname(Object placementcompnayname)
			throws CommonException {
		return findByProperty(PLACEMENTCOMPNAYNAME, placementcompnayname);
	}

	public List findByPlacementdescription(Object placementdescription)
			throws CommonException {
		return findByProperty(PLACEMENTDESCRIPTION, placementdescription);
	}

	public List findByPlacementurl(Object placementurl) throws CommonException {
		return findByProperty(PLACEMENTURL, placementurl);
	}

	public List findAll() throws ConnectionException {
		log.debug("finding all Placementinformation instances");
		try {
			String queryString = "from Placementinformation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Placementinformation merge(Placementinformation detachedInstance)
			throws CommonException {
		log.debug("merging Placementinformation instance");
		try {
			Placementinformation result = (Placementinformation) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
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

	public boolean attachDirty(Placementinformation placementinformation)
			throws CommonException {
		log.debug("attaching dirty Placementinformation instance");
		try {
			Session session = getSession();
			Placementinformation instance = (Placementinformation) session.get("com.buzz.pojo.Placementinformation", placementinformation
							.getPlacementinfoid());
			Transaction transaction = session.beginTransaction();
			instance.setPlacementcompnayname(placementinformation
					.getPlacementcompnayname());
			instance.setPlacementdescription(placementinformation
					.getPlacementdescription());
			instance.setPlacementdate(placementinformation.getPlacementdate());
			instance.setPlacementurl(placementinformation.getPlacementurl());
			session.update(instance);
			transaction.commit();
			log.debug("attach successful");
			return true;
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

	public void attachClean(Placementinformation instance)
			throws CommonException {
		log.debug("attaching clean Placementinformation instance");
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