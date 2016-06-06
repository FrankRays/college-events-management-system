package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.BranchBean;
import com.buzz.bean.NewsfeedBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.BranchServiceImpl;
import com.buzz.serviceimpl.NewsServiceImpl;

public class ViewNewsByidAction extends Action {
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
		NewsfeedBean newsfeedBean = null;
		String target = null;
		try {
			newsfeedBean = new NewsServiceImpl().viewNewsbyId(Integer
					.parseInt(request.getParameter("newsid")));
			if (!newsfeedBean.equals(null)) {
				request.setAttribute("newsfeedBean", newsfeedBean);
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
			request.setAttribute("message", "No News Data");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}