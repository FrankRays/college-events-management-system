package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class ParticipationStudentEventRegFormBean extends ValidatorForm {
	private int useridref;

	public int getUseridref() {
		return useridref;
	}

	public void setUseridref(int useridref) {
		this.useridref = useridref;
	}

	public int getStudentEventidref() {
		return studentEventidref;
	}

	public void setStudentEventidref(int studentEventidref) {
		this.studentEventidref = studentEventidref;
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

	private int studentEventidref;

}
