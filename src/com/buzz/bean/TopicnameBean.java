package com.buzz.bean;

// default package

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.buzz.formbean.TopicNameFormBean;
import com.buzz.pojo.Topicheader;
import com.buzz.pojo.Topicname;
import com.buzz.util.DateWrapper;

/**
 * Topicname entity. @author MyEclipse Persistence Tools
 */

public class TopicnameBean implements java.io.Serializable {

	// Fields

	private int topicnameid;
	private int topicheaderid;
	private TopicHeaderBean topicheader;
	private String topicname;
	private String topicfilepath;
	private String topicdate;
	private Set topicfiles = new HashSet(0);

	// Constructors

	/** default constructor */
	public TopicnameBean() {
	}

	/** full constructor */
	public TopicnameBean(TopicHeaderBean topicheader, String topicname,
			Date topicdate, Set topicfiles) {
		this.topicheader = topicheader;
		this.topicname = topicname;
		this.topicdate = DateWrapper.parseDate(topicdate);
		this.topicfiles = topicfiles;
	}

	// Property accessors

	public TopicnameBean(Topicname topicname2) {
		this.topicnameid = topicname2.getTopicnameid();
		this.topicheader = new TopicHeaderBean(topicname2);
		this.topicname = topicname2.getTopicname();
		this.topicdate = DateWrapper.parseDate(topicname2.getTopicdate());
	}

	public TopicnameBean(TopicNameFormBean topicNameFormBean) {
		this.topicname = topicNameFormBean.getTopicName();
		this.topicheaderid = topicNameFormBean.getTopicheaderid();
	}

	public TopicHeaderBean getTopicheader() {
		return this.topicheader;
	}

	public void setTopicheader(TopicHeaderBean topicheader) {
		this.topicheader = topicheader;
	}

	public String getTopicname() {
		return this.topicname;
	}

	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}

	public String getTopicdate() {
		return topicdate;
	}

	public void setTopicdate(String topicdate) {
		this.topicdate = topicdate;
	}

	public Set getTopicfiles() {
		return this.topicfiles;
	}

	public void setTopicfiles(Set topicfiles) {
		this.topicfiles = topicfiles;
	}

	public int getTopicnameid() {
		return topicnameid;
	}

	public void setTopicnameid(int topicnameid) {
		this.topicnameid = topicnameid;
	}

	public int getTopicheaderid() {
		return topicheaderid;
	}

	public void setTopicheaderid(int topicheaderid) {
		this.topicheaderid = topicheaderid;
	}

	public String getTopicfilepath() {
		return topicfilepath;
	}

	public void setTopicfilepath(String topicfilepath) {
		this.topicfilepath = topicfilepath;
	}

}