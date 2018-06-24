package com.cc.valueobjects;

import java.util.Date;

public class MemberVO {
	private int memberId;
	private String name;
	private Date dob;
	private String gender;
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", name=" + name + ", dob="
				+ dob + ", gender=" + gender + "]";
	}
	
	
	
}
