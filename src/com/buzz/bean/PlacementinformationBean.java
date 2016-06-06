package com.buzz.bean;

// default package

import java.util.Date;

import com.buzz.formbean.PlacementInformationFormBean;
import com.buzz.pojo.Placementinformation;
import com.buzz.util.DateWrapper;

/**
 * Placementinformation entity. @author MyEclipse Persistence Tools
 */

public class PlacementinformationBean implements java.io.Serializable {

	// Fields

	private int placementinfoid;
	private String placementcompnayname;
	private String placementdescription;
	private String placementdate;
	private String placementurl;

	// Constructors

	/** default constructor */
	public PlacementinformationBean() {
	}

	/** minimal constructor */
	public PlacementinformationBean(String placementcompnayname,
			String placementdescription, String placementurl) {
		this.placementcompnayname = placementcompnayname;
		this.placementdescription = placementdescription;
		this.placementurl = placementurl;
	}

	/** full constructor */
	public PlacementinformationBean(String placementcompnayname,
			String placementdescription, Date placementdate, String placementurl) {
		this.placementcompnayname = placementcompnayname;
		this.placementdescription = placementdescription;
		this.placementdate = DateWrapper.parseDate(placementdate);
		this.placementurl = placementurl;
	}

	// Property accessors

	public PlacementinformationBean(Placementinformation placementinformation) {
		this.placementinfoid = placementinformation.getPlacementinfoid();
		this.placementcompnayname = placementinformation
				.getPlacementcompnayname();
		this.placementdescription = placementinformation
				.getPlacementdescription();
		this.placementdate = DateWrapper.parseDate(placementinformation
				.getPlacementdate());
		this.placementurl = placementinformation.getPlacementurl();
	}

	public PlacementinformationBean(
			PlacementInformationFormBean placementInformationFormBean) {
		this.placementcompnayname = placementInformationFormBean
				.getPlacementCompanyName();
		this.placementdescription = placementInformationFormBean
				.getPlacementDescription();
		this.placementdate = placementInformationFormBean.getPlacementDate();
		this.placementurl = placementInformationFormBean.getPlacementUrl();
	}

	public String getPlacementcompnayname() {
		return this.placementcompnayname;
	}

	public void setPlacementcompnayname(String placementcompnayname) {
		this.placementcompnayname = placementcompnayname;
	}

	public String getPlacementdescription() {
		return this.placementdescription;
	}

	public void setPlacementdescription(String placementdescription) {
		this.placementdescription = placementdescription;
	}

	public String getPlacementurl() {
		return this.placementurl;
	}

	public void setPlacementurl(String placementurl) {
		this.placementurl = placementurl;
	}

	public int getPlacementinfoid() {
		return placementinfoid;
	}

	public void setPlacementinfoid(int placementinfoid) {
		this.placementinfoid = placementinfoid;
	}

	public String getPlacementdate() {
		return placementdate;
	}

	public void setPlacementdate(String placementdate) {
		this.placementdate = placementdate;
	}

}