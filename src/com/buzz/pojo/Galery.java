package com.buzz.pojo;

import java.io.File;
import java.sql.Blob;
import java.util.Date;

import com.buzz.bean.GaleryBean;

/**
 * Galery entity. @author MyEclipse Persistence Tools
 */

public class Galery implements java.io.Serializable {

	// Fields

	private int galeryid;
	private Blob galeryfile;
	private byte[] galeryfile1;
	private String faleryfileextension;
	private Date galerydate;
	private byte[] file;
	// Constructors

	/** default constructor */
	public Galery() {
	}

	/** full constructor */
	public Galery(File galeryfile, String faleryfileextension, Date galerydate) {
		//this.galeryfile = galeryfile;
		this.faleryfileextension = faleryfileextension;
		this.galerydate = galerydate;
	}

	// Property accessors

	public Galery(GaleryBean galeryBean) {
		//this.galeryfile = galeryBean.getGaleryfile();
		this.faleryfileextension = galeryBean.getFaleryfileextension();
		this.galeryfile1 = galeryBean.getGaleryfile1();

	}

	public String getFaleryfileextension() {
		return this.faleryfileextension;
	}

	public int getGaleryid() {
		return galeryid;
	}

	public void setGaleryid(int galeryid) {
		this.galeryid = galeryid;
	}

	

	public Blob getGaleryfile() {
		return galeryfile;
	}

	public void setGaleryfile(Blob galeryfile) {
		this.galeryfile = galeryfile;
	}

	public void setFaleryfileextension(String faleryfileextension) {
		this.faleryfileextension = faleryfileextension;
	}

	public Date getGalerydate() {
		return this.galerydate;
	}

	public void setGalerydate(Date galerydate) {
		this.galerydate = galerydate;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public byte[] getGaleryfile1() {
		return galeryfile1;
	}

	public void setGaleryfile1(byte[] galeryfile1) {
		this.galeryfile1 = galeryfile1;
	}

	

	



}