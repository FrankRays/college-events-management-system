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

public class TopicNameAdd extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TopicNameFormBean topicNameFormBean = (TopicNameFormBean) form;
		Vector<TopicHeaderBean> vTopicHeaderBeans = null;
		TopicnameBean topicnameBean = new TopicnameBean(topicNameFormBean);
		try {
			vTopicHeaderBeans = new TopicServiceImpl().viewTopicHeader();

			new TopicServiceImpl().addTopicName(topicnameBean);
			request.setAttribute("message", "Topic Name Added SuccessFully");
			request.setAttribute("vTopicHeaderBeans", vTopicHeaderBeans);
			return mapping.findForward("success");
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			return mapping.findForward("fail");
		} catch (Exception e) {
			request.setAttribute("message", "Topic Name  Not Inserted");
			return mapping.findForward("fail");
		}

	}
}
