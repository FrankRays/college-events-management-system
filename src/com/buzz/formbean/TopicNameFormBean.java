package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class TopicNameFormBean extends ValidatorForm {

	
	private String TopicName;
	private int topicheaderid;

	

	

	public String getTopicName() {
		return TopicName;
	}

	public void setTopicName(String topicName) {
		TopicName = topicName;
	}

	

	public int getTopicheaderid() {
		return topicheaderid;
	}

	public void setTopicheaderid(int topicheaderid) {
		this.topicheaderid = topicheaderid;
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
