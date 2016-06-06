package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LogoutAction extends Action {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.setAttribute("userid", null);
		session.setAttribute("loginid", null);
		session.setAttribute("eventid", null);
		session.setAttribute("logintype", null);
		session.setAttribute("collegename", null);
		session.setAttribute("studentname", null);
		session.setAttribute("branchid", null);
		request.setAttribute("message", "logged out successfully.....");
		session.invalidate();
		return mapping.findForward("success");
	}
}