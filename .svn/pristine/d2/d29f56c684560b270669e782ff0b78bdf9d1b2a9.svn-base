package com.humintec.poc.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.humintec.poc.dto.ReplyDTO;
@Repository
public class ReplyDao {

	
	@Inject
	private SqlSession sqlSession;
	
	public List<ReplyDTO> list(int bno) throws Exception{
		return sqlSession.selectList("replyMapper.replyList", bno);
	}

	
	//»õ·Î¿î ´ñ±Û
	public List<ReplyDTO> readReply(int bno) throws Exception{
		return sqlSession.selectList("replyMapper.readReply", bno);
	}
	public int writeReply(ReplyDTO replyDTO) throws Exception{
		return sqlSession.insert("replyMapper.writeReply", replyDTO);
	}
	public int deleteReply(int rno) throws Exception{
		return sqlSession.delete("replyMapper.deleteReply", rno);
	}
	public ReplyDTO selectReply(int rno) throws Exception{
		return sqlSession.selectOne("replyMapper.selectReply", rno);
	}
	
	public int commentUpdate(ReplyDTO replyDTO) throws Exception{
		return sqlSession.update("replyMapper.commentUpdate", replyDTO);
	}
	
	
}
