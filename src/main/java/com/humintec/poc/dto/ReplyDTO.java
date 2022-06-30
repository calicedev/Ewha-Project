package com.humintec.poc.dto;

import java.util.List;

public class ReplyDTO extends BoardDTO{
	
	private int rno;
	private String createdDate;
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	private List<ReplyDTO> list;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public List<ReplyDTO> getList() {
		return list;
	}
	public void setList(List<ReplyDTO> list) {
		this.list = list;
	}


}
