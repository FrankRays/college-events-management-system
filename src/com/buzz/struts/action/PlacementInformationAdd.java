package com.buzz.struts.action;

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

public class PlacementInformationAdd extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		PlacementInformationFormBean PlacementInformationFormBean = (PlacementInformationFormBean) form;
		PlacementinformationBean PlacementInformationBean = new PlacementinformationBean(
				PlacementInformationFormBean);
		try {
			new PlacementInformationServiceImpl()
					.addPlacementInformation(PlacementInformationBean);
			request.setAttribute("message",
					"PlacementInformation Details Inserted SuccessFully");
			return mapping.findForward("success");
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			return mapping.findForward("fail");
		} catch (Exception e) {
			request.setAttribute("message",
					"PlacementInformation Details  Not Inserted");
			return mapping.findForward("fail");
		}

	}
}
