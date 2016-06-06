package com.buzz.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.buzz.bean.PlacementinformationBean;
import com.buzz.dao.PlacementinformationDAO;
import com.buzz.dao.StudydetailsDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Placementinformation;
import com.buzz.pojo.Studydetails;

public class PlacementInformationServiceImpl {
	PlacementinformationDAO placementinformationDAO = new PlacementinformationDAO();

	public void addPlacementInformation(
			PlacementinformationBean PlacementInformationBean)
			throws CommonException {
		Placementinformation Placementinformation = new Placementinformation(
				PlacementInformationBean);
		placementinformationDAO.save(Placementinformation);
	}

	public boolean updatePlacementIformationByid(
			PlacementinformationBean PlacementInformationBean)
			throws CommonException, ConnectionException {
		Placementinformation Placementinformation = new Placementinformation(
				PlacementInformationBean);
		return placementinformationDAO.attachDirty(Placementinformation);
	}

	public Vector<PlacementinformationBean> viewPlacementIformation()
			throws CommonException {
		Placementinformation Placementinformation = null;
		PlacementinformationBean PlacementInformationBean = null;
		Vector<PlacementinformationBean> vStudyDetailsBeans = new Vector<PlacementinformationBean>();
		try {
			List list = placementinformationDAO.findAll();

			for (Iterator it = list.iterator(); it.hasNext();) {
				Placementinformation = (Placementinformation) it.next();
				PlacementInformationBean = new PlacementinformationBean(
						Placementinformation);
				vStudyDetailsBeans.add(PlacementInformationBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vStudyDetailsBeans;
	}

	public PlacementinformationBean viewPlacementIformationbyId(int id)
			throws CommonException {
		Placementinformation Placementinformation = null;
		PlacementinformationBean placementInformationBean = null;
		try {
			Placementinformation = placementinformationDAO.findById(id);
			placementInformationBean = new PlacementinformationBean(
					Placementinformation);

		} catch (Exception e) {
			System.out.println(e);
		}
		return placementInformationBean;
	}

	public boolean deleteStudyDetails(int parseInt) throws CommonException {
		try {
			Placementinformation Placementinformation = null;
			Placementinformation = placementinformationDAO.findById(parseInt);
			placementinformationDAO.delete(Placementinformation);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
