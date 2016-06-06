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

import com.buzz.bean.FaqsBean;
import com.buzz.bean.GaleryBean;
import com.buzz.exception.CommonException;
import com.buzz.serviceimpl.FaqSerivceImpl;
import com.buzz.serviceimpl.GalleryServiceImpl;

public class ViewGaleryAction extends Action {
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
		Vector<GaleryBean> vGaleryBeans = null;
		Vector<GaleryBean> vGaleryBeans2=new Vector<GaleryBean>();
		String target = null;
		try {
			String serverPath = getServlet().getServletContext().getRealPath(
			"/")
			+ "upload";
			File uploalFolder = new File(serverPath);
			if (!uploalFolder.exists()) {
				uploalFolder.mkdir();
			}
	
			vGaleryBeans = new GalleryServiceImpl().viewGalery();
			GaleryBean galeryBean2;
			if (!vGaleryBeans.isEmpty()) {
				Iterator iterator = vGaleryBeans.iterator();
				// GaleryBean galeryBean;
				for (GaleryBean galeryBean : vGaleryBeans) {
					galeryBean = (GaleryBean) iterator.next();
							galeryBean2=new GaleryBean();		
					
					try{String filepath = serverPath+"\\"+galeryBean.getGaleryid()+"."+galeryBean.getFaleryfileextension();
					OutputStream fos = new FileOutputStream(filepath);
					fos.write(galeryBean.getGaleryfile());
					fos.flush();
					fos.close();
					galeryBean2.setGalerydate(galeryBean.getGalerydate());
					galeryBean2.setFilepath(filepath);
					System.out.println(filepath);
					vGaleryBeans2.add(galeryBean2);
					System.out.println(galeryBean.getFaleryfileextension());
					}catch (Exception e) {
						// TODO: handle exception
					}
				}

				request.setAttribute("vGaleryBeans", vGaleryBeans2);
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
			request.setAttribute("message", "No News Data");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}
