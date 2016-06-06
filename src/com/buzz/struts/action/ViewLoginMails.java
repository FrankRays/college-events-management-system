package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.LogindetailsBean;
import com.buzz.bean.NewsfeedBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.NewsServiceImpl;
import com.buzz.serviceimpl.SecurityServiceImpl;

public class ViewLoginMails extends Action {
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
		Vector<LogindetailsBean> vLogindetailsBeans = null;
		String target = null;
		try {
			vLogindetailsBeans = new SecurityServiceImpl().viewMailIDs();
			if (!vLogindetailsBeans.isEmpty()) {
				request.setAttribute("vLogindetailsBeans", vLogindetailsBeans);
				target = "success";
			} else {
				target = "failure";
			}
		}  catch (Exception e) {
			// message = new ActionMessage("Branch Details  Not Inserted");
			request.setAttribute("message", "Error");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}
