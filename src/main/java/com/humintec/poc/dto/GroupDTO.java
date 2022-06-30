package com.humintec.poc.dto;

import java.util.List;

public class GroupDTO {
	private String gnum;
	private String gname;
	private List<GroupDTO> list;
	
	public String getGnum() {
		return gnum;
	}
	public void setGnum(String gnum) {
		this.gnum = gnum;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public List<GroupDTO> getList() {
		return list;
	}
	public void setList(List<GroupDTO> list) {
		this.list = list;
	}
}
