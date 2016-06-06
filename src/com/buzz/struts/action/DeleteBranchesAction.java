/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.BranchBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.BranchFormBean;
import com.buzz.serviceimpl.BranchServiceImpl;

/**
 * MyEclipse Struts Creation date: 07-09-2013
 * 
 * XDoclet definition:
 * 
 * @struts.action validate="true"
 */
public class DeleteBranchesAction extends Action {
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
	/*	BranchFormBean branchFormBean = (BranchFormBean) form;
		BranchBean branchBean = new BranchBean(branchFormBean);*/
		String ch[] = request.getParameterValues("branchid");
		boolean flag = false;
		try {
			for (int i = 0; i < ch.length; i++) {
				System.out.println(ch[i]);
				flag = new BranchServiceImpl().deleteBranches(Integer
						.parseInt(ch[i]));
			}
			if (flag) {
				request.setAttribute("message",
						"Branch Record Deleted SuccessFully");
				return mapping.findForward("success");
			} else {
				request.setAttribute("message",
						"Branch Record Not Deleted SuccessFully");
				return mapping.findForward("fail");

			}
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			return mapping.findForward("fail");
		} catch (Exception e) {
			request.setAttribute("message",
					"Branch Record Not Deleted SuccessFully");
			return mapping.findForward("fail");
		}
	}

}