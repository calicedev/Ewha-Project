package com.humintec.poc.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardDTO extends BaseDTO {
	private int bno;
	private String title;
	private String content;
	private String bwriter;
	private String createdDate;
	private Date modifiedDate;
	private String theme;
	private int likehit;
	public int getLikehit() {
		return likehit;
	}
	public void setLikehit(int likehit) {
		this.likehit = likehit;
	}
	
	
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBwriterid() {
		return bwriterid;
	}
	public void setBwriterid(String bwriterid) {
		this.bwriterid = bwriterid;
	}
	private String bwriterid;
}
