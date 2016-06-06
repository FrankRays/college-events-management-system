package com.buzz.struts.action;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.buzz.bean.GaleryBean;
import com.buzz.bean.TopicHeaderBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.FileUploadForm;
import com.buzz.formbean.TopicFileFormBean;
import com.buzz.formbean.TopicHeaderFormBean;
import com.buzz.serviceimpl.TopicServiceImpl;

public class TopicHeaderAdd extends Action {
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	private FormFile uploadingfile;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String logicalJspName = FAIL;
		TopicHeaderFormBean topicHeaderFormBean = (TopicHeaderFormBean) form;
		TopicHeaderBean topicHeaderBean = null;
		try {
	

			uploadingfile = topicHeaderFormBean.getTopicImage();
			System.out.println(uploadingfile);
			// 1
			String serverPath = getServlet().getServletContext().getRealPath(
					"/")
					+ "upload";
			// 2
			File uploalFolder = new File(serverPath);
			if (!uploalFolder.exists()) {
				uploalFolder.mkdir();
			}
			// 3
			String fileName = uploadingfile.getFileName();
			// 4
			File newFile = new File(serverPath, fileName);
			// 5

			FileOutputStream fos = new FileOutputStream(newFile);

			// 6
			fos.write(uploadingfile.getFileData());

			// 7

			fos.flush();
			fos.close();

			// 8
			request.setAttribute("downloadLocation", "./upload/" + fileName);
			System.out.println(request.getAttribute("downloadLocation"));
			logicalJspName = SUCCESS;
			 topicHeaderBean = new TopicHeaderBean();
			 topicHeaderBean.setTopicheadername(topicHeaderFormBean.getTopicName());
			topicHeaderBean.setTopicimage1(uploadingfile.getFileData());
			try {
				String[] aString = fileName.split("\\.");
				topicHeaderBean.setFaleryfileextension(aString[1]);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			new TopicServiceImpl().addTopicHeader(topicHeaderBean);
			request.setAttribute("message", "Topic Header Added SuccessFully");
			return mapping.findForward("success");
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			return mapping.findForward("fail");
		} catch (Exception e) {
			request.setAttribute("message", "Topic Header  Not Inserted");
			return mapping.findForward("fail");
		}

	}
}
