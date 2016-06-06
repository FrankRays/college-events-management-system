package com.buzz.serviceimpl;


import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.buzz.bean.BranchBean;
import com.buzz.dao.BranchDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Branch;

public class BranchServiceImpl {
	BranchDAO branchDAO = new BranchDAO();

	public void addBranches(BranchBean branchBean) throws CommonException {
		Branch branch = new Branch(branchBean);
		branchDAO.save(branch);
	}

	public boolean branhcUpdatebyid(BranchBean branchBean)
			throws CommonException, ConnectionException {
		Branch branch = new Branch(branchBean);
		return branchDAO.attachDirty(branch);
	}

	public Vector<BranchBean> viewBranches() throws CommonException {
		Branch branch = null;
		BranchBean branchBean = null;
		Vector<BranchBean> vBranchBeans = new Vector<BranchBean>();
		try {
			List list = branchDAO.findAll();

			for (Iterator it = list.iterator(); it.hasNext();) {
				branch = (Branch) it.next();
				branchBean = new BranchBean(branch);
				vBranchBeans.add(branchBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vBranchBeans;
	}

	public BranchBean viewBranchbyId(int id) throws CommonException {
		Branch branch = null;
		BranchBean branchBean = null;
		try {
			branch = branchDAO.findById(id);
			branchBean = new BranchBean(branch);

		} catch (Exception e) {
			System.out.println(e);
		}
		return branchBean;
	}

	public boolean deleteBranches(int parseInt) throws CommonException {
		try {
			Branch branch = null;
			branch = branchDAO.findById(parseInt);
			branchDAO.delete(branch);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
