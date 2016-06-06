package com.buzz.bean;

// default package

import java.math.BigDecimal;
import java.util.Date;

import com.buzz.formbean.EventFormBean;
import com.buzz.pojo.Events;
import com.buzz.util.DateWrapper;

/**
 * Events entity. @author MyEclipse Persistence Tools
 */

public class EventsBean implements java.io.Serializable {

	// Fields

	private int eventid;
	private String eventname;
	private String eventdesc;
	private String eventoncollege;
	private String eventonaddress;
	private String eventdate;
	private String eventtime;
	private String url;

	// Constructors

	/** default constructor */
	public EventsBean() {
	}

	/** minimal constructor */
	public EventsBean(String eventname, String eventoncollege, Date eventdate,
			String eventtime) {
		this.eventname = eventname;
		this.eventoncollege = eventoncollege;
		this.eventdate = DateWrapper.parseDate(eventdate);
		this.eventtime = eventtime;
	}

	/** full constructor */
	public EventsBean(String eventname, String eventdesc,
			String eventoncollege, String eventonaddress, Date eventdate,
			String eventtime, String url) {
		this.eventname = eventname;
		this.eventdesc = eventdesc;
		this.eventoncollege = eventoncollege;
		this.eventonaddress = eventonaddress;
		this.eventdate = DateWrapper.parseDate(eventdate);
		this.eventtime = eventtime;
		this.url = url;
	}

	public EventsBean(Events events) {
		this.eventid = events.getEventid();
		this.eventname = events.getEventname();
		this.eventdesc = events.getEventdesc();
		this.eventoncollege = events.getEventoncollege();
		this.eventonaddress = events.getEventonaddress();
		this.eventdate = DateWrapper.parseDate(events.getEventdate());
		this.eventtime = events.getEventtime();
		this.url = events.getUrl();

	}

	public EventsBean(EventFormBean eventFormBean) {

		this.eventname = eventFormBean.getEventName();
		this.eventdesc = eventFormBean.getEventDesc();
		this.eventoncollege = eventFormBean.getEventOnCollege();
		this.eventonaddress = eventFormBean.getEventOnAddresses();
		this.eventdate = eventFormBean.getEventDate();
		this.eventtime = eventFormBean.getEventTime();
		this.url = eventFormBean.getuRL();
	}

	// Property accessors

	public String getEventname() {
		return this.eventname;
	}

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public void setEventdate(String eventdate) {
		this.eventdate = eventdate;
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

	public String getEventdate() {
		return eventdate;
	}

}