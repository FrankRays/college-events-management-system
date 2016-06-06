package com.buzz.pojo;
// default package

import java.math.BigDecimal;
import java.util.Date;

import com.buzz.bean.PlacementinformationBean;
import com.buzz.util.DateWrapper;


/**
 * Placementinformation entity. @author MyEclipse Persistence Tools
 */

public class Placementinformation  implements java.io.Serializable {


    // Fields    

     private int placementinfoid;
     private String placementcompnayname;
     private String placementdescription;
     private Date placementdate;
     private String placementurl;


    // Constructors

    /** default constructor */
    public Placementinformation() {
    }

	/** minimal constructor */
    public Placementinformation(String placementcompnayname, String placementdescription, String placementurl) {
        this.placementcompnayname = placementcompnayname;
        this.placementdescription = placementdescription;
        this.placementurl = placementurl;
    }
    
    /** full constructor */
    public Placementinformation(String placementcompnayname, String placementdescription, Date placementdate, String placementurl) {
        this.placementcompnayname = placementcompnayname;
        this.placementdescription = placementdescription;
        this.placementdate = placementdate;
        this.placementurl = placementurl;
    }

   
    // Property accessors

  

    public Placementinformation(
			PlacementinformationBean placementinformationBean) {
    	   this.placementcompnayname = placementinformationBean.getPlacementcompnayname();
           this.placementdescription = placementinformationBean.getPlacementdescription();
           this.placementdate = new Date(placementinformationBean.getPlacementdate());
           this.placementurl = placementinformationBean.getPlacementurl();
	}

	public String getPlacementcompnayname() {
        return this.placementcompnayname;
    }
    
    public int getPlacementinfoid() {
		return placementinfoid;
	}

	public void setPlacementinfoid(int placementinfoid) {
		this.placementinfoid = placementinfoid;
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

    public Date getPlacementdate() {
        return this.placementdate;
    }
    
    public void setPlacementdate(Date placementdate) {
        this.placementdate = placementdate;
    }

    public String getPlacementurl() {
        return this.placementurl;
    }
    
    public void setPlacementurl(String placementurl) {
        this.placementurl = placementurl;
    }
   








}