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
import com.buzz.pojo.Topicheader;
import com.buzz.pojo.Topicname;

/**
 * A data access object (DAO) providing persistence and search support for
 * Topicname entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mapping.Topicname
 * @author MyEclipse Persistence Tools
 */

public class TopicnameDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TopicnameDAO.class);
	// property constants
	public static final String TOPICNAME = "topicname";
	Session session;
	Transaction transaction;

	public void save(Topicname transientInstance) throws CommonException {
		log.debug("saving Topicname instance");
		try {
			session = getSession();
			Transaction transaction = session.beginTransaction();
			transientInstance.setTopicheader(new Topicheader(transientInstance
					.getTopicheader().getTopicheaderid()));
			transientInstance.setTopicdate(new Date());
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
		}
		finally{
			session.close();
		}
	}

	public void delete(Topicname persistentInstance) throws CommonException {
		log.debug("deleting Topicname instance");
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

	public Topicname findById(int id) throws CommonException {
		log.debug("getting Topicname instance with id: " + id);
		try {
			Topicname instance = (Topicname) getSession().get(
					"mapping.Topicname", id);
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

	public List findByExample(Topicname instance) throws CommonException {
		log.debug("finding Topicname instance by example");
		try {
			List results = getSession().createCriteria("mapping.Topicname")
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
		log.debug("finding Topicname instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Topicname as model where model."
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

	public List findByTopicname(Object topicname) throws CommonException {
		return findByProperty(TOPICNAME, topicname);
	}

	public List findAll() throws CommonException {
		log.debug("finding all Topicname instances");
		try {
			String queryString = "from Topicname";
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

	public List findAll(int topicheaderid) throws CommonException {
		log.debug("finding all Topicname instances");
		try {
			String queryString = "from Topicname as model where model.topicheader.topicheaderid= ?";
		Query queryObject = getSession().createQuery(queryString);
		queryObject.setParameter(0, topicheaderid);
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
	
	public Topicname merge(Topicname detachedInstance) throws CommonException {
		log.debug("merging Topicname instance");
		try {
			Topicname result = (Topicname) getSession().merge(detachedInstance);
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

	public boolean attachDirty(Topicname instance) throws CommonException {
		log.debug("attaching dirty Topicname instance");
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

	public void attachClean(Topicname instance) throws CommonException {
		log.debug("attaching clean Topicname instance");
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