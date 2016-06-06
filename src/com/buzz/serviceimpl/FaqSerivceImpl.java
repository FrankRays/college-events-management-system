package com.buzz.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.buzz.bean.BranchBean;
import com.buzz.bean.FaqsBean;
import com.buzz.dao.BranchDAO;
import com.buzz.dao.FaqsDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Branch;
import com.buzz.pojo.Faqs;

public class FaqSerivceImpl {

	FaqsDAO faqsDAO = new FaqsDAO();

	public void addFaqs(FaqsBean faqsBean) throws CommonException {
		Faqs faqs = new Faqs(faqsBean);
		faqsDAO.save(faqs);
	}

	public boolean faqsUpdatebyid(FaqsBean faqsBean) throws CommonException,
			ConnectionException {
		Faqs Faqs = new Faqs(faqsBean);
		return faqsDAO.attachDirty(Faqs);
	}

	public Vector<FaqsBean> viewFaqs() throws CommonException {
		Faqs faqs = null;
		FaqsBean faqsBean = null;
		Vector<FaqsBean> vFaqsBeans = new Vector<FaqsBean>();
		try {
			List list = faqsDAO.findAll();
			for (Iterator it = list.iterator(); it.hasNext();) {
				faqs = (Faqs) it.next();
				faqsBean = new FaqsBean(faqs);
				vFaqsBeans.add(faqsBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vFaqsBeans;
	}

	public FaqsBean viewFaqsbyId(int id) throws CommonException {
		Faqs Faqs = null;
		FaqsBean faqsBean = null;
		try {
			Faqs = faqsDAO.findById(id);
			faqsBean = new FaqsBean(Faqs);

		} catch (Exception e) {
			System.out.println(e);
		}
		return faqsBean;
	}

	public boolean deleteFaqs(int parseInt) throws CommonException {
		try {
			Faqs Faqs = faqsDAO.findById(parseInt);
			faqsDAO.delete(Faqs);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

}
