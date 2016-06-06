package com.buzz.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.buzz.bean.StudydetailsBean;
import com.buzz.dao.StudydetailsDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Studydetails;

public class StudyDetailsServiceImpl {
	StudydetailsDAO studydetailsDAO = new StudydetailsDAO();

	public void addStudyCenter(StudydetailsBean studyDetailsBean)
			throws CommonException {
		Studydetails Studydetails = new Studydetails(studyDetailsBean);
		studydetailsDAO.save(Studydetails);
	}

	public boolean updateStudyCenterByid(StudydetailsBean studyDetailsBean)
			throws CommonException, ConnectionException {
		Studydetails Studydetails = new Studydetails(studyDetailsBean);
		return studydetailsDAO.attachDirty(Studydetails);
	}

	public Vector<StudydetailsBean> viewStudyCenters() throws CommonException {
		Studydetails Studydetails = null;
		StudydetailsBean studyDetailsBean = null;
		Vector<StudydetailsBean> vStudyDetailsBeans = new Vector<StudydetailsBean>();
		try {
			List list = studydetailsDAO.findAll();

			for (Iterator it = list.iterator(); it.hasNext();) {
				Studydetails = (Studydetails) it.next();
				studyDetailsBean = new StudydetailsBean(Studydetails);
				vStudyDetailsBeans.add(studyDetailsBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vStudyDetailsBeans;
	}

	public StudydetailsBean viewStudyCenterbyId(int id) throws CommonException {
		Studydetails Studydetails = null;
		StudydetailsBean studyDetailsBean = null;
		try {
			Studydetails = studydetailsDAO.findById(id);
			studyDetailsBean = new StudydetailsBean(Studydetails);

		} catch (Exception e) {
			System.out.println(e);
		}
		return studyDetailsBean;
	}

	public boolean deleteStudyDetails(int parseInt) throws CommonException {
		try {
			Studydetails Studydetails = null;
			Studydetails = studydetailsDAO.findById(parseInt);
			studydetailsDAO.delete(Studydetails);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
