package com.buzz.bean;

// default package

import java.math.BigDecimal;
import java.util.Date;

import com.buzz.formbean.TopicFileFormBean;
import com.buzz.pojo.Topicfile;
import com.buzz.util.DateWrapper;

/**
 * Topicfile entity. @author MyEclipse Persistence Tools
 */

public class TopicfileBean implements java.io.Serializable {

	// Fields

	private int topicdataid;
	private int topicnameid;
	private int topicheaderid;
	private TopicnameBean topicname;
	private String filetype;
	private String fileadddate;
	private byte[] filedata;
	private String filepath;
	private byte[] filedata1;
 	private String topicfilename;

	// Constructors

	/** default constructor */
	public TopicfileBean() {
	}

	/** full constructor */
	public TopicfileBean(TopicnameBean topicname, String filedata,
			String filetype, Date fileadddate) {
		this.topicname = topicname;
		// this.filedata = filedata;
		this.filetype = filetype;
		this.fileadddate = DateWrapper.parseDate(fileadddate);
	}

	// Property accessors

	public TopicfileBean(Topicfile topicfile) {
		this.topicdataid = topicfile.getTopicdataid();
		this.topicfilename = topicfile.getTopicfilename();
		this.topicname = new TopicnameBean(topicfile.getTopicname());
		this.filedata1 = topicfile.getFiledata1();
		this.filetype = topicfile.getFiletype();
		try {
			this.filedata = topicfile.getFiledata().getBytes(1,
					(int) topicfile.getFiledata().length());
		} catch (Exception e) {

		}
		this.fileadddate = DateWrapper.parseDate(topicfile.getFileadddate());

	}

	public TopicfileBean(TopicFileFormBean topicFileFormBean) {

	}

	public TopicnameBean getTopicname() {
		return this.topicname;
	}

	public void setTopicname(TopicnameBean topicname) {
		this.topicname = topicname;
	}

	public byte[] getFiledata() {
		return filedata;
	}

	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
	}

	public byte[] getFiledata1() {
		return filedata1;
	}

	public void setFiledata1(byte[] filedata1) {
		this.filedata1 = filedata1;
	}

	public String getFiletype() {
		return this.filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public int getTopicdataid() {
		return topicdataid;
	}

	public void setTopicdataid(int topicdataid) {
		this.topicdataid = topicdataid;
	}

	public String getFileadddate() {
		return fileadddate;
	}

	public void setFileadddate(String fileadddate) {
		this.fileadddate = fileadddate;
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

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getTopicfilename() {
		return topicfilename;
	}

	public void setTopicfilename(String topicfilename) {
		this.topicfilename = topicfilename;
	}

}