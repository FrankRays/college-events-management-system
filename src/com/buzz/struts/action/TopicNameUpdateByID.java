package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.TopicHeaderBean;
import com.buzz.bean.TopicnameBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.TopicHeaderFormBean;
import com.buzz.formbean.TopicNameFormBean;
import com.buzz.serviceimpl.TopicServiceImpl;

public class TopicNameUpdateByID extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TopicNameFormBean topicNameFormBean = (TopicNameFormBean) form;
		TopicnameBean TopicNameBean = new TopicnameBean(topicNameFormBean);
		String target = null;
		Vector<TopicnameBean> vTopicNameBeans = null;
		try {
			TopicNameBean.setTopicnameid(Integer.parseInt(request
					.getParameter("topicNameid")));
			boolean flag = new TopicServiceImpl()
					.updateTopicNameByid(TopicNameBean);
			vTopicNameBeans = new TopicServiceImpl().viewTopicNames();
			if (flag && !vTopicNameBeans.isEmpty()) {
				request.setAttribute("vTopicNameBeans", vTopicNameBeans);
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