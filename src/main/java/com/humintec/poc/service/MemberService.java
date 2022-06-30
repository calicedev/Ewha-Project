package com.humintec.poc.service;
import java.util.List;

import com.humintec.poc.dto.AddfrdDTO;

import com.humintec.poc.dto.GroupDTO;
import com.humintec.poc.dto.MemberDTO;

public interface MemberService {

	public int signup(MemberDTO dto);
	public MemberDTO login(MemberDTO dto);
	public int idDuplicationCheck(MemberDTO dto);
	public MemberDTO idlosschk(MemberDTO dto);
	public MemberDTO pswdlosschk(MemberDTO dto);
	public GroupDTO groupCheck(GroupDTO groupDTO);
	public List<AddfrdDTO> addfrd(AddfrdDTO addfrdDTO) throws Exception;
	public void memberUpdate(MemberDTO dto) throws Exception;
}