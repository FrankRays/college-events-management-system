package com.buzz.pojo;

// default package

import java.math.BigDecimal;
import java.util.Date;

import com.buzz.bean.CoachingcenterBean;
import com.buzz.util.DateWrapper;

/**
 * Coachingcenter entity. @author MyEclipse Persistence Tools
 */

public class Coachingcenter implements java.io.Serializable {

	// Fields

	private int coachingcenterid;
	private Studydetails studydetails;
	private String coachingcentername;
	private String coachingaddresses;
	private String coachingcontact;
	private String coachingdesc;
	private Date coachingadddate;

	// Constructors

	/** default constructor */
	public Coachingcenter() {
	}

	/** minimal constructor */
	public Coachingcenter(Studydetails studydetails, String coachingcentername,
			String coachingcontact) {
		this.studydetails = studydetails;
		this.coachingcentername = coachingcentername;
		this.coachingcontact = coachingcontact;
	}

	/** full constructor */
	public Coachingcenter(Studydetails studydetails, String coachingcentername,
			String coachingaddresses, String coachingcontact,
			String coachingdesc, Date coachingadddate) {
		this.studydetails = studydetails;
		this.coachingcentername = coachingcentername;
		this.coachingaddresses = coachingaddresses;
		this.coachingcontact = coachingcontact;
		this.coachingdesc = coachingdesc;
		this.coachingadddate = coachingadddate;
	}

	// Property accessors

	public Coachingcenter(CoachingcenterBean coachingcenterBean) {
        this.coachingcentername =coachingcenterBean.getCoachingcentername();
        this.coachingaddresses = coachingcenterBean.getCoachingaddresses();
        this.coachingcontact =coachingcenterBean.getCoachingcontact();
        this.coachingdesc = coachingcenterBean.getCoachingdesc();
        this.studydetails=new Studydetails(coachingcenterBean.getStudyid());
	}

	public Studydetails getStudydetails() {
		return this.studydetails;
	}

	public int getCoachingcenterid() {
		return coachingcenterid;
	}

	public void setCoachingcenterid(int coachingcenterid) {
		this.coachingcenterid = coachingcenterid;
	}

	public void setStudydetails(Studydetails studydetails) {
		this.studydetails = studydetails;
	}

	public String getCoachingcentername() {
		return this.coachingcentername;
	}

	public void setCoachingcentername(String coachingcentername) {
		this.coachingcentername = coachingcentername;
	}

	public String getCoachingaddresses() {
		return this.coachingaddresses;
	}

	public void setCoachingaddresses(String coachingaddresses) {
		this.coachingaddresses = coachingaddresses;
	}

	public String getCoachingcontact() {
		return this.coachingcontact;
	}

	public void setCoachingcontact(String coachingcontact) {
		this.coachingcontact = coachingcontact;
	}

	public String getCoachingdesc() {
		return this.coachingdesc;
	}

	public void setCoachingdesc(String coachingdesc) {
		this.coachingdesc = coachingdesc;
	}

	public Date getCoachingadddate() {
		return this.coachingadddate;
	}

	public void setCoachingadddate(Date coachingadddate) {
		this.coachingadddate = coachingadddate;
	}





}