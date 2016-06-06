package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;




public class FaqsFormBean extends ValidatorForm {

	public String getFaq() {
		return faq;
	}

	public void setFaq(String faq) {
		this.faq = faq;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getEventidref() {
		return eventidref;
	}

	public void setEventidref(int eventidref) {
		this.eventidref = eventidref;
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

	private String faq;
	private String answer;
	private int eventidref;


}
