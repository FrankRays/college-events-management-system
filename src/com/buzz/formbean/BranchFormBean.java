package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.buzz.bean.BranchBean;

public class BranchFormBean extends ValidatorForm {

	private String branchName;
	private String branchDesc;
	private int branchid;
	private BranchBean branchBean;
	private String[] data;  
	
	
	
	
	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

	

	public BranchBean getBranchBean() {
		return branchBean;
	}

	public void setBranchBean(BranchBean branchBean) {
		this.branchBean = branchBean;
	}

	public String getBranchName() {
		return branchName;
	}

	public int getBranchid() {
		return branchid;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchDesc() {
		return branchDesc;
	}

	public void setBranchDesc(String branchDesc) {
		this.branchDesc = branchDesc;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.validate(mapping, request);
	}

}
