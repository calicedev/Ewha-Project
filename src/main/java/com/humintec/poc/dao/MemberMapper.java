package com.humintec.poc.dao;

import java.util.List;

import com.humintec.poc.dto.AddfrdDTO;
import com.humintec.poc.dto.MemberDTO;

public interface MemberMapper {
	public int insertUser(MemberDTO dto);
	public MemberDTO loginUser(MemberDTO dto);
	public int idChk(MemberDTO dto);
}
