package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class EventFormBean extends ValidatorForm {

	private String EventName;
	private String EventDesc;
	private String EventOnCollege;
	private String EventOnAddresses;
	private String EventDate;
	private String EventTime;
	private String uRL;

	public String getEventName() {
		return EventName;
	}

	public void setEventName(String eventName) {
		EventName = eventName;
	}

	public String getEventDesc() {
		return EventDesc;
	}

	public void setEventDesc(String eventDesc) {
		EventDesc = eventDesc;
	}

	public String getEventOnCollege() {
		return EventOnCollege;
	}

	public void setEventOnCollege(String eventOnCollege) {
		EventOnCollege = eventOnCollege;
	}

	public String getEventOnAddresses() {
		return EventOnAddresses;
	}

	public void setEventOnAddresses(String eventOnAddresses) {
		EventOnAddresses = eventOnAddresses;
	}

	public String getEventDate() {
		return EventDate;
	}

	public void setEventDate(String eventDate) {
		EventDate = eventDate;
	}

	public String getEventTime() {
		return EventTime;
	}

	public void setEventTime(String eventTime) {
		EventTime = eventTime;
	}

	

	public String getuRL() {
		return uRL;
	}

	public void setuRL(String uRL) {
		this.uRL = uRL;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.validate(mapping, request);
	}
}
