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
import com.buzz.pojo.Coachingcenter;
import com.buzz.pojo.Studydetails;

/**
 * A data access object (DAO) providing persistence and search support for
 * Coachingcenter entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mapping.Coachingcenter
 * @author MyEclipse Persistence Tools
 */

public class CoachingcenterDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(CoachingcenterDAO.class);
	// property constants
	public static final String COACHINGCENTERNAME = "coachingcentername";
	public static final String COACHINGADDRESSES = "coachingaddresses";
	public static final String COACHINGCONTACT = "coachingcontact";
	public static final String COACHINGDESC = "coachingdesc";
	Session session;
	Transaction transaction;

	public void save(Coachingcenter transientInstance) throws CommonException {
		log.debug("saving Coachingcenter instance");
		try {
			session = getSession();
			Transaction transaction = session.beginTransaction();
			System.out.println(transientInstance.getStudydetails().getStudyid());
			transientInstance.setStudydetails(new Studydetails(transientInstance.getStudydetails().getStudyid()));
			transientInstance.setCoachingadddate(new Date());
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
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delete(Coachingcenter persistentInstance)
			throws CommonException {
		log.debug("deleting Coachingcenter instance");
		try {
			session = getSession();
			session.delete(persistentInstance);
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

	public Coachingcenter findById(int id) throws CommonException {
		log.debug("getting Coachingcenter instance with id: " + id);
		try {
			Coachingcenter instance = (Coachingcenter) getSession().get(
					"mapping.Coachingcenter", id);
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

	public List findByExample(Coachingcenter instance) throws CommonException {
		log.debug("finding Coachingcenter instance by example");
		try {
			List results = getSession().createCriteria(
					"com.buzz.pojo.Coachingcenter").add(
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
		log.debug("finding Coachingcenter instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Coachingcenter as model where model."
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

	public List findByCoachingcentername(Object coachingcentername)
			throws CommonException {
		return findByProperty(COACHINGCENTERNAME, coachingcentername);
	}

	public List findByCoachingaddresses(Object coachingaddresses)
			throws CommonException {
		return findByProperty(COACHINGADDRESSES, coachingaddresses);
	}

	public List findByCoachingcontact(Object coachingcontact)
			throws CommonException {
		return findByProperty(COACHINGCONTACT, coachingcontact);
	}

	public List findByCoachingdesc(Object coachingdesc) throws CommonException {
		return findByProperty(COACHINGDESC, coachingdesc);
	}

	public List findAll() throws CommonException {
		log.debug("finding all Coachingcenter instances");
		try {
			// String queryString =
			// "select coachingcenterid,coachingcentername,coachingaddresses,coachingcontact,coachingdesc,coachingadddate,studydetails from Coachingcenter";
			String queryString = "from Coachingcenter";
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
			System.out.println(re);
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		}
	}

	public Coachingcenter merge(Coachingcenter detachedInstance)
			throws CommonException {
		log.debug("merging Coachingcenter instance");
		try {
			Coachingcenter result = (Coachingcenter) getSession().merge(
					detachedInstance);
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

	public boolean attachDirty(Coachingcenter instance) throws CommonException {
		log.debug("attaching dirty Coachingcenter instance");
		try {
			getSession().saveOrUpdate(instance);
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

	public void attachClean(Coachingcenter instance) throws CommonException {
		log.debug("attaching clean Coachingcenter instance");
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