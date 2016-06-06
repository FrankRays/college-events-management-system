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
import com.buzz.pojo.Newsfeed;
import com.buzz.util.DateWrapper;

/**
 * A data access object (DAO) providing persistence and search support for
 * Newsfeed entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mapping.NewsfeedBean
 * @author MyEclipse Persistence Tools
 */

public class NewsfeedDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(NewsfeedDAO.class);
	// property constants
	public static final String NEWSHEADER = "newsheader";
	public static final String NEWSDESC = "newsdesc";
	Session session;
	Transaction transaction;

	public void save(Newsfeed transientInstance) throws CommonException {
		try {
			session = getSession();
			Transaction transaction = session.beginTransaction();
			transientInstance.setNewsdate(new Date());
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
			log.error("save failed", re);
			throw new CommonException("Data Not Inserted");
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

	public void delete(Newsfeed persistentInstance) throws CommonException {
		log.debug("deleting Branch instance");
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

	public Newsfeed findById(int id) throws CommonException {
		log.debug("getting Branch instance with id: " + id);
		try {
			Newsfeed instance = (Newsfeed) getSession().get(
					"com.buzz.pojo.Newsfeed", id);
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

	public List findByExample(Newsfeed instance) throws ConnectionException {
		log.debug("finding Newsfeed instance by example");
		try {
			List results = getSession().createCriteria("mapping.Newsfeed").add(
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
		log.debug("finding Newsfeed instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Newsfeed as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNewsheader(Object newsheader) throws ConnectionException {
		return findByProperty(NEWSHEADER, newsheader);
	}

	public List findByNewsdesc(Object newsdesc) throws ConnectionException {
		return findByProperty(NEWSDESC, newsdesc);
	}

	public List findAll() throws ConnectionException {
		log.debug("finding all Newsfeed instances");
		try {
			String queryString = "from Newsfeed";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Newsfeed merge(Newsfeed detachedInstance) throws ConnectionException {
		log.debug("merging Newsfeed instance");
		try {
			Newsfeed result = (Newsfeed) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(Newsfeed newsfeed) throws ConnectionException {
		log.debug("attaching dirty Branch instance");
		try {
			System.out.println(newsfeed.getNewsid());
			Session session = getSession();
			Newsfeed instance = (Newsfeed) session.get(
					"com.buzz.pojo.Newsfeed", newsfeed.getNewsid());
			Transaction transaction = session.beginTransaction();
	
			instance.setNewsheader(newsfeed.getNewsheader());
			instance.setNewsdesc(newsfeed.getNewsdesc());
			session.update(instance);
			transaction.commit();
			log.debug("attach successful");
			return true;

		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Newsfeed instance) throws ConnectionException {
		log.debug("attaching clean Newsfeed instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}