package com.buzz.pojo;

// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.buzz.bean.StudydetailsBean;

/**
 * Studydetails entity. @author MyEclipse Persistence Tools
 */

public class Studydetails implements java.io.Serializable {

	// Fields

	private int studyid;
	private String studyname;
	private String studydesc;
	private Date studydate;
	private Set coachingcenters = new HashSet(0);

	// Constructors

	/** default constructor */
	public Studydetails() {
	}

	/** minimal constructor */
	public Studydetails(String studyname, String studydesc, Date studydate) {
		this.studyname = studyname;
		this.studydesc = studydesc;
		this.studydate = studydate;
	}

	/** full constructor */
	public Studydetails(String studyname, String studydesc, Date studydate,
			Set coachingcenters) {
		this.studyname = studyname;
		this.studydesc = studydesc;
		this.studydate = studydate;
		this.coachingcenters = coachingcenters;
	}

	// Property accessors

	public Studydetails(int studyid) {
		this.studyid = studyid;
	}

	public Studydetails(StudydetailsBean studyDetailsBean) {
		
		this.studyname = studyDetailsBean.getStudyname();
		this.studydesc =studyDetailsBean.getStudydesc();
		
	}

	public String getStudyname() {
		return this.studyname;
	}

	public int getStudyid() {
		return studyid;
	}

	public void setStudyid(int studyid) {
		this.studyid = studyid;
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

	public Date getStudydate() {
		return this.studydate;
	}

	public void setStudydate(Date studydate) {
		this.studydate = studydate;
	}

	public Set getCoachingcenters() {
		return this.coachingcenters;
	}

	public void setCoachingcenters(Set coachingcenters) {
		this.coachingcenters = coachingcenters;
	}

}