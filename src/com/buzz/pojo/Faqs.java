package com.buzz.pojo;

import java.math.BigDecimal;
import java.util.Date;


import com.buzz.bean.FaqsBean;

/**
 * Faqs entity. @author MyEclipse Persistence Tools
 */

public class Faqs implements java.io.Serializable {

	// Fields

	private int faqid;
	private int eventidref;
	private String faq;
	private String answer;
	private Date posteddate;

	// Constructors

	/** default constructor */
	public Faqs() {
	}

	/** minimal constructor */
	public Faqs(String faq) {
		this.faq = faq;
	}


	public Faqs(FaqsBean faqsBean) {
		//this.faqid = faqsBean.getFaqid();
		// this.events = faqsBean.getEvents();
		this.eventidref = faqsBean.getEventidref();
		this.faq = faqsBean.getFaq();
		this.answer = faqsBean.getAnswer();
		//this.posteddate = new Date(faqsBean.getPosteddate());
	}

	public int getFaqid() {
		return faqid;
	}

	public void setFaqid(int faqid) {
		this.faqid = faqid;
	}

	public int getEventidref() {
		return eventidref;
	}

	public void setEventidref(int eventidref) {
		this.eventidref = eventidref;
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

	public Date getPosteddate() {
		return this.posteddate;
	}

	public void setPosteddate(Date posteddate) {
		this.posteddate = posteddate;
	}

}