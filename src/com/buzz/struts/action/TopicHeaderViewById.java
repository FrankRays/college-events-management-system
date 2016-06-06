package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.buzz.bean.TopicHeaderBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.TopicServiceImpl;

public class TopicHeaderViewById extends Action {
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
		TopicHeaderBean topicHeaderBean = null;
		String target = null;
		try {
			topicHeaderBean = new TopicServiceImpl()
					.viewTopicHeaderbyId(Integer.parseInt(request
							.getParameter("topicfileid")));
			if (!topicHeaderBean.equals(null)) {
				request.setAttribute("topicHeaderBean", topicHeaderBean);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			target = "failure";
		} catch (Exception e) {
			request.setAttribute("message", "No Topic Header Data");
			target = "failure";
		}
		return mapping.findForward(target);
	}
}