package com.buzz.bean;

// default package

import java.io.File;
import java.util.Date;

import com.buzz.pojo.Galery;
import com.buzz.util.DateWrapper;

/**
 * Galery entity. @author MyEclipse Persistence Tools
 */

public class GaleryBean implements java.io.Serializable {

	// Fields

	private int galeryid;
	private String faleryfileextension;
	private byte[] galeryfile;
	private byte[] galeryfile1;
	private String galerydate;
	private String filepath;


	// Constructors

	/** default constructor */
	public GaleryBean() {
	}

	/** full constructor */
	public GaleryBean(File galeryfile, String faleryfileextension,
			Date galerydate) {
		//this.galeryfile = galeryfile;
		this.faleryfileextension = faleryfileextension;
		//this.galerydate = galerydate;
	}

	// Property accessors

	public GaleryBean(Galery galery) {
		this.galeryid = galery.getGaleryid();
		try{this.galeryfile =galery.getGaleryfile().getBytes(1, (int) galery.getGaleryfile().length());
		}catch (Exception e) {
			System.out.println("public GaleryBean(Galery galery-------------"+e);
		}this.faleryfileextension = galery.getFaleryfileextension();
		this.galerydate =DateWrapper.parseDate(galery.getGalerydate());
	}

	public int getGaleryid() {
		return galeryid;
	}


	public byte[] getGaleryfile() {
		return galeryfile;
	}

	public void setGaleryfile(byte[] galeryfile) {
		this.galeryfile = galeryfile;
	}

	public void setGaleryid(int galeryid) {
		this.galeryid = galeryid;
	}

	public String getFaleryfileextension() {
		return this.faleryfileextension;
	}

	public void setFaleryfileextension(String faleryfileextension) {
		this.faleryfileextension = faleryfileextension;
	}

	

	public String getGalerydate() {
		return galerydate;
	}

	public void setGalerydate(String galerydate) {
		this.galerydate = galerydate;
	}

	public byte[] getGaleryfile1() {
		return galeryfile1;
	}

	public void setGaleryfile1(byte[] galeryfile1) {
		this.galeryfile1 = galeryfile1;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
}