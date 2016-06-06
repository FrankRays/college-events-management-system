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

import com.buzz.bean.TopicHeaderBean;
import com.buzz.bean.TopicfileBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.StudyDetailsServiceImpl;
import com.buzz.serviceimpl.TopicServiceImpl;

public class TopicFileView extends Action {
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
		Vector<TopicfileBean> vTopicFileBeans2 = new Vector<TopicfileBean>();
		Vector<TopicfileBean> vTopicFileBeans = null;
		String target = null;
		TopicfileBean topicfileBean1;
		try {
			String serverPath = getServlet().getServletContext().getRealPath(
					"/")
					+ "upload";
			File uploalFolder = new File(serverPath);
			if (!uploalFolder.exists()) {
				uploalFolder.mkdir();
			}

			vTopicFileBeans = new TopicServiceImpl().viewTopcicFile();
			if (!vTopicFileBeans.isEmpty()) {
				Iterator iterator = vTopicFileBeans.iterator();
				// GaleryBean galeryBean;
				for (TopicfileBean topicfileBean : vTopicFileBeans) {
					topicfileBean = (TopicfileBean) iterator.next();
					topicfileBean1 = new TopicfileBean();

					try {
						String filepath = serverPath + "\\"
								+ topicfileBean.getTopicdataid() + "."
								+ topicfileBean.getFiletype();

						topicfileBean1.setTopicdataid(topicfileBean
								.getTopicdataid());
						topicfileBean1.setTopicnameid(topicfileBean
								.getTopicnameid());
						topicfileBean1.setTopicfilename(topicfileBean
								.getTopicfilename());
						topicfileBean1.setTopicname(topicfileBean
								.getTopicname());
						topicfileBean1.setFileadddate(topicfileBean
								.getFileadddate());

						OutputStream fos = new FileOutputStream(filepath);
						System.out.println(filepath);
						fos.write(topicfileBean.getFiledata());
						fos.flush();
						fos.close();
						topicfileBean1.setFilepath(filepath);
						vTopicFileBeans2.add(topicfileBean1);

					} catch (Exception e) {
						System.out.println(e);
					}

				}
				request.setAttribute("vTopicFileBeans", vTopicFileBeans2);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (CommonException e) {
			// message = new ActionMessage(e.getMessage());
			request.setAttribute("message", e.getMessage());
			target = "failure";
		} catch (Exception e) {
			System.out.println("haiiiiii" + e);
			request.setAttribute("message", "No Topic File Data");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}