package com.buzz.dao;

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

/**
 * A data access object (DAO) providing persistence and search support for
 * Branch entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mapping.BranchBean
 * @author MyEclipse Persistence Tools
 */

public class BranchDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(BranchDAO.class);
	// property constants
	public static final String BRANCHNAME = "branchname";
	public static final String BRANCHDESC = "branchdesc";
	Session session;
	Transaction transaction;

	public void save(Branch transientInstance) throws CommonException {
		log.debug("saving Branch instance");
		try {
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

	public void delete(Branch persistentInstance) throws CommonException {
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

	public Branch findById(int id) throws CommonException {
		log.debug("getting Branch instance with id: " + id);
		try {
			Branch instance = (Branch) getSession().get("com.buzz.pojo.Branch",
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

	public List findByExample(Branch instance) throws ConnectionException {
		log.debug("finding Branch instance by example");
		try {
			List results = getSession().createCriteria("com.buzz.pojo.Branch")
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
		log.debug("finding Branch instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Branch as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBranchname(Object branchname) throws ConnectionException {
		return findByProperty(BRANCHNAME, branchname);
	}

	public List findByBranchdesc(Object branchdesc) throws ConnectionException {
		return findByProperty(BRANCHDESC, branchdesc);
	}

	public List findAll() throws CommonException {
		log.debug("finding all Branch instances");
		try {
			String queryString = "from Branch";
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

	public Branch merge(Branch detachedInstance) throws ConnectionException {
		log.debug("merging Branch instance");
		try {
			Branch result = (Branch) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public boolean attachDirty(Branch branch) throws ConnectionException {
		log.debug("attaching dirty Branch instance");
		try {
			Session session = getSession();
			Branch instance = (Branch) session.get("com.buzz.pojo.Branch",
					branch.getBranchid());
			Transaction transaction = session.beginTransaction();

			instance.setBranchname(branch.getBranchname());
			instance.setBranchdesc(branch.getBranchdesc());
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

	public void attachClean(Branch instance) throws ConnectionException {
		log.debug("attaching clean Branch instance");
		try {
			try {
				getSession().lock(instance, LockMode.NONE);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}