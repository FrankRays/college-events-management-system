package com.buzz.bean;

// default package

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.buzz.formbean.TopicHeaderFormBean;
import com.buzz.pojo.Topicheader;
import com.buzz.pojo.Topicname;
import com.buzz.util.DateWrapper;

/**
 * Topicheader entity. @author MyEclipse Persistence Tools
 */

public class TopicHeaderBean implements java.io.Serializable {

	// Fields

	private int topicheaderid;
	private String topicheadername;
	private byte[] topicimage;
	private String topicdate;
	private byte[] topicimage1;
	private String filepath;
	private String faleryfileextension;
	private Set topicnames = new HashSet(0);

	// Constructors

	/** default constructor */
	public TopicHeaderBean() {
	}

	/** minimal constructor */
	public TopicHeaderBean(String topicheadername, Date topicdate) {
		this.topicheadername = topicheadername;
		this.topicdate = DateWrapper.parseDate(topicdate);
	}

	/** full constructor */
	public TopicHeaderBean(String topicheadername, String topicimage,
			Date topicdate, Set topicnames) {
		this.topicheadername = topicheadername;
		// this.topicimage = topicimage;
		this.topicdate = DateWrapper.parseDate(topicdate);
		this.topicnames = topicnames;
	}

	public TopicHeaderBean(Topicheader topicheader) {
		this.topicheaderid = topicheader.getTopicheaderid();
		this.topicheadername = topicheader.getTopicheadername();
		this.topicimage1 = topicheader.getTopicimage1();

		try {
			this.topicimage = topicheader.getTopicimage().getBytes(1,
					(int) topicheader.getTopicimage().length());
		} catch (Exception e) {

		}

		this.topicdate = DateWrapper.parseDate(topicheader.getTopicdate());
	}

	public TopicHeaderBean(TopicHeaderFormBean topicHeaderFormBean) {

	}

	// Property accessors

	public TopicHeaderBean(int topicnameid) {
		this.topicheaderid = topicnameid;
	}

	public TopicHeaderBean(Topicname topicname2) {
		this.topicheaderid = topicname2.getTopicheader().getTopicheaderid();
		this.topicheadername = topicname2.getTopicheader().getTopicheadername();
		this.topicimage1 = topicname2.getTopicheader().getTopicimage1();

		try {
			this.topicimage = topicname2.getTopicheader().getTopicimage()
					.getBytes(
							1,
							(int) topicname2.getTopicheader().getTopicimage()
									.length());
		} catch (Exception e) {

		}

		this.topicdate = DateWrapper.parseDate(topicname2.getTopicheader()
				.getTopicdate());
	}

	public String getTopicheadername() {
		return this.topicheadername;
	}

	public void setTopicheadername(String topicheadername) {
		this.topicheadername = topicheadername;
	}

	public Set getTopicnames() {
		return this.topicnames;
	}

	public void setTopicnames(Set topicnames) {
		this.topicnames = topicnames;
	}

	public int getTopicheaderid() {
		return topicheaderid;
	}

	public void setTopicheaderid(int topicheaderid) {
		this.topicheaderid = topicheaderid;
	}

	public String getTopicdate() {
		return topicdate;
	}

	public void setTopicdate(String topicdate) {
		this.topicdate = topicdate;
	}

	public byte[] getTopicimage() {
		return topicimage;
	}

	public void setTopicimage(byte[] topicimage) {
		this.topicimage = topicimage;
	}

	public byte[] getTopicimage1() {
		return topicimage1;
	}

	public void setTopicimage1(byte[] topicimage1) {
		this.topicimage1 = topicimage1;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFaleryfileextension() {
		return faleryfileextension;
	}

	public void setFaleryfileextension(String faleryfileextension) {
		this.faleryfileextension = faleryfileextension;
	}

}