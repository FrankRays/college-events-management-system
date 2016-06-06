package com.buzz.serviceimpl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.buzz.bean.BranchBean;
import com.buzz.bean.LogindetailsBean;
import com.buzz.bean.NewsfeedBean;
import com.buzz.dao.LogindetailsDAO;
import com.buzz.dao.SecurityDAOImpl;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Branch;
import com.buzz.pojo.Logindetails;


public class SecurityServiceImpl {
	SecurityDAOImpl logindetailsDAO=new SecurityDAOImpl();
	LogindetailsDAO logindetailsDAO2=new LogindetailsDAO();

	public LogindetailsBean loginCheck(LogindetailsBean logindetailsBean)
			throws ConnectionException {
		return logindetailsDAO.loginCheck(logindetailsBean);
	}


	public Vector<LogindetailsBean> viewMailIDs() {
		// TODO Auto-generated method stub
		Logindetails logindetails = null;
		LogindetailsBean logindetailsBean = null;
		Vector<LogindetailsBean> vLogindetailsBeans = new Vector<LogindetailsBean>();
		try {
			List list = logindetailsDAO2.findAll();

			for (Iterator it = list.iterator(); it.hasNext();) {
				logindetails = (Logindetails) it.next();
				logindetailsBean = new LogindetailsBean(logindetails);
				vLogindetailsBeans.add(logindetailsBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vLogindetailsBeans;
	}


	public boolean changePassword(LogindetailsBean logindetailsBean) throws ConnectionException {
		return logindetailsDAO.attachDirty(logindetailsBean);
	}

	/*public String checkUser(String loginid) throws ConnectionException {
		return logindetailsDAO.checkUser(loginid);
	}
	
		public boolean passwordRecovery(UserDetails userDetails)
			throws ConnectionException {
		return logindetailsDAO.passwordRecovery(userDetails);
	}

	public boolean newPassword(LoginDetails loginDetails)
			throws ConnectionException {
		return logindetailsDAO.newPassword(loginDetails);
	}

	public boolean changePass(LoginDetails loginDetails)
			throws ConnectionException {
		return logindetailsDAO.changePass(loginDetails);
	}

	public UserDetails viewUserProfile(int userid, String path)
			throws ConnectionException {
		return logindetailsDAO.viewUserProfile(userid, path);
	}

	public Vector<UserDetails> viewUserList(String userid, String path)
			throws ConnectionException {
		return logindetailsDAO.viewUserList(userid, path);
	}

	public boolean deleteUsers(int userid) throws ConnectionException {
		return logindetailsDAO.deleteUsers(userid);
	}*/
}
