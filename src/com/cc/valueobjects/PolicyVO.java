package com.cc.valueobjects;

import java.util.Date;

public class PolicyVO {
	
	private int policyNo;
	private int memberNo;
	private int planNo;
	private Date effictiveFrom;
	private int tenure;
	private float premium;
	
	
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getPlanNo() {
		return planNo;
	}
	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}
	public int getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}
	
	public Date getEffictiveFrom() {
		return effictiveFrom;
	}
	public void setEffictiveFrom(Date effictiveFrom) {
		this.effictiveFrom = effictiveFrom;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public float getPremium() {
		return premium;
	}
	public void setPremium(float premium) {
		this.premium = premium;
	}
	@Override
	public String toString() {
		return "PolicyVO [policyNo=" + policyNo + ", memberNo=" + memberNo
				+ ", planNo=" + planNo + ", effictiveFrom=" + effictiveFrom
				+ ", tenure=" + tenure + ", premium=" + premium + "]";
	}
	
	
	
}
