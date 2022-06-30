package com.humintec.poc.dto;

public class LikeDTO {
	private int likeno;
	public int getLikeno() {
		return likeno;
	}
	public void setLikeno(int likeno) {
		this.likeno = likeno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	public int getLikecheck() {
		return likecheck;
	}
	public void setLikecheck(int likecheck) {
		this.likecheck = likecheck;
	}
	private int bno;
	public String getLikeuserid() {
		return likeuserid;
	}
	public void setLikeuserid(String likeuserid) {
		this.likeuserid = likeuserid;
	}
	private String likeuserid;
	private int likecheck;
}
