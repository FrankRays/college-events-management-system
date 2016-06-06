package com.buzz.bean;

// default package

import java.util.Date;

import com.buzz.formbean.NewsFeedFormBean;
import com.buzz.pojo.Newsfeed;
import com.buzz.util.DateWrapper;

/**
 * Newsfeed entity. @author MyEclipse Persistence Tools
 */

public class NewsfeedBean implements java.io.Serializable {

	// Fields

	private int newsid;
	private String newsheader;
	private String newsdesc;
	private String newsdate;

	// Constructors

	/** default constructor */
	public NewsfeedBean() {
	}

	/** minimal constructor */
	public NewsfeedBean(String newsheader, String newsdesc) {
		this.newsheader = newsheader;
		this.newsdesc = newsdesc;
	}

	/** full constructor */
	public NewsfeedBean(String newsheader, String newsdesc, Date newsdate) {
		this.newsheader = newsheader;
		this.newsdesc = newsdesc;
		this.newsdate = DateWrapper.parseDate(newsdate);
	}

	// Property accessors

	public NewsfeedBean(Newsfeed newsfeed) {
		this.newsid = newsfeed.getNewsid();
		this.newsheader = newsfeed.getNewsheader();
		this.newsdesc = newsfeed.getNewsdesc();
		this.newsdate = DateWrapper.parseDate(newsfeed.getNewsdate());
	}

	public NewsfeedBean(NewsFeedFormBean newsFeedFormBean) {
		this.newsheader = newsFeedFormBean.getNewsHeader();
		this.newsdesc = newsFeedFormBean.getNewsDesc();
	}

	public String getNewsheader() {
		return this.newsheader;
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

	public int getNewsid() {
		return newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public String getNewsdate() {
		return newsdate;
	}

	public void setNewsdate(String newsdate) {
		this.newsdate = newsdate;
	}

}