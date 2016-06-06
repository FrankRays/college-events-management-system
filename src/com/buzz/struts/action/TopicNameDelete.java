package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.TopicServiceImpl;

public class TopicNameDelete extends Action {
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

		String ch[] = request.getParameterValues("topicheaderid");
		boolean flag = false;
		try {
			for (int i = 0; i < ch.length; i++) {
				flag = new TopicServiceImpl().deleteTopicHeader(Integer
						.parseInt(ch[i]));
			}
			if (flag) {
				request.setAttribute("message",
						"Topic Header Deleted SuccessFully");
				return mapping.findForward("success");
			} else {
				request.setAttribute("message",
						"Topic Header Not Deleted SuccessFully");
				return mapping.findForward("fail");

			}
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			return mapping.findForward("fail");
		} catch (Exception e) {
			request.setAttribute("message",
					"Topic Header Not Deleted SuccessFully");
			return mapping.findForward("fail");
		}
	}

}