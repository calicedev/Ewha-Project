package com.humintec.poc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.humintec.poc.dao.MemberDao;
import com.humintec.poc.dto.AddfrdDTO;

import com.humintec.poc.dto.GroupDTO;
import com.humintec.poc.dto.MemberDTO;



@Service // service bean으로 등록
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDao memberDao;

	
	public int signup(MemberDTO dto) { // 회원가입 하는 것 
		return memberDao.signup(dto); 
	}
	
	public MemberDTO login(MemberDTO dto){ // 로그인할때 회원 체크하는 것
		return memberDao.login(dto);
	}
	
	public int idDuplicationCheck(MemberDTO dto)  { //회원가입 할 떄 아이디 체크
		try {
			return memberDao.idDuplicationCheck(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	
	}
	
	public MemberDTO idlosschk(MemberDTO dto){ // 로그인할때 회원 체크하는 것
		return memberDao.idlosschk(dto);
	}
	
	public MemberDTO pswdlosschk(MemberDTO dto){ // 로그인할때 회원 체크하는 것
		return memberDao.pswdlosschk(dto);
	}
	
	public GroupDTO groupCheck(GroupDTO groupDTO){ // 로그인할때 회원 체크하는 것
		return memberDao.groupCheck(groupDTO);
	}

	public List<AddfrdDTO> addfrd(AddfrdDTO addfrdDTO) throws Exception {
		return memberDao.addfrd(addfrdDTO);
	}
	public void memberUpdate(MemberDTO dto) throws Exception {
		memberDao.memberUpdate(dto);
		
	}
	

}