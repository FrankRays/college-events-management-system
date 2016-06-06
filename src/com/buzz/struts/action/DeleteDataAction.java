package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.serviceimpl.EventServiceImpl;

public class DeleteDataAction extends Action {
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
		String ch[] = request.getParameterValues("eventid");
		String deletetype = request.getParameter("type");
		boolean flag = false;
		try {
			for (int i = 0; i < ch.length; i++) {
				System.out.println(ch[i]);
				/*flag = new EventServiceImpl().deleteData(Integer
						.parseInt(ch[i]), deletetype);*/
			}
			if (flag) {
				request.setAttribute("message", "Records Deleted");
				return mapping.findForward("success");
			} else {
				request.setAttribute("message", "Records Not Deleted");
				return mapping.findForward("fail");

			}
		} catch (Exception e) {
			request.setAttribute("message", "Records Not Deleted");
			return mapping.findForward("fail");
		}
	}
}
