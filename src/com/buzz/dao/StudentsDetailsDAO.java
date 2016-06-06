package com.buzz.dao;

import java.io.File;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
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

import com.buzz.bean.LogindetailsBean;
import com.buzz.dbfactory.BaseHibernateDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.StudentDetails;


/**
 * A data access object (DAO) providing persistence and search support for
 * OraganisedStudentsDetails entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see mapping.OraganisedStudentsDetailsBean
 * @author MyEclipse Persistence Tools
 */

public class StudentsDetailsDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory
			.getLog(StudentsDetailsDAO.class);
	// property constants
	public static final String STUDENTNAME = "studentname";
	public static final String STUDENTSTUDYINGYEAR = "studentstudyingyear";

	public LogindetailsBean save(StudentDetails transientInstance)
			throws CommonException {
		log.debug("saving OraganisedStudentsDetails instance");
		LogindetailsBean logindetailsBean = new LogindetailsBean();
		Session session=null;
		try {
	
			 session = getSession();
			Transaction transaction = session.beginTransaction();
			Connection connection = session.connection();
			CallableStatement query = connection
					.prepareCall(" { call studentregistraion(?,?,?,?,?) }");

			query.setInt(1, transientInstance.getBranch().getBranchid());
			query.setString(2, transientInstance.getStudentname());
			query.setString(3, transientInstance.getStudentyear());

			query.registerOutParameter(4, Types.VARCHAR);
			query.registerOutParameter(5, Types.VARCHAR);

			query.execute();
			transaction.commit();
			String loginid = query.getString(4);
			String password = query.getString(5);

			logindetailsBean.setLoginid(loginid);
			logindetailsBean.setPassword(password);

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
		return logindetailsBean;
	}
	public List findAll() throws ConnectionException {
		log.debug("finding all OraganisedStudentsDetails instances");
		try {
			String queryString = "from StudentDetails";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	/*public void delete(OraganisedStudentsDetails persistentInstance)
			throws ConnectionException {
		log.debug("deleting OraganisedStudentsDetails instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OraganisedStudentsDetails findById(int id)
			throws ConnectionException {
		log.debug("getting OraganisedStudentsDetails instance with id: " + id);
		try {
			OraganisedStudentsDetails instance = (OraganisedStudentsDetails) getSession()
					.get("mapping.OraganisedStudentsDetails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OraganisedStudentsDetails instance)
			throws ConnectionException {
		log.debug("finding OraganisedStudentsDetails instance by example");
		try {
			List results = getSession().createCriteria(
					"mapping.OraganisedStudentsDetails").add(
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
		log.debug("finding OraganisedStudentsDetails instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from OraganisedStudentsDetails as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStudentname(Object studentname)
			throws ConnectionException {
		return findByProperty(STUDENTNAME, studentname);
	}

	public List findByStudentstudyingyear(Object studentstudyingyear)
			throws ConnectionException {
		return findByProperty(STUDENTSTUDYINGYEAR, studentstudyingyear);
	}

	

	public List findAll(int eventid) throws ConnectionException,
			CommonException {
		log.debug("finding all OraganisedStudentsDetails instances");
		try {

			String queryString = "from OraganisedStudentsDetails as model where model.events.eventid = ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, eventid);
			return queryObject.list();
		} catch (ConnectionException re) {
			log.error("save failed", re);
			throw new CommonException(
					"Database Not Connected Please Check hibernate.cfg.xml file");
		} catch (HibernateException re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new CommonException("No Data");
		} catch (Exception re) {
			System.out.println(re);
			log.error("save failed", re);
			throw new CommonException("No Data");
		}
	}

	public OraganisedStudentsDetails merge(
			OraganisedStudentsDetails detachedInstance)
			throws ConnectionException {
		log.debug("merging OraganisedStudentsDetails instance");
		try {
			OraganisedStudentsDetails result = (OraganisedStudentsDetails) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OraganisedStudentsDetails instance) {
		
		 * log.debug("attaching dirty OraganisedStudentsDetails instance"); try
		 * { getSession().saveOrUpdate(instance);
		 * log.debug("attach successful"); } catch (RuntimeException re) {
		 * log.error("attach failed", re); throw re; }
		 
	}

	public void attachClean(OraganisedStudentsDetails instance)
			throws ConnectionException {
		log.debug("attaching clean OraganisedStudentsDetails instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}*/
}