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
import com.buzz.pojo.Faqs;

/**
 * A data access object (DAO) providing persistence and search support for Faqs
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see mapping.FaqsBean
 * @author MyEclipse Persistence Tools
 */

public class FaqsDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(FaqsDAO.class);
	// property constants
	public static final String FAQ = "faq";
	public static final String ANSWER = "answer";
	Session session;
	Transaction transaction;

	public void save(Faqs transientInstance) throws CommonException {
		log.debug("saving FAq instance");
		try {

			session = getSession();
			Transaction transaction = session.beginTransaction();
			transientInstance.setPosteddate(new Date());
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

	public void delete(Faqs persistentInstance) throws CommonException {
		log.debug("deleting Faq instance");
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

	public Faqs findById(int id) throws CommonException {
		log.debug("getting Faqs instance with id: " + id);
		try {
			Faqs instance = (Faqs) getSession().get("com.buzz.pojo.Faqs", id);
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

	public List findByExample(Faqs instance) throws ConnectionException {
		log.debug("finding Faqs instance by example");
		try {
			List results = getSession().createCriteria("mapping.Faqs").add(
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
		log.debug("finding Faqs instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Faqs as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFaq(Object faq) throws ConnectionException {
		return findByProperty(FAQ, faq);
	}

	public List findByAnswer(Object answer) throws ConnectionException {
		return findByProperty(ANSWER, answer);
	}

	public List findAll() throws CommonException {
		log.debug("finding all Faqs instances");
		try {
			String queryString = "from Faqs";
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

	public Faqs merge(Faqs detachedInstance) throws ConnectionException {
		log.debug("merging Faqs instance");
		try {
			Faqs result = (Faqs) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(Faqs faqs) throws CommonException {
		log.debug("attaching dirty Faqs instance");
		try {
			Session session = getSession();
			Faqs instance = (Faqs) session.get("com.cems.pojo.Faqs", faqs
					.getFaqid());
			Transaction transaction = session.beginTransaction();
			instance.setFaq(faqs.getFaq());
			instance.setAnswer(faqs.getAnswer());
			
			
			
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
			throw new CommonException("Data Not Updated");
		} catch (Exception re) {
			log.error("save failed", re);
			throw new CommonException("Data Not Updated");
		}
	}

	public void attachClean(Faqs instance) throws ConnectionException {
		log.debug("attaching clean Faqs instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}