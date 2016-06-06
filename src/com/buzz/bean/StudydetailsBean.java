package com.buzz.bean;

// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.buzz.formbean.StudyDetailsFormBean;
import com.buzz.pojo.Studydetails;
import com.buzz.util.DateWrapper;

/**
 * Studydetails entity. @author MyEclipse Persistence Tools
 */

public class StudydetailsBean implements java.io.Serializable {

	// Fields

	private int studyid;
	private String studyname;
	private String studydesc;
	private String studydate;
	private Set coachingcenters = new HashSet(0);

	// Constructors

	/** default constructor */
	public StudydetailsBean() {
	}

	/** minimal constructor */
	public StudydetailsBean(String studyname, String studydesc, Date studydate) {
		this.studyname = studyname;
		this.studydesc = studydesc;
		this.studydate = DateWrapper.parseDate(studydate);
	}

	/** full constructor */
	public StudydetailsBean(String studyname, String studydesc, Date studydate,
			Set coachingcenters) {
		this.studyname = studyname;
		this.studydesc = studydesc;
		this.studydate = DateWrapper.parseDate(studydate);
		this.coachingcenters = coachingcenters;
	}

	// Property accessors

	public StudydetailsBean(Studydetails studydetails) {
		this.studyid = studydetails.getStudyid();
		this.studyname = studydetails.getStudyname();
		this.studydesc = studydetails.getStudydesc();
		this.studydate = DateWrapper.parseDate(studydetails.getStudydate());
	}

	public StudydetailsBean(StudyDetailsFormBean studyDetailsFormBean) {
		this.studyname = studyDetailsFormBean.getStudyName();
		this.studydesc = studyDetailsFormBean.getStudyDesc();
	
	}

	public String getStudyname() {
		return this.studyname;
	}

	public void setStudyname(String studyname) {
		this.studyname = studyname;
	}

	public String getStudydesc() {
		return this.studydesc;
	}

	public void setStudydesc(String studydesc) {
		this.studydesc = studydesc;
	}

	public int getStudyid() {
		return studyid;
	}

	public void setStudyid(int studyid) {
		this.studyid = studyid;
	}

	public String getStudydate() {
		return studydate;
	}

	public void setStudydate(String studydate) {
		this.studydate = studydate;
	}

	public Set getCoachingcenters() {
		return this.coachingcenters;
	}

	public void setCoachingcenters(Set coachingcenters) {
		this.coachingcenters = coachingcenters;
	}

}