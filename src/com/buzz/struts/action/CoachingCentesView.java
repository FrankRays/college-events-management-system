package com.buzz.struts.action;

import java.util.Vector;

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

public class CoachingCentesView extends Action {
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
		Vector<CoachingcenterBean> vCoachingCenterBeans = null;
		String target = null;
		try {System.out.println("haiiiii");
			
		vCoachingCenterBeans = new CoachingCenterServiceImpl()
					.viewCoachingCenters();
			if (!vCoachingCenterBeans.isEmpty()) {
				request.setAttribute("vCoachingCenterBeans", vCoachingCenterBeans);
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