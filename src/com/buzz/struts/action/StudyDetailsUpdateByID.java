package com.buzz.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.buzz.bean.BranchBean;
import com.buzz.bean.StudydetailsBean;
import com.buzz.exception.CommonException;
import com.buzz.formbean.BranchFormBean;
import com.buzz.formbean.StudyDetailsFormBean;
import com.buzz.serviceimpl.BranchServiceImpl;
import com.buzz.serviceimpl.StudyDetailsServiceImpl;

public class StudyDetailsUpdateByID extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		StudyDetailsFormBean studyDetailsFormBean = (StudyDetailsFormBean) form;
		StudydetailsBean studyDetailsBean = new StudydetailsBean(
				studyDetailsFormBean);
		String target = null;
		Vector<StudydetailsBean> vStudyDetailsBeans = null;
		try {
			studyDetailsBean.setStudyid(Integer.parseInt(request
					.getParameter("studyId")));
			boolean flag = new StudyDetailsServiceImpl()
					.updateStudyCenterByid(studyDetailsBean);
			vStudyDetailsBeans = new StudyDetailsServiceImpl()
					.viewStudyCenters();
			if (flag && !vStudyDetailsBeans.isEmpty()) {
				request.setAttribute("vStudyDetailsBeans", vStudyDetailsBeans);
				target = "success";
			} else {
				target = "failure";
			}
		} catch (CommonException e) {
			request.setAttribute("message", e.getMessage());
			target = "failure";
		} catch (Exception e) {
			request.setAttribute("message", "Data Not Updated");
			target = "failure";
		}
		return mapping.findForward(target);

	}
}