package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.CoachingcenterBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.CoachingCenterFormBean;
import com.buzz.formbean.PlacementInformationFormBean;
import com.buzz.serviceimpl.CoachingCenterServiceImpl;
import com.buzz.serviceimpl.PlacementInformationServiceImpl;

public class CoachingCenterUpdateByID extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		CoachingCenterFormBean CoachingCenterFormBean = (CoachingCenterFormBean) form;
		CoachingcenterBean CoachingCenterBean = new CoachingcenterBean(
				CoachingCenterFormBean);
		String target = null;
		Vector<CoachingcenterBean> vCoachingCenterBeans = null;
		try {
			CoachingCenterBean.setCoachingcenterid(Integer.parseInt(request
					.getParameter("coadhingcenterid")));
			boolean flag = new CoachingCenterServiceImpl()
					.updateCoachingCenterIformationByid(CoachingCenterBean);
			vCoachingCenterBeans = new CoachingCenterServiceImpl()
					.viewCoachingCenters();
			if (flag && !vCoachingCenterBeans.isEmpty()) {
				request.setAttribute("vCoachingCenterBeans",
						vCoachingCenterBeans);
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