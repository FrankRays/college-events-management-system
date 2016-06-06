package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class TopicFileFormBean extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FormFile FileData;
	private int topicnameid;
	private String topicfilename;

	public FormFile getFileData() {
		return FileData;
	}

	public void setFileData(FormFile fileData) {
		FileData = fileData;
	}

	public int getTopicnameid() {
		return topicnameid;
	}

	public void setTopicnameid(int topicnameid) {
		this.topicnameid = topicnameid;
	}

	public String getTopicfilename() {
		return topicfilename;
	}

	public void setTopicfilename(String topicfilename) {
		this.topicfilename = topicfilename;
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
