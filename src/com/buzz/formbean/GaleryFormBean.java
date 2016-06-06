package com.buzz.formbean;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

public class GaleryFormBean extends ValidatorForm {

	private FormFile galeryFile;

	public FormFile getGaleryFile() {
		return galeryFile;
	}

	public void setGaleryFile(FormFile galeryFile) {
		this.galeryFile = galeryFile;
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
