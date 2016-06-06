package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.NewsfeedBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.NewsFeedFormBean;
import com.buzz.serviceimpl.NewsServiceImpl;

public class UpdateNewsAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		NewsFeedFormBean newsFeedFormBean = (NewsFeedFormBean) form;
		NewsfeedBean newsfeedBean = new NewsfeedBean(newsFeedFormBean);
		String target = null;
		Vector<NewsfeedBean> vNewsfeedBeans = null;
		try {
			newsfeedBean.setNewsid(Integer.parseInt(request
					.getParameter("newsid")));
			boolean flag = new NewsServiceImpl().newsUpdatebyid(newsfeedBean);
			vNewsfeedBeans = new NewsServiceImpl().viewNews();
			if (flag && !vNewsfeedBeans.isEmpty()) {
				request.setAttribute("vNewsfeedBeans", vNewsfeedBeans);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (CommonException e) {
			// message = new ActionMessage(e.getMessage());
			request.setAttribute("message", e.getMessage());
			target = "failure";
		} catch (Exception e) {
			request.setAttribute("message", "Data Not Updated");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}