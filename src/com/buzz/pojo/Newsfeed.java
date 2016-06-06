package com.buzz.pojo;

// default package

import java.util.Date;

import com.buzz.bean.NewsfeedBean;

/**
 * Newsfeed entity. @author MyEclipse Persistence Tools
 */

public class Newsfeed implements java.io.Serializable {

	// Fields

	private int newsid;
	private String newsheader;
	private String newsdesc;
	private Date newsdate;

	// Constructors

	/** default constructor */
	public Newsfeed() {
	}

	/** minimal constructor */
	public Newsfeed(String newsheader, String newsdesc) {
		this.newsheader = newsheader;
		this.newsdesc = newsdesc;
	}

	/** full constructor */
	public Newsfeed(String newsheader, String newsdesc, Date newsdate) {
		this.newsheader = newsheader;
		this.newsdesc = newsdesc;
		this.newsdate = newsdate;
	}

	// Property accessors

	public Newsfeed(NewsfeedBean newsfeedBean) {
		this.newsheader = newsfeedBean.getNewsheader();
		this.newsdesc = newsfeedBean.getNewsdesc();
		this.newsid=newsfeedBean.getNewsid();
		//this.newsdate = new Date(newsfeedBean.getNewsdate());
	}

	public String getNewsheader() {
		return this.newsheader;
	}

	public int getNewsid() {
		return newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public void setNewsheader(String newsheader) {
		this.newsheader = newsheader;
	}

	public String getNewsdesc() {
		return this.newsdesc;
	}

	public void setNewsdesc(String newsdesc) {
		this.newsdesc = newsdesc;
	}

	public Date getNewsdate() {
		return this.newsdate;
	}

	public void setNewsdate(Date newsdate) {
		this.newsdate = newsdate;
	}

}