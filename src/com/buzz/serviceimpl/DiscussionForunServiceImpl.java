package com.buzz.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.buzz.bean.BranchBean;
import com.buzz.bean.DiscussionforumBean;
import com.buzz.dao.BranchDAO;
import com.buzz.dao.DiscussionforumDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Branch;
import com.buzz.pojo.Discussionforum;

public class DiscussionForunServiceImpl {
	DiscussionforumDAO discussionforumDAO = new DiscussionforumDAO();

	public void addFormData(DiscussionforumBean discussionforumBean)
			throws CommonException, ConnectionException {
		Discussionforum discussionforum = new Discussionforum(
				discussionforumBean);
		discussionforumDAO.save(discussionforum);
	}

	public boolean branhcUpdatebyid(BranchBean branchBean)
			throws CommonException, ConnectionException {
		Branch branch = new Branch(branchBean);
		// return discussionforumDAO.attachDirty(branch);
		return false;
	}

	public Vector<DiscussionforumBean> viewFormData() throws CommonException {
		Discussionforum discussionforum = null;
		DiscussionforumBean discussionforumBean = null;
		Vector<DiscussionforumBean> vDiscussionforumBeans = new Vector<DiscussionforumBean>();
		try {
			List list = discussionforumDAO.findAll();
			for (Iterator it = list.iterator(); it.hasNext();) {
				discussionforum = (Discussionforum) it.next();
				discussionforumBean = new DiscussionforumBean(discussionforum);
				vDiscussionforumBeans.add(discussionforumBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vDiscussionforumBeans;
	}

	public BranchBean viewBranchbyId(int id) throws CommonException {
		Branch branch = null;
		BranchBean branchBean = null;
		try {
			// branch = discussionforumDAO.findById(id);
			branchBean = new BranchBean(branch);

		} catch (Exception e) {
			System.out.println(e);
		}
		return branchBean;
	}

	public boolean deleteBranches(int parseInt) throws CommonException {
		return false;
		/*
		 * try { Branch branch = null; branch =
		 * discussionforumDAO.findById(parseInt);
		 * discussionforumDAO.delete(branch); return true; } catch (Exception e)
		 * { System.out.println(e); return false; }
		 */

	}

}
