package com.buzz.pojo;

// default package

import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.buzz.bean.TopicHeaderBean;

/**
 * Topicheader entity. @author MyEclipse Persistence Tools
 */

public class Topicheader implements java.io.Serializable {

	// Fields

	private int topicheaderid;
	private String topicheadername;
	private Date topicdate;
	private Set topicnames = new HashSet(0);

	private byte[] file;
	private Blob topicimage;
	private byte[] topicimage1;

	// Constructors

	/** default constructor */
	public Topicheader() {
	}

	/** minimal constructor */
	public Topicheader(String topicheadername, Date topicdate) {
		this.topicheadername = topicheadername;
		this.topicdate = topicdate;
	}

	/** full constructor */

	/** full constructor */
	public Topicheader(String topicname, String topicimage, Date topicdate,
			Set topicnames) {
		this.topicheadername = topicname;
		this.topicimage1 = topicimage1;
		this.topicdate = topicdate;
		this.topicnames = topicnames;
	}

	// Property accessors

	public Topicheader(int topicHeadID) {
		this.topicheaderid = topicHeadID;
	}

	public Topicheader(TopicHeaderBean topicHeaderBean) {
		//this.topicheaderid = topicHeaderBean.getTopicheaderid();
		this.topicheadername = topicHeaderBean.getTopicheadername();
		this.topicimage1 = topicHeaderBean.getTopicimage1();

	}

	// Property accessors

	public String getTopicheadername() {
		return this.topicheadername;
	}

	public int getTopicheaderid() {
		return topicheaderid;
	}

	public void setTopicheaderid(int topicheaderid) {
		this.topicheaderid = topicheaderid;
	}

	public void setTopicheadername(String topicheadername) {
		this.topicheadername = topicheadername;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Blob getTopicimage() {
		return topicimage;
	}

	public void setTopicimage(Blob topicimage) {
		this.topicimage = topicimage;
	}

	public byte[] getTopicimage1() {
		return topicimage1;
	}

	public void setTopicimage1(byte[] topicimage1) {
		this.topicimage1 = topicimage1;
	}

	public Date getTopicdate() {
		return this.topicdate;
	}

	public void setTopicdate(Date topicdate) {
		this.topicdate = topicdate;
	}

	public Set getTopicnames() {
		return this.topicnames;
	}

	public void setTopicnames(Set topicnames) {
		this.topicnames = topicnames;
	}

}