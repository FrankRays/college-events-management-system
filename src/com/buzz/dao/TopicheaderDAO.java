package com.buzz.dao;

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
import com.buzz.pojo.Topicheader;

/**
 * A data access object (DAO) providing persistence and search support for
 * Topicheader entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mapping.Topicheader
 * @author MyEclipse Persistence Tools
 */

public class TopicheaderDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TopicheaderDAO.class);
	// property constants
	public static final String TOPICNAME = "topicname";
	public static final String TOPICIMAGE = "topicimage";
	Session session;
	Transaction transaction;

	public void save(Topicheader transientInstance) throws ConnectionException,
			CommonException {
		log.debug("saving Topicheader instance");
		try {
			session = getSession();
			Transaction transaction = session.beginTransaction();
				Blob blob = Hibernate
					.createBlob(transientInstance.getTopicimage1());
			transientInstance.setTopicimage(blob);
			
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
			System.out.println(re);
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
		}finally{
			session.close();
		}
	}

	public void delete(Topicheader persistentInstance) throws CommonException {
		log.debug("deleting Topicheader instance");
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

	public Topicheader findById(int id) throws CommonException {
		log.debug("getting Topicheader instance with id: " + id);
		try {
			Topicheader instance = (Topicheader) getSession().get(
					"mapping.Topicheader", id);
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

	public List findByExample(Topicheader instance) throws CommonException {
		log.debug("finding Topicheader instance by example");
		try {
			List results = getSession().createCriteria("mapping.Topicheader")
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
		log.debug("finding Topicheader instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Topicheader as model where model."
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

	public List findByTopicimage(Object topicimage) throws CommonException {
		return findByProperty(TOPICIMAGE, topicimage);
	}

	public List findAll() throws CommonException {
		log.debug("finding all Topicheader instances");
		try {
			String queryString = "from Topicheader";
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

	public Topicheader merge(Topicheader detachedInstance)
			throws CommonException {
		log.debug("merging Topicheader instance");
		try {
			Topicheader result = (Topicheader) getSession().merge(
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

	public boolean attachDirty(Topicheader instance) throws CommonException {
		log.debug("attaching dirty Topicheader instance");
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

	public void attachClean(Topicheader instance) throws CommonException {
		log.debug("attaching clean Topicheader instance");
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