package com.buzz.struts.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
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
import com.buzz.serviceimpl.TopicServiceImpl;

public class ViewBixDataAction extends Action {
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
		Vector<TopicnameBean> vTopicNameBeans = null;
		Vector<TopicHeaderBean> vTopicHeaderBeans = null;
		TopicnameBean topicnameBean = null;
		TopicHeaderBean topicHeaderBean = null;
		String target = null;
		String filepath = "";
		try {
			String serverPath = getServlet().getServletContext().getRealPath(
					"/")
					+ "upload";
			File uploalFolder = new File(serverPath);
			if (!uploalFolder.exists()) {
				uploalFolder.mkdir();
			}

			Map<String, Vector<TopicnameBean>> sortedMap = new HashMap<String, Vector<TopicnameBean>>();

			vTopicHeaderBeans = new TopicServiceImpl().viewTopicHeader();
			if (!vTopicHeaderBeans.isEmpty()) {
				Iterator iterator = vTopicHeaderBeans.iterator();
				while (iterator.hasNext()) {
					Vector<TopicnameBean> vTopicnameBeans2 = new Vector<TopicnameBean>();
					topicHeaderBean = (TopicHeaderBean) iterator.next();
					filepath = serverPath + "\\"
							+ topicHeaderBean.getTopicheaderid() + ".jpg";
					System.out.println(filepath);
					OutputStream fos = new FileOutputStream(filepath);
					fos.write(topicHeaderBean.getTopicimage());
					fos.flush();
					fos.close();
					vTopicNameBeans = new TopicServiceImpl()
							.viewTopicNames(topicHeaderBean.getTopicheaderid());

					if (!vTopicNameBeans.isEmpty()) {
						Iterator iterator1 = vTopicNameBeans.iterator();
						while (iterator1.hasNext()) {
							try {
								topicnameBean = (TopicnameBean) iterator1.next();
								TopicnameBean topicnameBean2 = new TopicnameBean();
								topicnameBean2.setTopicnameid(topicnameBean
										.getTopicnameid());
								topicnameBean2.setTopicheader(topicnameBean
										.getTopicheader());
								topicnameBean2.setTopicname(topicnameBean
										.getTopicname());
								topicnameBean2.setTopicdate(topicnameBean
										.getTopicdate());
								topicnameBean2.setTopicdate(topicnameBean
										.getTopicdate());
								topicnameBean2.setTopicfilepath(filepath);
								vTopicnameBeans2.add(topicnameBean2);
							} catch (Exception e) {
		System.out.println(e);
							}

						}
						sortedMap.put(topicHeaderBean.getTopicheadername(),
								vTopicnameBeans2);
					}
				}

				request.setAttribute("sortedMap", sortedMap);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (CommonException e) {

			request.setAttribute("message", e.getMessage());
			target = "failure";
		} catch (Exception e) {
			System.out.println(e);
			request.setAttribute("message", "No Topic File Data");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}