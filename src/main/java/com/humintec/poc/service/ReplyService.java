package com.humintec.poc.service;

import java.util.List;


import com.humintec.poc.dto.ReplyDTO;

public interface ReplyService {
	
	
	public List<ReplyDTO> list(int bno) throws Exception;
	public List<ReplyDTO> readReply(int bno) throws Exception;
	public int writeReply (ReplyDTO replyDTO) throws Exception;
	public int deleteReply (int rno) throws Exception;
	public int commentUpdate(ReplyDTO replyDTO) throws Exception;
	public ReplyDTO selectReply (int rno) throws Exception;
}
