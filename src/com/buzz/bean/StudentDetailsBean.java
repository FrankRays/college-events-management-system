package com.buzz.bean;

// default package

import java.math.BigDecimal;
import java.util.Date;

import com.buzz.formbean.StudentDetailsformBean;
import com.buzz.pojo.Branch;
import com.buzz.pojo.StudentDetails;
import com.buzz.util.DateWrapper;

/**
 * StudentDetails entity. @author MyEclipse Persistence Tools
 */

public class StudentDetailsBean implements java.io.Serializable {

	// Fields

	private int studentid;
	private int studyid;
	private BranchBean branch;
	private LogindetailsBean logindetails;
	private String studentname;
	private String studentyear;
	private String studentdate;

	// Constructors

	/** default constructor */
	public StudentDetailsBean() {
	}

	/** minimal constructor */
	public StudentDetailsBean(BranchBean branch, LogindetailsBean logindetails,
			String studentname) {
		this.branch = branch;
		this.logindetails = logindetails;
		this.studentname = studentname;
	}

	/** full constructor */
	public StudentDetailsBean(BranchBean branch, LogindetailsBean logindetails,
			String studentname, String studentyear, Date studentdate) {
		this.branch = branch;
		this.logindetails = logindetails;
		this.studentname = studentname;
		this.studentyear = studentyear;
		this.studentdate = DateWrapper.parseDate(studentdate);
	}

	// Property accessors

	public StudentDetailsBean(StudentDetailsformBean studentDetailsformBean) {

		this.branch = new BranchBean(studentDetailsformBean
				.getStudentBranchidref());
		this.studentname = studentDetailsformBean.getStudentname();
		this.studentyear = studentDetailsformBean.getStudentyear();
	}

	public StudentDetailsBean(StudentDetails studentDetails) {
		this.studentid = studentDetails.getStudentid();
		this.branch = new BranchBean(studentDetails.getBranch());
		this.logindetails = new LogindetailsBean(studentDetails
				.getLogindetails());
		this.studentname = studentDetails.getStudentname();
		this.studentyear = studentDetails.getStudentyear();
		this.studentdate = DateWrapper.parseDate(studentDetails
				.getStudentdate());
	}

	public BranchBean getBranch() {
		return this.branch;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public void setStudentdate(String studentdate) {
		this.studentdate = studentdate;
	}

	public void setBranch(BranchBean branch) {
		this.branch = branch;
	}

	public LogindetailsBean getLogindetails() {
		return this.logindetails;
	}

	public void setLogindetails(LogindetailsBean logindetails) {
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

	public String getStudentdate() {
		return studentdate;
	}

}