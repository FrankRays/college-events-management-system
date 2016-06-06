package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class CoachingCenterFormBean extends ValidatorForm {

	private int Studyid;
	private String Coachingcentername;
	private String CoachingAddress;
	private String CoachingContact;
	private String CoachingDesc;


	public int getStudyid() {
		return Studyid;
	}

	public void setStudyid(int studyid) {
		Studyid = studyid;
	}

	public String getCoachingcentername() {
		return Coachingcentername;
	}

	public void setCoachingcentername(String coachingcentername) {
		Coachingcentername = coachingcentername;
	}

	public String getCoachingAddress() {
		return CoachingAddress;
	}

	public void setCoachingAddress(String coachingAddress) {
		CoachingAddress = coachingAddress;
	}

	public String getCoachingContact() {
		return CoachingContact;
	}

	public void setCoachingContact(String coachingContact) {
		CoachingContact = coachingContact;
	}

	


	public String getCoachingDesc() {
		return CoachingDesc;
	}

	public void setCoachingDesc(String coachingDesc) {
		CoachingDesc = coachingDesc;
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
