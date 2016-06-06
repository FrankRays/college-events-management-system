package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class NewsFeedFormBean extends ValidatorForm {

	public String getNewsHeader() {
		return newsHeader;
	}

	public void setNewsHeader(String newsHeader) {
		this.newsHeader = newsHeader;
	}

	public String getNewsDesc() {
		return newsDesc;
	}

	public void setNewsDesc(String newsDesc) {
		this.newsDesc = newsDesc;
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

	private String newsHeader;
	private String newsDesc;

}
