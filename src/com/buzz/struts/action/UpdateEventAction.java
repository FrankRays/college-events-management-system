package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.buzz.bean.EventsBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.EventFormBean;
import com.buzz.serviceimpl.EventServiceImpl;

public class UpdateEventAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		EventFormBean events = (EventFormBean) form;
		EventsBean eventsBean = new EventsBean(events);
		String target = null;
		Vector<EventsBean> vEventsBeans = null;
		try {
			boolean flag = false;
			eventsBean.setEventid(Integer.parseInt(request
					.getParameter("eventid")));
			flag = new EventServiceImpl().eventUpdatebyid(eventsBean);
			vEventsBeans = new EventServiceImpl().viewEvents();
			if (flag && !vEventsBeans.isEmpty()) {
				request.setAttribute("vBranchBeans", vEventsBeans);
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