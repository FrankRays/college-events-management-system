package com.buzz.bean;

// default package

import java.util.HashSet;
import java.util.Set;

import com.buzz.formbean.LogindetailsFormbean;
import com.buzz.pojo.Logindetails;

/**
 * Logindetails entity. @author MyEclipse Persistence Tools
 */

public class LogindetailsBean implements java.io.Serializable {

	// Fields

	private int userid;
	private String loginid;
	private String password;
	private String logintype;
	private String status;
	private String changepassword;
	private Set studentDetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public LogindetailsBean() {
	}

	/** minimal constructor */
	public LogindetailsBean(String loginid, String password, String logintype,
			String status) {
		this.loginid = loginid;
		this.password = password;
		this.logintype = logintype;
		this.status = status;
	}

	/** full constructor */
	public LogindetailsBean(String loginid, String password, String logintype,
			String status, Set studentDetailses) {
		this.loginid = loginid;
		this.password = password;
		this.logintype = logintype;
		this.status = status;
		this.studentDetailses = studentDetailses;
	}

	// Property accessors

	public LogindetailsBean(Logindetails logindetails) {
		this.userid = logindetails.getUserid();
		this.loginid = logindetails.getLoginid();
		this.password = logindetails.getPassword();
		this.logintype = logindetails.getLogintype();
		this.status = logindetails.getStatus();
	}

	public LogindetailsBean(Integer attribute) {
		this.userid = attribute;
	}

	public LogindetailsBean(LogindetailsFormbean logindetailsFormbean) {
		this.loginid = logindetailsFormbean.getLoginid();
		this.password = logindetailsFormbean.getPassword();
	}

	public String getLoginid() {
		return this.loginid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogintype() {
		return this.logintype;
	}

	public void setLogintype(String logintype) {
		this.logintype = logintype;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getStudentDetailses() {
		return this.studentDetailses;
	}

	public void setStudentDetailses(Set studentDetailses) {
		this.studentDetailses = studentDetailses;
	}

	public String getChangepassword() {
		return changepassword;
	}

	public void setChangepassword(String changepassword) {
		this.changepassword = changepassword;
	}

}