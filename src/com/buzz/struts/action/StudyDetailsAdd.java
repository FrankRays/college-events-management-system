package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.StudydetailsBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.StudyDetailsFormBean;
import com.buzz.serviceimpl.StudyDetailsServiceImpl;

public class StudyDetailsAdd extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StudyDetailsFormBean studyDetailsFormBean = (StudyDetailsFormBean) form;
		StudydetailsBean studyDetailsBean = new StudydetailsBean(
				studyDetailsFormBean);
		try {
			new StudyDetailsServiceImpl().addStudyCenter(studyDetailsBean);
			request.setAttribute("message",
					"Study Details Inserted SuccessFully");
			return mapping.findForward("success");
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			return mapping.findForward("fail");
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("message", "Study Details  Not Inserted");
			return mapping.findForward("fail");
		}

	}
}
