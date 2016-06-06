package com.buzz.pojo;

import java.math.BigDecimal;
import java.util.Date;

import com.buzz.bean.DiscussionforumBean;

/**
 * Discussionforum entity. @author MyEclipse Persistence Tools
 */

public class Discussionforum implements java.io.Serializable {

	// Fields

	private int forumid;
	private Logindetails logindetails;
	private Events events;
	private String eventdesc;
	private Date posteddate;

	// Constructors

	/** default constructor */
	public Discussionforum() {
	}

	/** full constructor */
	public Discussionforum(Logindetails logindetails, Events events,
			String eventdesc, Date posteddate) {
		this.logindetails = logindetails;
		this.events = events;
		this.eventdesc = eventdesc;
		this.posteddate = posteddate;
	}

	// Property accessors


	public Discussionforum(DiscussionforumBean discussionforumBean) {
		this.eventdesc = discussionforumBean.getForumdesc();
		this.logindetails=new Logindetails(discussionforumBean.getLogindetails().getUserid());
		//this.events=new Events(discussionforumBean.getEvents().getEventid());
	}

	public Logindetails getLogindetails() {
		return this.logindetails;
	}

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public void setLogindetails(Logindetails logindetails) {
		this.logindetails = logindetails;
	}

	public Events getEvents() {
		return this.events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public String getEventdesc() {
		return this.eventdesc;
	}

	public void setEventdesc(String eventdesc) {
		this.eventdesc = eventdesc;
	}

	public Date getPosteddate() {
		return this.posteddate;
	}

	public void setPosteddate(Date posteddate) {
		this.posteddate = posteddate;
	}

}