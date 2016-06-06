package com.buzz.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.BranchBean;
import com.buzz.bean.CoachingcenterBean;

import com.buzz.exception.CommonException;
import com.buzz.formbean.BranchFormBean;
import com.buzz.formbean.CoachingCenterFormBean;
import com.buzz.formbean.PlacementInformationFormBean;
import com.buzz.serviceimpl.BranchServiceImpl;
import com.buzz.serviceimpl.CoachingCenterServiceImpl;
import com.buzz.serviceimpl.PlacementInformationServiceImpl;

public class CoachingCenterAdd extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CoachingCenterFormBean CoachingCenterFormBean = (CoachingCenterFormBean) form;
		CoachingcenterBean CoachingCenterBean = new CoachingcenterBean(
				CoachingCenterFormBean);
		System.out.println(CoachingCenterBean.getStudyid());
		try {
			new CoachingCenterServiceImpl()
					.addCoachingCenter(CoachingCenterBean);
			request.setAttribute("message",
					"CoachingCenter Details Inserted SuccessFully");
			return mapping.findForward("success");
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			return mapping.findForward("fail");
		} catch (Exception e) {
			request.setAttribute("message",
					"CoachingCenter Details  Not Inserted");
			return mapping.findForward("fail");
		}

	}
}
