package com.buzz.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.buzz.formbean.DiscussionForumFormBean;
import com.buzz.pojo.Discussionforum;
import com.buzz.util.DateWrapper;

/**
 * Discussionforum entity. @author MyEclipse Persistence Tools
 */

public class DiscussionforumBean implements java.io.Serializable {

	// Fields

	private int forumid;
	private LogindetailsBean logindetails;
	private String forumdesc;
	private String posteddate;

	// Constructors

	/** default constructor */
	public DiscussionforumBean() {
	}



	// Property accessors

	public DiscussionforumBean(DiscussionForumFormBean discussionForumFormBean) {

		this.forumdesc = discussionForumFormBean.getDiscussionDesc();

	}

	public DiscussionforumBean(Discussionforum discussionforum) {
		this.forumid = discussionforum.getForumid();
		this.logindetails = new LogindetailsBean(discussionforum
				.getLogindetails());
		this.forumdesc = discussionforum.getEventdesc();
		this.posteddate = DateWrapper
				.parseDate(discussionforum.getPosteddate());
	}
	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public void setPosteddate(String posteddate) {
		this.posteddate = posteddate;
	}

	public LogindetailsBean getLogindetails() {
		return this.logindetails;
	}

	public void setLogindetails(LogindetailsBean logindetails) {
		this.logindetails = logindetails;
	}



	public String getForumdesc() {
		return forumdesc;
	}

	public void setForumdesc(String forumdesc) {
		this.forumdesc = forumdesc;
	}

	public String getPosteddate() {
		return posteddate;
	}

}