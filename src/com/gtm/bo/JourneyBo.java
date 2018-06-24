package com.gtm.bo;

import java.util.Date;

public class JourneyBo {
	private int journeyNo;
	private String source;
	private String destination;
	private Date journeyDate;
	private double amount;
	public int getJourneyNo() {
		return journeyNo;
	}
	public void setJourneyNo(int journeyNo) {
		this.journeyNo = journeyNo;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
