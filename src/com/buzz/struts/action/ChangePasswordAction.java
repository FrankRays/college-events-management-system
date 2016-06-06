package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.buzz.bean.LogindetailsBean;
import com.buzz.serviceimpl.SecurityServiceImpl;

public class ChangePasswordAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		LogindetailsBean logindetailsBean = new LogindetailsBean();
		String target = null;
		HttpSession session = request.getSession();
		try {
			logindetailsBean.setLoginid((String) session
					.getAttribute("loginid"));
			logindetailsBean
					.setUserid((Integer) session.getAttribute("userid"));
			logindetailsBean.setLoginid(request.getParameter("loginid"));
			logindetailsBean.setPassword(request.getParameter("password"));
			logindetailsBean.setChangepassword(request
					.getParameter("changepassword"));

			boolean flag = new SecurityServiceImpl()
					.changePassword(logindetailsBean);

			if (flag) {
				target = "success";
			} else {
				target = "failure";
			}
		} catch (Exception e) {
			request.setAttribute("message", "Password Not Updated");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}