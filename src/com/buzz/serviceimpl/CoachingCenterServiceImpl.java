package com.buzz.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.buzz.bean.CoachingcenterBean;
import com.buzz.dao.CoachingcenterDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Coachingcenter;

public class CoachingCenterServiceImpl {
	CoachingcenterDAO coachingcenterDAO = new CoachingcenterDAO();

	public void addCoachingCenter(CoachingcenterBean coachingcenterBean)
			throws CommonException {
		Coachingcenter coachingCenter = new Coachingcenter(coachingcenterBean);
		coachingcenterDAO.save(coachingCenter);
	}

	public boolean viewCoachingCenterByid(CoachingcenterBean coachingCenterBean)
			throws CommonException, ConnectionException {
		Coachingcenter coachingcenter = new Coachingcenter(coachingCenterBean);
		return coachingcenterDAO.attachDirty(coachingcenter);
	}

	public boolean updateCoachingCenterIformationByid(
			CoachingcenterBean CoachingCenterBean) throws CommonException,
			ConnectionException {
		Coachingcenter Coachingcenter = new Coachingcenter(CoachingCenterBean);
		return coachingcenterDAO.attachDirty(Coachingcenter);
	}

	public Vector<CoachingcenterBean> viewCoachingCenters()
			throws CommonException {
		Coachingcenter coachingcenter = null;
		CoachingcenterBean coachingCenterBean = null;
		Vector<CoachingcenterBean> vCoachingCenterBeans = new Vector<CoachingcenterBean>();
		try {
			List list = coachingcenterDAO.findAll();
			System.out.println(list.size());
			for (Iterator it = list.iterator(); it.hasNext();) {
				Object object = (Coachingcenter) it.next();
				coachingcenter = (Coachingcenter) object;
				// System.out.println(coachingcenter.);
				System.out.println();
				System.out.println(coachingcenter.getStudydetails());
				coachingCenterBean = new CoachingcenterBean(coachingcenter);
				vCoachingCenterBeans.add(coachingCenterBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vCoachingCenterBeans;
	}

	public CoachingcenterBean viewCoachingCenterbyId(int id)
			throws CommonException {
		Coachingcenter coachingcenter = null;
		CoachingcenterBean coachingCenterBean = null;
		try {
			coachingcenter = coachingcenterDAO.findById(id);
			coachingCenterBean = new CoachingcenterBean(coachingcenter);

		} catch (Exception e) {
			System.out.println(e);
		}
		return coachingCenterBean;
	}

	public boolean deleteCoachingCenter(int parseInt) throws CommonException {
		try {
			Coachingcenter coachingcenter = null;
			coachingcenter = coachingcenterDAO.findById(parseInt);
			coachingcenterDAO.delete(coachingcenter);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
