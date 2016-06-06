package com.buzz.pojo;

// default package

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.buzz.bean.TopicnameBean;

/**
 * Topicname entity. @author MyEclipse Persistence Tools
 */

public class Topicname implements java.io.Serializable {

	// Fields

	private int topicnameid;
	private Topicheader topicheader;
	private String topicname;
	private Date topicdate;
	private Set topicfiles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Topicname() {
	}

	/** full constructor */
	public Topicname(Topicheader topicheader, String topicname, Date topicdate,
			Set topicfiles) {
		this.topicheader = topicheader;
		this.topicname = topicname;
		this.topicdate = topicdate;
		this.topicfiles = topicfiles;
	}

	// Property accessors

	public Topicname(TopicnameBean topicnameBean) {
		this.topicheader = new Topicheader(topicnameBean.getTopicheaderid());
		this.topicname = topicnameBean.getTopicname();
	}

	public Topicname(int topicdataid) {
		this.topicnameid=topicdataid;
	}

	public Topicheader getTopicheader() {
		return this.topicheader;
	}

	public int getTopicnameid() {
		return topicnameid;
	}

	public void setTopicnameid(int topicnameid) {
		this.topicnameid = topicnameid;
	}

	public void setTopicheader(Topicheader topicheader) {
		this.topicheader = topicheader;
	}

	public String getTopicname() {
		return this.topicname;
	}

	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}

	public Date getTopicdate() {
		return this.topicdate;
	}

	public void setTopicdate(Date topicdate) {
		this.topicdate = topicdate;
	}

	public Set getTopicfiles() {
		return this.topicfiles;
	}

	public void setTopicfiles(Set topicfiles) {
		this.topicfiles = topicfiles;
	}

}