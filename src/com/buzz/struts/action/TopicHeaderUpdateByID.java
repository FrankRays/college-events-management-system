package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.TopicHeaderBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.TopicHeaderFormBean;
import com.buzz.serviceimpl.TopicServiceImpl;

public class TopicHeaderUpdateByID extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TopicHeaderFormBean topicHeaderFormBean = (TopicHeaderFormBean) form;
		TopicHeaderBean TopicHeaderBean = new TopicHeaderBean(
				topicHeaderFormBean);
		String target = null;
		Vector<TopicHeaderBean> vTopicHeaderBeans = null;
		try {
			TopicHeaderBean.setTopicheaderid(Integer.parseInt(request
					.getParameter("topicheaderid")));
			boolean flag = new TopicServiceImpl()
					.updateTopicHeaderByid(TopicHeaderBean);
			vTopicHeaderBeans = new TopicServiceImpl().viewTopicHeader();
			if (flag && !vTopicHeaderBeans.isEmpty()) {
				request.setAttribute("vTopicHeaderBeans", vTopicHeaderBeans);
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