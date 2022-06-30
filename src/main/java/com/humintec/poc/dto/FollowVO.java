package com.humintec.poc.dto;

public class FollowVO {

	private int followNo;
	private int activeUser;
	private int passiveUser;
	private String regDate;
	
	private String activeUserId;
	private String passiveUserId;
	
	private String profileName;
	
	
	public int getFollowNo() {
		return followNo;
	}

	public void setFollowNo(int followNo) {
		this.followNo = followNo;
	}

	public int getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(int activeUser) {
		this.activeUser = activeUser;
	}

	public int getPassiveUser() {
		return passiveUser;
	}

	public void setPassiveUser(int passiveUser) {
		this.passiveUser = passiveUser;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getActiveUserId() {
		return activeUserId;
	}

	public void setActiveUserId(String activeUserId) {
		this.activeUserId = activeUserId;
	}

	public String getPassiveUserId() {
		return passiveUserId;
	}

	public void setPassiveUserId(String passiveUserId) {
		this.passiveUserId = passiveUserId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
}