package com.buzz.pojo;

// default package

import java.sql.Blob;
import java.util.Date;

import com.buzz.bean.TopicfileBean;
import com.buzz.util.DateWrapper;

/**
 * Topicfile entity. @author MyEclipse Persistence Tools
 */

public class Topicfile implements java.io.Serializable {

	// Fields

	private int topicdataid;
	private Topicname topicname;
	private String filetype;
	private Date fileadddate;
 	private String topicfilename;
	private byte[] file;
	private Blob filedata;
	private byte[] filedata1;

	// Constructors

	/** default constructor */
	public Topicfile() {
	}

	/** full constructor */
	public Topicfile(Topicname topicname, String filedata, String filetype,
			Date fileadddate) {
		this.topicname = topicname;
		// this.filedata = filedata;
		this.filetype = filetype;
		this.fileadddate = fileadddate;
	}

	public Topicfile(Topicname topicname, byte[] filedata1, String filetype,
			Date fileadddate) {
		this.topicname = topicname;
		this.filedata1 = filedata1;
		this.filetype = filetype;
		this.fileadddate = fileadddate;
	}

	// Property accessors

	public Topicfile(TopicfileBean topicFileBean) {
	 this.topicfilename=topicFileBean.getTopicfilename();
		this.topicname = new Topicname(topicFileBean.getTopicnameid());
		this.filetype = topicFileBean.getFiletype();
		this.fileadddate = new Date();
		this.filedata1 = topicFileBean.getFiledata1();

	}

	public Topicname getTopicname() {
		return this.topicname;
	}

	public void setTopicname(Topicname topicname) {
		this.topicname = topicname;
	}

	public int getTopicdataid() {
		return topicdataid;
	}

	public void setTopicdataid(int topicdataid) {
		this.topicdataid = topicdataid;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Blob getFiledata() {
		return filedata;
	}

	public void setFiledata(Blob filedata) {
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

	public Date getFileadddate() {
		return this.fileadddate;
	}

	public void setFileadddate(Date fileadddate) {
		this.fileadddate = fileadddate;
	}

	public String getTopicfilename() {
		return topicfilename;
	}

	public void setTopicfilename(String topicfilename) {
		this.topicfilename = topicfilename;
	}

}