package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class StudyDetailsFormBean extends ValidatorForm {
	
	
		private String StudyName;
		private String StudyDesc;
		
		public String getStudyName() {
			return StudyName;
		}
		public void setStudyName(String studyName) {
			StudyName = studyName;
		}
		public String getStudyDesc() {
			return StudyDesc;
		}
		public void setStudyDesc(String studyDesc) {
			StudyDesc = studyDesc;
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
