package com.buzz.formbean;

import org.apache.struts.validator.ValidatorForm;

// default package

/**
 * StudentDetails entity. @author MyEclipse Persistence Tools
 */

public class StudentDetailsformBean extends ValidatorForm {

	// Fields

	private int studentBranchidref;

	private String studentname;
	private String studentyear;

	// Constructors

	/** default constructor */
	public StudentDetailsformBean() {
	}

	public int getStudentBranchidref() {
		return studentBranchidref;
	}

	public void setStudentBranchidref(int studentBranchidref) {
		this.studentBranchidref = studentBranchidref;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentyear() {
		return studentyear;
	}

	public void setStudentyear(String studentyear) {
		this.studentyear = studentyear;
	}

}