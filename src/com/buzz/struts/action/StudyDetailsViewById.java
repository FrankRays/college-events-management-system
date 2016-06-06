package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.StudydetailsBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.StudyDetailsServiceImpl;

public class StudyDetailsViewById extends Action {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StudydetailsBean studyDetailsBean = null;
		String target = null;
		try {
			studyDetailsBean = new StudyDetailsServiceImpl().viewStudyCenterbyId(Integer
					.parseInt(request.getParameter("studyId")));
			if (!studyDetailsBean.equals(null)) {
				request.setAttribute("studyDetailsBean", studyDetailsBean);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			target = "failure";
		} catch (Exception e) {
			request.setAttribute("message", "No Study Data");
			target = "failure";
		}
		return mapping.findForward(target);
	}
}