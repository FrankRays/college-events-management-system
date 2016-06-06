package com.buzz.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
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
import com.buzz.pojo.Studydetails;

/**
 * A data access object (DAO) providing persistence and search support for
 * Studydetails entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mapping.Studydetails
 * @author MyEclipse Persistence Tools
 */

public class StudydetailsDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(StudydetailsDAO.class);
	// property constants
	public static final String STUDYNAME = "studyname";
	public static final String STUDYDESC = "studydesc";
	Session session;

	public void save(Studydetails transientInstance) throws CommonException {
		log.debug("saving Studydetails instance");
		try {
			session = getSession();
			Transaction transaction = session.beginTransaction();
			transientInstance.setStudydate(new Date());
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
		}finally{
			session.close();
		}
	}

	public void delete(Studydetails persistentInstance) throws CommonException {
		log.debug("deleting Studydetails instance");
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

	public Studydetails findById(int id) throws CommonException {
		log.debug("getting Studydetails instance with id: " + id);
		try {
			Studydetails instance = (Studydetails) getSession().get(
					"com.buzz.pojo.Studydetails", id);
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

	public List findByExample(Studydetails instance) throws CommonException {
		log.debug("finding Studydetails instance by example");
		try {
			List results = getSession().createCriteria("mapping.Studydetails")
					.add(Example.create(instance)).list();
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
		log.debug("finding Studydetails instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Studydetails as model where model."
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

	public List findByStudyname(Object studyname) throws CommonException {
		return findByProperty(STUDYNAME, studyname);
	}

	public List findByStudydesc(Object studydesc) throws CommonException {
		return findByProperty(STUDYDESC, studydesc);
	}

	public List findAll() throws CommonException {
		log.debug("finding all Studydetails instances");
		try {
			String queryString = "from Studydetails";
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

	public Studydetails merge(Studydetails detachedInstance)
			throws CommonException {
		log.debug("merging Studydetails instance");
		try {
			Studydetails result = (Studydetails) getSession().merge(
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

	public boolean attachDirty(Studydetails studydetails) throws CommonException {
		log.debug("attaching dirty Studydetails instance");
		try {
			Session session = getSession();
			System.out.println(studydetails.getStudyid());
			Studydetails instance = (Studydetails) session.get("com.buzz.pojo.Studydetails",
					studydetails.getStudyid());
			Transaction transaction = session.beginTransaction();
			System.out.println(studydetails.getStudyname());
			instance.setStudyname(studydetails.getStudyname());
			instance.setStudydesc(studydetails.getStudydesc());
			session.update(instance);
			transaction.commit();
			log.debug("attach successful");
			return true;
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
		}
	}

	public void attachClean(Studydetails instance) throws CommonException {
		log.debug("attaching clean Studydetails instance");
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