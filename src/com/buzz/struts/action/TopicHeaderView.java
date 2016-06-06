package com.buzz.struts.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.GaleryBean;
import com.buzz.bean.TopicHeaderBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.TopicServiceImpl;

public class TopicHeaderView extends Action {
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
		Vector<TopicHeaderBean> vTopicHeaderBeans = null;
		Vector<TopicHeaderBean> vTopicHeaderBeans2 = new Vector<TopicHeaderBean>();
		TopicHeaderBean topicHeaderBean1;
		String target = null;
		try {
			String serverPath = getServlet().getServletContext().getRealPath(
					"/")
					+ "upload";
			File uploalFolder = new File(serverPath);
			if (!uploalFolder.exists()) {
				uploalFolder.mkdir();
			}

			vTopicHeaderBeans = new TopicServiceImpl().viewTopicHeader();
			if (!vTopicHeaderBeans.isEmpty()) {
				Iterator iterator = vTopicHeaderBeans.iterator();
				// GaleryBean galeryBean;
				for (TopicHeaderBean topicHeaderBean : vTopicHeaderBeans) {
					topicHeaderBean = (TopicHeaderBean) iterator.next();
					topicHeaderBean1 = new TopicHeaderBean();

					try {
						String filepath = serverPath + "\\"
								+ topicHeaderBean.getTopicheaderid() + ".jpg";
						OutputStream fos = new FileOutputStream(filepath);
						fos.write(topicHeaderBean.getTopicimage());
						fos.flush();
						fos.close();
						topicHeaderBean1.setTopicheaderid(topicHeaderBean
								.getTopicheaderid());
						topicHeaderBean1.setTopicheadername(topicHeaderBean
								.getTopicheadername());
						topicHeaderBean1.setTopicdate(topicHeaderBean
								.getTopicdate());
						topicHeaderBean1.setFilepath(filepath);
						vTopicHeaderBeans2.add(topicHeaderBean1);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}

				request.setAttribute("vTopicHeaderBeans", vTopicHeaderBeans2);
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
			request.setAttribute("message", "No Topic File Data");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}