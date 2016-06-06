package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class TopicHeaderFormBean extends ValidatorForm {


	private String TopicName;
	private FormFile TopicImage;



	public String getTopicName() {
		return TopicName;
	}

	public void setTopicName(String topicName) {
		TopicName = topicName;
	}

	public FormFile getTopicImage() {
		return TopicImage;
	}

	public void setTopicImage(FormFile topicImage) {
		TopicImage = topicImage;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		super.reset(mapping, request);
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		return super.validate(mapping, request);
	}

}
