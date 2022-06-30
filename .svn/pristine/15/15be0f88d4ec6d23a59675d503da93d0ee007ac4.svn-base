package com.humintec.poc.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.Criteria;
import com.humintec.poc.dto.SearchCriteria;


public interface BoardService {
	public int write(BoardDTO boardDTO,MultipartHttpServletRequest mpRequest) throws Exception;
	public List<BoardDTO> list(SearchCriteria scri) throws Exception;
	public int listCount(SearchCriteria scri) throws Exception;
	public int prevbno(int bno) throws Exception;
	public int nextbno(int bno) throws Exception;
	public List<BoardDTO> myreply(BoardDTO boardDTO) throws Exception;
	public List<BoardDTO> theme(BoardDTO boardDTO) throws Exception;
	public List<BoardDTO> myboard(BoardDTO boardDTO) throws Exception;
	public BoardDTO read(int bno) throws Exception;
	public void delete(int bno) throws Exception;
	void updateLike(int bno) throws Exception;
	void updateLikeCancel(int bno) throws Exception;
	void insertLike(int bno, String likeuserid) throws Exception;
	void deleteLike(int bno, String likeuserid) throws Exception;
	int likeCheck(int bno, String likeuserid) throws Exception;
	void updateLikeCheck(int bno, String likeuserid) throws Exception;
	void updateLikeCheckCancel(int bno, String likeuserid) throws Exception;
	int scrapCheck(int bno, String scrapuserid) throws Exception;
	int scrapCount(int bno, String scrapuserid) throws Exception;
	void scrapCancel(int bno, String scrapuserid) throws Exception;
	void scrap(int bno, String scrapuserid) throws Exception;
	
	public List<BoardDTO> mypagescrap(BoardDTO boardDTO) throws Exception;
	public List<Map<String, Object>> selectFileList(int bno) throws Exception;
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
	public void update(BoardDTO boardDTO, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception;
}


