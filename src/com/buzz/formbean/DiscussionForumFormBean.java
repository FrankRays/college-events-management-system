package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class DiscussionForumFormBean extends ValidatorForm {
	
	public String getDiscussionDesc() {
		return discussionDesc;
	}

	public void setDiscussionDesc(String discussionDesc) {
		this.discussionDesc = discussionDesc;
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

	private String discussionDesc;

}
