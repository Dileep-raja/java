package com.cc.valueobjects;


public class PlanVO {
	private int planNo;
	private String planName;
	
	
	public int getPlanNo() {
		return planNo;
	}
	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	@Override
	public String toString() {
		return "PlanVO [planNo=" + planNo + ", planName=" + planName + "]";
	}
	
	
	
	
	
}
