package com.humintec.poc.dao;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.humintec.poc.dto.AddfrdDTO;
import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.GroupDTO;
import com.humintec.poc.dto.MemberDTO;

@Repository
public class MemberDao {
	
	@Inject
	private SqlSession sqlSession;

//	public void loginCheck(UserDTO dto) {
//		System.out.println(sqlSession.selectList("user.userList",dto));
//	};
//	
	
	public int signup(MemberDTO dto) {
		int result = sqlSession.insert("signup",dto);
		return result;
	}
	
	public MemberDTO login(MemberDTO dto){
		dto = sqlSession.selectOne("login",dto);
		return dto;
//		UserDTO result=null;
//		MemberMapper mapper=sqlSession.getMapper(MemberMapper.class);
	
//		try {
//			result=mapper.loginUser(dto);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return result;
//		}
	}
	public int idDuplicationCheck(MemberDTO dto) throws Exception {
		int result = sqlSession.selectOne("idDuplicationCheck",dto);
		return result;
	}
	
	public MemberDTO idlosschk(MemberDTO dto) {
		MemberDTO result = sqlSession.selectOne("idlosschk",dto);
		return result;
	}
	
	public MemberDTO pswdlosschk(MemberDTO dto) {
		MemberDTO result = sqlSession.selectOne("pswdlosschk",dto);
		return result;
	}
	
	public GroupDTO groupCheck(GroupDTO groupDTO) {
		GroupDTO result = sqlSession.selectOne("groupCheck",groupDTO);
		return result;
	} 
	
	public List<AddfrdDTO> addfrd(AddfrdDTO addfrdDTO) throws Exception {
		return sqlSession.selectList("FriendMapper.addfrd",addfrdDTO);
	}
	
	public void memberUpdate(MemberDTO dto){
		sqlSession.update("memberUpdate", dto); 
	}
	
}