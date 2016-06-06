package com.buzz.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.hibernate.HibernateException;

import com.buzz.bean.BranchBean;
import com.buzz.bean.GaleryBean;
import com.buzz.dao.BranchDAO;
import com.buzz.dao.GaleryDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Branch;
import com.buzz.pojo.Galery;

public class GalleryServiceImpl {
	GaleryDAO galeryDAO = new GaleryDAO();

	public void addGaleryFile(GaleryBean galeryBean) throws CommonException,
			HibernateException, ConnectionException {
		Galery galery = new Galery(galeryBean);
		galeryDAO.save(galery);
	}

	public void galeryUpdatebyid(GaleryBean galeryBean) throws CommonException,
			ConnectionException {
		Galery galery = new Galery(galeryBean);
		// return galeryDAO.attachDirty(galery);
	}

	public Vector<GaleryBean> viewGalery() throws CommonException {
		Galery galery = null;
		GaleryBean galeryBean = null;
		Vector<GaleryBean> vGaleryBeans = new Vector<GaleryBean>();
		try {
			List list = galeryDAO.findAll();

			for (Iterator it = list.iterator(); it.hasNext();) {
				galery = (Galery) it.next();
				galeryBean = new GaleryBean(galery);
				vGaleryBeans.add(galeryBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vGaleryBeans;
	}

	public GaleryBean viewGalerybyId(int id) throws CommonException {
		Galery galery = null;
		GaleryBean galeryBean = null;
		try {
			galery = galeryDAO.findById(id);
			galeryBean = new GaleryBean(galery);

		} catch (Exception e) {
			System.out.println(e);
		}
		return galeryBean;
	}

	public boolean deleteBranches(int parseInt) throws CommonException {
		try {
			Galery galery = null;
			galery = galeryDAO.findById(parseInt);
			galeryDAO.delete(galery);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
