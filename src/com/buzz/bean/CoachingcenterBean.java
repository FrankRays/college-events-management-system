package com.buzz.bean;

// default package

import java.math.BigDecimal;
import java.util.Date;

import com.buzz.formbean.CoachingCenterFormBean;
import com.buzz.pojo.Coachingcenter;
import com.buzz.util.DateWrapper;

/**
 * Coachingcenter entity. @author MyEclipse Persistence Tools
 */

public class CoachingcenterBean implements java.io.Serializable {

	// Fields

	private int coachingcenterid;
	private int studyid;
	private StudydetailsBean studydetails;
	private String coachingcentername;
	private String coachingaddresses;
	private String coachingcontact;
	private String coachingdesc;
	private String coachingadddate;

	// Constructors

	/** default constructor */
	public CoachingcenterBean(CoachingCenterFormBean centerFormBean) {
		this.coachingcentername = centerFormBean.getCoachingcentername();
		this.coachingaddresses = centerFormBean.getCoachingAddress();
		this.coachingcontact = centerFormBean.getCoachingContact();
		this.coachingdesc = centerFormBean.getCoachingDesc();
		this.studyid=centerFormBean.getStudyid();

	}

	public CoachingcenterBean(Coachingcenter coachingcenter) {
		this.coachingcenterid = coachingcenter.getCoachingcenterid();
		this.studydetails = new StudydetailsBean(coachingcenter
				.getStudydetails());
		this.coachingcentername = coachingcenter.getCoachingcentername();
		this.coachingaddresses = coachingcenter.getCoachingaddresses();
		this.coachingcontact = coachingcenter.getCoachingcontact();
		this.coachingdesc = coachingcenter.getCoachingdesc();
		this.coachingadddate = DateWrapper.parseDate(coachingcenter
				.getCoachingadddate());
	}

	// Property accessors

	public StudydetailsBean getStudydetails() {
		return this.studydetails;
	}

	public void setStudydetails(StudydetailsBean studydetails) {
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

	public int getCoachingcenterid() {
		return coachingcenterid;
	}

	public void setCoachingcenterid(int coachingcenterid) {
		this.coachingcenterid = coachingcenterid;
	}

	public String getCoachingadddate() {
		return coachingadddate;
	}

	public void setCoachingadddate(String coachingadddate) {
		this.coachingadddate = coachingadddate;
	}

	public int getStudyid() {
		return studyid;
	}

	public void setStudyid(int studyid) {
		this.studyid = studyid;
	}

}