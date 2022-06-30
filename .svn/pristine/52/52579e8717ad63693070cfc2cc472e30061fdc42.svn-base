package com.humintec.poc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.humintec.poc.dao.BoardDao;
import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.SearchCriteria;
@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDao boardDao;
	
	// 게시글 작성
	public void write(BoardDTO boardDTO) throws Exception {
		boardDao.write(boardDTO);
	}
	
	@Override
	public List<BoardDTO> list() throws Exception {
		return boardDao.list();
	}
	
	
	@Override
	public List<BoardDTO> list2(BoardDTO boardDTO) throws Exception {
		return boardDao.list2(boardDTO);
	}
	@Override
	public List<BoardDTO> theme(BoardDTO boardDTO) throws Exception {
		return boardDao.theme(boardDTO);
	}
	@Override
	public BoardDTO read(int bno) throws Exception {

		return boardDao.read(bno);
	}
	
	@Override
	public void update(BoardDTO boardDTO) throws Exception {

		boardDao.update(boardDTO);
	}

	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}
	
}
