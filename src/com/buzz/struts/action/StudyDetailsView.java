package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.BranchBean;
import com.buzz.bean.StudydetailsBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.BranchServiceImpl;
import com.buzz.serviceimpl.StudyDetailsServiceImpl;

public class StudyDetailsView extends Action {
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
		Vector<StudydetailsBean> vStudyDetailsBeans = null;
		String target = null;
		try {
			vStudyDetailsBeans = new StudyDetailsServiceImpl()
					.viewStudyCenters();
			if (!vStudyDetailsBeans.isEmpty()) {
				request.setAttribute("vStudyDetailsBeans", vStudyDetailsBeans);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (CommonException e) {
			// message = new ActionMessage(e.getMessage());
			request.setAttribute("message", e.getMessage());
			target = "failure";
		} catch (Exception e) {
			// message = new ActionMessage("Branch Details  Not Inserted");
			request.setAttribute("message", "No Branch Data");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}