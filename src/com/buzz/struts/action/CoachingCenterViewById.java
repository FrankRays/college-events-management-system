package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.CoachingcenterBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.CoachingCenterServiceImpl;
import com.buzz.serviceimpl.PlacementInformationServiceImpl;

public class CoachingCenterViewById extends Action {
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
		CoachingcenterBean CoachingCenterBean = null;
		String target = null;
		try {
			CoachingCenterBean = new CoachingCenterServiceImpl()
					.viewCoachingCenterbyId(Integer.parseInt(request
							.getParameter("coachingcenterid")));
			if (!CoachingCenterBean.equals(null)) {
				request.setAttribute("CoachingCenterBean", CoachingCenterBean);
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
			request.setAttribute("message", "No  Data");
			target = "failure";
		}
		return mapping.findForward(target);
	}
}