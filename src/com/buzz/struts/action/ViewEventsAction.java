package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.BranchBean;
import com.buzz.bean.EventsBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.BranchServiceImpl;
import com.buzz.serviceimpl.EventServiceImpl;

public class ViewEventsAction extends Action {
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
		Vector<EventsBean> vEventsBeans = null;
		String target = null;
		try {
			vEventsBeans = new EventServiceImpl().viewEvents();
			if (!vEventsBeans.isEmpty()) {
				request.setAttribute("vEventsBeans", vEventsBeans);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			target = "failure";
		} catch (Exception e) {
			request.setAttribute("message", "No Event Data");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}