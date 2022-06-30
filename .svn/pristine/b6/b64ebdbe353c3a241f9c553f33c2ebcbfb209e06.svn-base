package com.humintec.poc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.humintec.poc.dao.ReplyDao;
import com.humintec.poc.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDao replyDao;
	
	@Override
	public List<ReplyDTO> list(int bno) throws Exception{
		return replyDao.list(bno);
	}
	public List<ReplyDTO> readReply(int bno) throws Exception{
		return replyDao.readReply(bno);
	}
	public int writeReply(ReplyDTO replyDTO) throws Exception{
		return replyDao.writeReply(replyDTO);
	}
	public int deleteReply (int rno) throws Exception{
		return replyDao.deleteReply(rno);
	}
	public ReplyDTO selectReply (int rno) throws Exception{
		return replyDao.selectReply(rno);
	}
	public int commentUpdate(ReplyDTO replyDTO) throws Exception{
		return replyDao.commentUpdate(replyDTO);
	}
	
}