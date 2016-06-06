package com.buzz.dao;

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
import com.buzz.pojo.Topicfile;
import com.buzz.pojo.Topicname;

/**
 * A data access object (DAO) providing persistence and search support for
 * Topicfile entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mapping.Topicfile
 * @author MyEclipse Persistence Tools
 */

public class TopicfileDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TopicfileDAO.class);
	// property constants
	public static final String FILEDATA = "filedata";
	public static final String FILETYPE = "filetype";
	Session session;

	public void save(Topicfile transientInstance) throws CommonException {
		log.debug("saving Topicfile instance");
		try {
			session = getSession();
			Transaction transaction = session.beginTransaction();
			transientInstance.setTopicname(new Topicname(transientInstance.getTopicname().getTopicnameid()));
			Blob blob = Hibernate.createBlob(transientInstance.getFiledata1());
			transientInstance.setFiledata(blob);
			transientInstance.setFileadddate(new Date());
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
		}finally{
			session.close();
		}
	}

	public void delete(Topicfile persistentInstance) throws CommonException {
		log.debug("deleting Topicfile instance");
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

	public Topicfile findById(int id) throws CommonException {
		log.debug("getting Topicfile instance with id: " + id);
		try {
			Topicfile instance = (Topicfile) getSession().get(
					"mapping.Topicfile", id);
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

	public List findByExample(Topicfile instance) throws CommonException {
		log.debug("finding Topicfile instance by example");
		try {
			List results = getSession().createCriteria("mapping.Topicfile")
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
		log.debug("finding Topicfile instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Topicfile as model where model."
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

	public List findByFiledata(Object filedata) throws CommonException {
		return findByProperty(FILEDATA, filedata);
	}

	public List findByFiletype(Object filetype) throws CommonException {
		return findByProperty(FILETYPE, filetype);
	}

	public List findAll(int topicnameid) throws CommonException {
		log.debug("finding all Topicfile instances");
		try {
			String queryString = "from Topicfile as model where model.topicname.topicnameid= ?";
		Query queryObject = getSession().createQuery(queryString);
		queryObject.setParameter(0, topicnameid);
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
	public List findAll() throws CommonException {
		log.debug("finding all Topicfile instances");
		try {
			String queryString = "from Topicfile";
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
	public Topicfile merge(Topicfile detachedInstance) throws CommonException {
		log.debug("merging Topicfile instance");
		try {
			Topicfile result = (Topicfile) getSession().merge(detachedInstance);
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

	public boolean attachDirty(Topicfile instance) throws CommonException {
		log.debug("attaching dirty Topicfile instance");
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

	public void attachClean(Topicfile instance) throws CommonException {
		log.debug("attaching clean Topicfile instance");
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