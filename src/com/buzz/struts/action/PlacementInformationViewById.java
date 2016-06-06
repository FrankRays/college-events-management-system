package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.PlacementinformationBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.PlacementInformationServiceImpl;
import com.buzz.serviceimpl.StudyDetailsServiceImpl;

public class PlacementInformationViewById extends Action {
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
		PlacementinformationBean PlacementInformationBean = null;
		String target = null;
		try {
			System.out.println("hai");
			PlacementInformationBean = new PlacementInformationServiceImpl()
					.viewPlacementIformationbyId(Integer.parseInt(request
							.getParameter("placementInfoId")));
			if (!PlacementInformationBean.equals(null)) {
				request.setAttribute("PlacementInformationBean",
						PlacementInformationBean);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			target = "failure";
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("message", "No  Data");
			target = "failure";
		}
		return mapping.findForward(target);
	}
}