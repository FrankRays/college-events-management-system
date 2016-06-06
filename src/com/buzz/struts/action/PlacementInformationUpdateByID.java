package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.PlacementinformationBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.PlacementInformationFormBean;
import com.buzz.formbean.StudyDetailsFormBean;
import com.buzz.serviceimpl.PlacementInformationServiceImpl;
import com.buzz.serviceimpl.StudyDetailsServiceImpl;

public class PlacementInformationUpdateByID extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		PlacementInformationFormBean PlacementInformationFormBean = (PlacementInformationFormBean) form;
		PlacementinformationBean PlacementInformationBean = new PlacementinformationBean(
				PlacementInformationFormBean);
		String target = null;
		Vector<PlacementinformationBean> vStudyDetailsBeans = null;
		try {
			PlacementInformationBean.setPlacementinfoid(Integer
					.parseInt(request.getParameter("placementInfoId")));
			boolean flag = new PlacementInformationServiceImpl()
					.updatePlacementIformationByid(PlacementInformationBean);
			vStudyDetailsBeans = new PlacementInformationServiceImpl()
					.viewPlacementIformation();
			if (flag && !vStudyDetailsBeans.isEmpty()) {
				request.setAttribute("vStudyDetailsBeans", vStudyDetailsBeans);
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