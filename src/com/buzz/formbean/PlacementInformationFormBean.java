package com.buzz.formbean;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

public class PlacementInformationFormBean extends ValidatorForm {
	
		
		private String PlacementCompanyName;
		private String PlacementDescription;
		private String PlacementDate;
		private String PlacementUrl;
		
		public String getPlacementCompanyName() {
			return PlacementCompanyName;
		}
		public void setPlacementCompanyName(String placementCompanyName) {
			PlacementCompanyName = placementCompanyName;
		}
		public String getPlacementDescription() {
			return PlacementDescription;
		}
		public void setPlacementDescription(String placementDescription) {
			PlacementDescription = placementDescription;
		}
		public String getPlacementDate() {
			return PlacementDate;
		}
		public void setPlacementDate(String placementDate) {
			PlacementDate = placementDate;
		}
		
		public String getPlacementUrl() {
			return PlacementUrl;
		}
		public void setPlacementUrl(String placementUrl) {
			PlacementUrl = placementUrl;
		}
		
		public void reset(ActionMapping mapping, HttpServletRequest request) {
			// TODO Auto-generated method stub
			super.reset(mapping, request);
		}

		public ActionErrors validate(ActionMapping mapping,
				HttpServletRequest request) {
			// TODO Auto-generated method stub
			return super.validate(mapping, request);
		}
		
		
		
		
		
		

}
