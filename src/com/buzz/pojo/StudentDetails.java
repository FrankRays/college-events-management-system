package com.buzz.pojo;

// default package

import java.math.BigDecimal;
import java.util.Date;

import com.buzz.bean.StudentDetailsBean;

/**
 * StudentDetails entity. @author MyEclipse Persistence Tools
 */

public class StudentDetails implements java.io.Serializable {

	// Fields

	private int studentid;
	private int branchid;
	private Branch branch;
	private Logindetails logindetails;
	private String studentname;
	private String studentyear;
	private Date studentdate;

	// Constructors

	/** default constructor */
	public StudentDetails() {
	}

	/** minimal constructor */
	public StudentDetails(Branch branch, Logindetails logindetails,
			String studentname) {
		this.branch = branch;
		this.logindetails = logindetails;
		this.studentname = studentname;
	}

	/** full constructor */
	public StudentDetails(Branch branch, Logindetails logindetails,
			String studentname, String studentyear, Date studentdate) {
		this.branch = branch;
		this.logindetails = logindetails;
		this.studentname = studentname;
		this.studentyear = studentyear;
		this.studentdate = studentdate;
	}

	// Property accessors

	public StudentDetails(StudentDetailsBean studentDetailsBean) {
		this.branch =new Branch(studentDetailsBean.getBranch().getBranchid());
		this.studentname = studentDetailsBean.getStudentname();
		this.studentyear = studentDetailsBean.getStudentyear();
	}

	public Branch getBranch() {
		return this.branch;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Logindetails getLogindetails() {
		return this.logindetails;
	}

	public void setLogindetails(Logindetails logindetails) {
		this.logindetails = logindetails;
	}

	public String getStudentname() {
		return this.studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentyear() {
		return this.studentyear;
	}

	public void setStudentyear(String studentyear) {
		this.studentyear = studentyear;
	}

	public Date getStudentdate() {
		return this.studentdate;
	}

	public void setStudentdate(Date studentdate) {
		this.studentdate = studentdate;
	}

	public int getBranchid() {
		return branchid;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

}