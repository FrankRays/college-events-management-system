package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.TopicHeaderBean;
import com.buzz.bean.TopicnameBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.TopicServiceImpl;

public class TopicNameViewById extends Action {
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
		TopicnameBean topicNameBean = null;
		String target = null;
		try {
			topicNameBean = new TopicServiceImpl()
					.viewTopicNamebyId(Integer.parseInt(request
							.getParameter("topicfileid")));
			if (!topicNameBean.equals(null)) {
				request.setAttribute("topicNameBean", topicNameBean);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			target = "failure";
		} catch (Exception e) {
			request.setAttribute("message", "No Topic Name Data");
			target = "failure";
		}
		return mapping.findForward(target);
	}
}