package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.TopicfileBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.StudyDetailsFormBean;
import com.buzz.formbean.TopicFileFormBean;
import com.buzz.serviceimpl.StudyDetailsServiceImpl;
import com.buzz.serviceimpl.TopicServiceImpl;

public class TopicFileUpdateByID extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		TopicFileFormBean topicFileFormBean = (TopicFileFormBean) form;
		TopicfileBean TopicFileBean = new TopicfileBean(topicFileFormBean);
		String target = null;
		Vector<TopicfileBean> vTopicFileBeans = null;
		try {
			TopicFileBean.setTopicdataid(Integer.parseInt(request
					.getParameter("topicfileid")));
			boolean flag = new TopicServiceImpl()
					.updateTopicFileByid(TopicFileBean);
			vTopicFileBeans = new TopicServiceImpl().viewTopcicFile();
			if (flag && !vTopicFileBeans.isEmpty()) {
				request.setAttribute("vTopicFileBeans", vTopicFileBeans);
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