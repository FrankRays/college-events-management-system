package com.buzz.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.buzz.bean.BranchBean;
import com.buzz.bean.NewsfeedBean;
import com.buzz.dao.BranchDAO;
import com.buzz.dao.NewsfeedDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Branch;
import com.buzz.pojo.Newsfeed;

public class NewsServiceImpl {
	NewsfeedDAO newsfeedDAO = new NewsfeedDAO();

	public void addNews(NewsfeedBean newsfeedBean) throws CommonException {
		Newsfeed newsfeed = new Newsfeed(newsfeedBean);
		newsfeedDAO.save(newsfeed);
	}

	public boolean newsUpdatebyid(NewsfeedBean newsfeedBean)
			throws CommonException, ConnectionException {
		Newsfeed newsfeed = new Newsfeed(newsfeedBean);
		return newsfeedDAO.attachDirty(newsfeed);
	}

	public Vector<NewsfeedBean> viewNews() throws CommonException {
		Newsfeed newsfeed = null;
		NewsfeedBean newsfeedBean = null;
		Vector<NewsfeedBean> vNewsfeedBeans = new Vector<NewsfeedBean>();
		try {
			List list = newsfeedDAO.findAll();
			for (Iterator it = list.iterator(); it.hasNext();) {
				newsfeed = (Newsfeed) it.next();
				newsfeedBean = new NewsfeedBean(newsfeed);
				vNewsfeedBeans.add(newsfeedBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vNewsfeedBeans;
	}

	public NewsfeedBean viewNewsbyId(int id) throws CommonException {
		Newsfeed newsfeed = null;
		NewsfeedBean newsfeedBean = null;
		try {
			newsfeed = newsfeedDAO.findById(id);
			newsfeedBean = new NewsfeedBean(newsfeed);

		} catch (Exception e) {
			System.out.println(e);
		}
		return newsfeedBean;
	}

	public boolean deleteNews(int parseInt) throws CommonException {
		try {
			Newsfeed newsfeed = newsfeedDAO.findById(parseInt);
			newsfeedDAO.delete(newsfeed);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
