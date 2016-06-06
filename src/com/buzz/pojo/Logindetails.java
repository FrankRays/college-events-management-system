package com.buzz.pojo;

// default package

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Logindetails entity. @author MyEclipse Persistence Tools
 */

public class Logindetails implements java.io.Serializable {

	// Fields

	private int userid;
	private String loginid;
	private String password;
	private String logintype;
	private String status;
	private Set studentDetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Logindetails() {
	}

	/** minimal constructor */
	public Logindetails(String loginid, String password, String logintype,
			String status) {
		this.loginid = loginid;
		this.password = password;
		this.logintype = logintype;
		this.status = status;
	}

	/** full constructor */
	public Logindetails(String loginid, String password, String logintype,
			String status, Set studentDetailses) {
		this.loginid = loginid;
		this.password = password;
		this.logintype = logintype;
		this.status = status;
		this.studentDetailses = studentDetailses;
	}

	// Property accessors

	public Logindetails(int userid) {
		this.userid = userid;
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

}