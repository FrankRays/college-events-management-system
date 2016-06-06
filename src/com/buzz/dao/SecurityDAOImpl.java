package com.buzz.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.buzz.bean.LogindetailsBean;
import com.buzz.dbfactory.BaseHibernateDAO;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Logindetails;

public class SecurityDAOImpl extends BaseHibernateDAO {
	boolean flag = false;
	Session session = null;
	private static final Log log = LogFactory.getLog(SecurityDAOImpl.class);

	public LogindetailsBean loginCheck(LogindetailsBean loginDetailsBean)
			throws ConnectionException {
		Logindetails logindetails = null;
		LogindetailsBean logindetailsBean2 = null;
		try {
			Session session = getSession();
			List query = session
					.createQuery(
							"select login from Logindetails login where login.loginid=? and login.password=? and login.status='Active'")
					.setParameter(0, loginDetailsBean.getLoginid()).setString(
							1, loginDetailsBean.getPassword()).list();
			if (!query.equals("")) {
				logindetailsBean2 = new LogindetailsBean();
				Iterator iterator = query.iterator();
				logindetails = (Logindetails) iterator.next();
				logindetailsBean2.setLoginid(logindetails.getLoginid());
				logindetailsBean2.setLogintype(logindetails.getLogintype());
				logindetailsBean2.setUserid(logindetails.getUserid());

			}
		} catch (NoSuchElementException e) {
			throw new ConnectionException("Invalid loginid and Password");

		} catch (Exception e) {
			throw new ConnectionException("Invalid loginid and Password");
		}
		return logindetailsBean2;
	}

	public Vector<LogindetailsBean> viewMailIDs() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean attachDirty(LogindetailsBean logindetailsBean)
			throws ConnectionException {
		boolean flag = false;
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			Query query = session
					.createQuery("update Logindetails set password = :newpwd"
							+ " where loginid = :id and password=:pwd");
			query.setParameter("newpwd", logindetailsBean.getChangepassword());
			query.setParameter("id", logindetailsBean.getLoginid());
			query.setParameter("pwd", logindetailsBean.getPassword());
			System.out.println(logindetailsBean.getChangepassword());
			System.out.println(logindetailsBean.getLoginid());
			System.out.println(logindetailsBean.getChangepassword());
			int result = query.executeUpdate();
			System.out.println(result);
			if (result > 0) {
				flag = true;
				transaction.commit();
			}
		} catch (RuntimeException re) {
			System.out.println(re);
			log.error("find by property name failed", re);
			throw re;
		}
		return flag;
	}

}
