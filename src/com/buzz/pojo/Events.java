package com.buzz.pojo;

// default package

import java.math.BigDecimal;
import java.util.Date;

import com.buzz.bean.EventsBean;

/**
 * Events entity. @author MyEclipse Persistence Tools
 */

public class Events implements java.io.Serializable {

	// Fields

	private int eventid;
	private String eventname;
	private String eventdesc;
	private String eventoncollege;
	private String eventonaddress;
	private Date eventdate;
	private String eventtime;
	private String url;

	// Constructors

	/** default constructor */
	public Events() {
	}

	/** minimal constructor */
	public Events(String eventname, String eventoncollege, Date eventdate,
			String eventtime) {
		this.eventname = eventname;
		this.eventoncollege = eventoncollege;
		this.eventdate = eventdate;
		this.eventtime = eventtime;
	}

	/** full constructor */
	public Events(String eventname, String eventdesc, String eventoncollege,
			String eventonaddress, Date eventdate, String eventtime, String url) {
		this.eventname = eventname;
		this.eventdesc = eventdesc;
		this.eventoncollege = eventoncollege;
		this.eventonaddress = eventonaddress;
		this.eventdate = eventdate;
		this.eventtime = eventtime;
		this.url = url;
	}

	// Property accessors

	public Events(EventsBean eventsBean) {
		this.eventname = eventsBean.getEventname();
		this.eventdesc = eventsBean.getEventdesc();
		this.eventoncollege = eventsBean.getEventoncollege();
		this.eventonaddress = eventsBean.getEventonaddress();
		this.eventdate = new Date(eventsBean.getEventdate());
		this.eventtime = eventsBean.getEventtime();
		this.url = eventsBean.getUrl();
	}

	public String getEventname() {
		return this.eventname;
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getEventdesc() {
		return this.eventdesc;
	}

	public void setEventdesc(String eventdesc) {
		this.eventdesc = eventdesc;
	}

	public String getEventoncollege() {
		return this.eventoncollege;
	}

	public void setEventoncollege(String eventoncollege) {
		this.eventoncollege = eventoncollege;
	}

	public String getEventonaddress() {
		return this.eventonaddress;
	}

	public void setEventonaddress(String eventonaddress) {
		this.eventonaddress = eventonaddress;
	}

	public Date getEventdate() {
		return this.eventdate;
	}

	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}

	public String getEventtime() {
		return this.eventtime;
	}

	public void setEventtime(String eventtime) {
		this.eventtime = eventtime;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}