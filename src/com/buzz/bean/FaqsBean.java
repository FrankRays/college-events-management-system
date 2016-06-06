package com.buzz.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.buzz.formbean.FaqsFormBean;
import com.buzz.pojo.Faqs;
import com.buzz.util.DateWrapper;

/**
 * Faqs entity. @author MyEclipse Persistence Tools
 */

public class FaqsBean implements java.io.Serializable {

	// Fields

	private int faqid;
	private String faq;
	private String answer;
	private String posteddate;
	private int eventidref;

	// Constructors

	/** default constructor */
	public FaqsBean() {
	}

	/** minimal constructor */
	public FaqsBean(String faq) {
		this.faq = faq;
	}




	public FaqsBean(Faqs faqs) {
		this.faqid = faqs.getFaqid();
		this.faq = faqs.getFaq();
		this.answer = faqs.getAnswer();
		this.posteddate =DateWrapper.parseDate(faqs.getPosteddate());
		this.eventidref=faqs.getEventidref();
	}

	// Property accessors

	public FaqsBean(FaqsFormBean faqsFormBean) {
		 //this.events=faqsFormBean.getEventsBean();
		this.eventidref = faqsFormBean.getEventidref();
		this.faq = faqsFormBean.getFaq();
		this.answer = faqsFormBean.getAnswer();

	}

	

	

	public int getFaqid() {
		return faqid;
	}

	public void setFaqid(int faqid) {
		this.faqid = faqid;
	}

	

	public String getFaq() {
		return this.faq;
	}

	public void setFaq(String faq) {
		this.faq = faq;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	

	public String getPosteddate() {
		return posteddate;
	}

	public void setPosteddate(String posteddate) {
		this.posteddate = posteddate;
	}

	public int getEventidref() {
		return eventidref;
	}

	public void setEventidref(int eventidref) {
		this.eventidref = eventidref;
	}

}