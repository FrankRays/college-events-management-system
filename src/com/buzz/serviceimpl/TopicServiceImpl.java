package com.buzz.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.buzz.bean.TopicHeaderBean;
import com.buzz.bean.TopicfileBean;
import com.buzz.bean.TopicnameBean;

import com.buzz.dao.TopicfileDAO;
import com.buzz.dao.TopicheaderDAO;
import com.buzz.dao.TopicnameDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;

import com.buzz.pojo.Topicfile;
import com.buzz.pojo.Topicheader;
import com.buzz.pojo.Topicname;

public class TopicServiceImpl {

	TopicnameDAO topicnameDAO = new TopicnameDAO();
	TopicheaderDAO topicheaderDAO = new TopicheaderDAO();
	TopicfileDAO topicfileDAO = new TopicfileDAO();

	public void addTopicName(TopicnameBean topicnameBean)
			throws CommonException {
		Topicname topicname = new Topicname(topicnameBean);
		topicnameDAO.save(topicname);
	}

	public void addTopicHeader(TopicHeaderBean topicHeaderBean)
			throws CommonException, ConnectionException {
		Topicheader topicheader = new Topicheader(topicHeaderBean);
		topicheaderDAO.save(topicheader);
	}

	public void addTopicFile(TopicfileBean topicFileBean)
			throws CommonException {
		Topicfile topicfile = new Topicfile(topicFileBean);
		topicfileDAO.save(topicfile);
	}

	public boolean updateTopicNameByid(TopicnameBean topicNameBean)
			throws CommonException, ConnectionException {
		Topicname topicname = new Topicname(topicNameBean);
		return topicnameDAO.attachDirty(topicname);
	}

	public boolean updateTopicHeaderByid(TopicHeaderBean topicHeaderBean)
			throws CommonException, ConnectionException {
		Topicheader topicheader = new Topicheader(topicHeaderBean);
		return topicheaderDAO.attachDirty(topicheader);
	}

	public boolean updateTopicFileByid(TopicfileBean topicFileBean)
			throws CommonException, ConnectionException {
		Topicfile topicfile = new Topicfile(topicFileBean);
		return topicfileDAO.attachDirty(topicfile);
	}

	public Vector<TopicnameBean> viewTopicNames() throws CommonException {
		Topicname topicname = null;
		TopicnameBean topciNameBean = null;
		Vector<TopicnameBean> vTopicNameBeans = new Vector<TopicnameBean>();
		try {
			List list = topicnameDAO.findAll();

			for (Iterator it = list.iterator(); it.hasNext();) {
				topicname = (Topicname) it.next();
				topciNameBean = new TopicnameBean(topicname);
				vTopicNameBeans.add(topciNameBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vTopicNameBeans;
	}

	public Vector<TopicHeaderBean> viewTopicHeader() throws CommonException {
		Topicheader topicheader = null;
		TopicHeaderBean topicHeaderBean = null;
		Vector<TopicHeaderBean> vTopicHeaderBeans = new Vector<TopicHeaderBean>();
		try {
			List list = topicheaderDAO.findAll();

			for (Iterator it = list.iterator(); it.hasNext();) {
				topicheader = (Topicheader) it.next();
				topicHeaderBean = new TopicHeaderBean(topicheader);
				vTopicHeaderBeans.add(topicHeaderBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vTopicHeaderBeans;
	}

	public Vector<TopicfileBean> viewTopcicFile() throws CommonException {
		Topicfile topicfile = null;
		TopicfileBean topicFileBean = null;
		Vector<TopicfileBean> vTopicFileBeans = new Vector<TopicfileBean>();
		try {
			List list = topicfileDAO.findAll();

			for (Iterator it = list.iterator(); it.hasNext();) {
				topicfile = (Topicfile) it.next();
				topicFileBean = new TopicfileBean(topicfile);
				vTopicFileBeans.add(topicFileBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vTopicFileBeans;
	}
	public Vector<TopicfileBean> viewTopcicFile(int topicnameid) throws CommonException {
		Topicfile topicfile = null;
		TopicfileBean topicFileBean = null;
		Vector<TopicfileBean> vTopicFileBeans = new Vector<TopicfileBean>();
		try {
			List list = topicfileDAO.findAll(topicnameid);

			for (Iterator it = list.iterator(); it.hasNext();) {
				topicfile = (Topicfile) it.next();
				topicFileBean = new TopicfileBean(topicfile);
				vTopicFileBeans.add(topicFileBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vTopicFileBeans;
	}

	public TopicHeaderBean viewTopicHeaderbyId(int id) throws CommonException {
		Topicheader topicheader = null;
		TopicHeaderBean topicHeaderBean = null;
		try {
			topicheader = topicheaderDAO.findById(id);
			topicHeaderBean = new TopicHeaderBean(topicheader);

		} catch (Exception e) {
			System.out.println(e);
		}
		return topicHeaderBean;
	}

	public TopicnameBean viewTopicNamebyId(int id) throws CommonException {
		Topicname topicname = null;
		TopicnameBean topciNameBean = null;
		try {
			topicname = topicnameDAO.findById(id);
			topciNameBean = new TopicnameBean(topicname);

		} catch (Exception e) {
			System.out.println(e);
		}
		return topciNameBean;
	}

	public TopicfileBean viewTopicFilebyId(int id) throws CommonException {
		Topicfile topicfile = null;
		TopicfileBean topicFileBean = null;
		try {
			topicfile = topicfileDAO.findById(id);
			topicFileBean = new TopicfileBean(topicfile);

		} catch (Exception e) {
			System.out.println(e);
		}
		return topicFileBean;
	}

	public boolean deleteTopicHeader(int parseInt) throws CommonException {
		try {
			Topicheader topicheader = null;
			topicheader = topicheaderDAO.findById(parseInt);
			topicheaderDAO.delete(topicheader);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	public boolean deleteTopicName(int parseInt) throws CommonException {
		try {
			Topicname topicname = null;
			topicname = topicnameDAO.findById(parseInt);
			topicnameDAO.delete(topicname);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	public boolean deleteTopicFile(int parseInt) throws CommonException {
		try {
			Topicfile topicfile = null;
			topicfile = topicfileDAO.findById(parseInt);
			topicfileDAO.delete(topicfile);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	public Vector<TopicnameBean> viewTopicNames(int topicheaderid) {
		Topicname topicname = null;
		TopicnameBean topciNameBean = null;
		Vector<TopicnameBean> vTopicNameBeans = new Vector<TopicnameBean>();
		try {
			List list = topicnameDAO.findAll(topicheaderid);

			for (Iterator it = list.iterator(); it.hasNext();) {
				topicname = (Topicname) it.next();
				topciNameBean = new TopicnameBean(topicname);
				vTopicNameBeans.add(topciNameBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vTopicNameBeans;
	}

}
