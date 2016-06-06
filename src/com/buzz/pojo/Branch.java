package com.buzz.pojo;

// default package

import java.util.HashSet;
import java.util.Set;

import com.buzz.bean.BranchBean;

/**
 * Branch entity. @author MyEclipse Persistence Tools
 */

public class Branch implements java.io.Serializable {

	// Fields

	private int branchid;
	private String branchname;
	private String branchdesc;
	private Set studentDetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Branch() {
	}

	/** minimal constructor */
	public Branch(String branchname) {
		this.branchname = branchname;
	}

	/** full constructor */
	public Branch(String branchname, String branchdesc, Set studentDetailses) {
		this.branchname = branchname;
		this.branchdesc = branchdesc;
		this.studentDetailses = studentDetailses;
	}

	// Property accessors

	public Branch(BranchBean branchBean) {
		this.branchname = branchBean.getBranchname();
		this.branchdesc = branchBean.getBranchdesc();
		this.branchid=branchBean.getBranchid();
	}

	public Branch(int branchid2) {
		this.branchid=branchid2;
	}

	

	public String getBranchname() {
		return this.branchname;
	}

	public int getBranchid() {
		return branchid;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getBranchdesc() {
		return this.branchdesc;
	}

	public void setBranchdesc(String branchdesc) {
		this.branchdesc = branchdesc;
	}

	public Set getStudentDetailses() {
		return studentDetailses;
	}

	public void setStudentDetailses(Set studentDetailses) {
		this.studentDetailses = studentDetailses;
	}
}