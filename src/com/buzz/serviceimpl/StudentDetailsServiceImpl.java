package com.buzz.serviceimpl;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.buzz.bean.LogindetailsBean;
import com.buzz.bean.NewsfeedBean;
import com.buzz.bean.StudentDetailsBean;
import com.buzz.bean.StudydetailsBean;
import com.buzz.dao.StudentsDetailsDAO;
import com.buzz.exception.CommonException;
import com.buzz.exception.ConnectionException;
import com.buzz.pojo.Newsfeed;
import com.buzz.pojo.StudentDetails;

public class StudentDetailsServiceImpl {
	StudentsDetailsDAO studentsDetailsDAO = new StudentsDetailsDAO();

	public LogindetailsBean organiserRegistration(
			StudentDetailsBean studentDetailsBean) throws CommonException {
		StudentDetails studentDetails = new StudentDetails(studentDetailsBean);
		System.out.println(studentDetails.getBranch().getBranchid());
		return studentsDetailsDAO.save(studentDetails);
	}

	public Vector<StudentDetailsBean> viewOrganisers()
			throws CommonException {
		StudentDetails studentDetails = null;
		StudentDetailsBean studentDetailsBean = null;
		Vector<StudentDetailsBean> vStudentDetailsBeans = new Vector<StudentDetailsBean>();
		try {
			List list = studentsDetailsDAO.findAll();
			for (Iterator it = list.iterator(); it.hasNext();) {
				studentDetails = (StudentDetails) it
						.next();
				studentDetailsBean = new StudentDetailsBean(
						studentDetails);
				vStudentDetailsBeans
						.add(studentDetailsBean);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return vStudentDetailsBeans;
	}
	/*
	 * public void newsUpdatebyid( OraganisedStudentsDetailsBean
	 * oraganisedStudentsDetailsBean) throws CommonException,
	 * ConnectionException {
	 * 
	 * OraganisedStudentsDetails raganisedStudentsDetails = new
	 * OraganisedStudentsDetails( oraganisedStudentsDetailsBean); return
	 * oraganisedStudentsDetailsDAO .attachDirty(raganisedStudentsDetails);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public Vector<OraganisedStudentsDetailsBean> viewOrganisers(int eventid)
	 * throws CommonException { OraganisedStudentsDetails
	 * oraganisedStudentsDetails = null; OraganisedStudentsDetailsBean
	 * oraganisedStudentsDetailsBean = null;
	 * Vector<OraganisedStudentsDetailsBean> vOraganisedStudentsDetailsBeans =
	 * new Vector<OraganisedStudentsDetailsBean>(); try { List list =
	 * oraganisedStudentsDetailsDAO.findAll(eventid); for (Iterator it =
	 * list.iterator(); it.hasNext();) { oraganisedStudentsDetails =
	 * (OraganisedStudentsDetails) it .next(); oraganisedStudentsDetailsBean =
	 * new OraganisedStudentsDetailsBean( oraganisedStudentsDetails);
	 * vOraganisedStudentsDetailsBeans .add(oraganisedStudentsDetailsBean); } }
	 * catch (Exception e) { System.out.println(e); } return
	 * vOraganisedStudentsDetailsBeans; }
	 * 
	 * public NewsfeedBean viewNewsbyId(int id) throws CommonException { return
	 * null;
	 * 
	 * OraganisedStudentsDetails raganisedStudentsDetails = null; NewsfeedBean
	 * newsfeedBean = null; try { OraganisedStudentsDetails =
	 * oraganisedStudentsDetailsDAO .findById(id); newsfeedBean = new
	 * NewsfeedBean(raganisedStudentsDetails);
	 * 
	 * } catch (Exception e) { System.out.println(e); } return newsfeedBean;
	 * 
	 * }
	 * 
	 * public boolean deleteNews(int parseInt) throws CommonException { try {
	 * OraganisedStudentsDetails oraganisedStudentsDetails =
	 * oraganisedStudentsDetailsDAO .findById(parseInt);
	 * oraganisedStudentsDetailsDAO.delete(oraganisedStudentsDetails); return
	 * true; } catch (Exception e) { System.out.println(e); return false; }
	 * 
	 * }
	 */

}
