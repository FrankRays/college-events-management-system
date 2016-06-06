package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class ParticipantStudentDetailsFormBean extends ValidatorForm {

	public int getStudentBranchidref() {
		return studentBranchidref;
	}

	public void setStudentBranchidref(int studentBranchidref) {
		this.studentBranchidref = studentBranchidref;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}



	public String getBranchyear() {
		return branchyear;
	}

	public void setBranchyear(String branchyear) {
		this.branchyear = branchyear;
	}

	public String getStudentCollege() {
		return studentCollege;
	}

	public void setStudentCollege(String studentCollege) {
		this.studentCollege = studentCollege;
	}

	public String getCollegeaddress() {
		return collegeaddress;
	}

	public void setCollegeaddress(String collegeaddress) {
		this.collegeaddress = collegeaddress;
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

	private int studentBranchidref;
	private String studentName;
	private String branchyear;
	private String studentCollege;
	private String collegeaddress;

}
