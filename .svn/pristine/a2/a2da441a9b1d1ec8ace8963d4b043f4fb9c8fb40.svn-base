package com.humintec.poc.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.SearchCriteria;

@Repository
public class BoardDao {
	@Inject
	private SqlSession sqlSession;
	
	// 게시글 작성
	public void write(BoardDTO boardDTO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardDTO);
	}
	
	public List<BoardDTO> list() throws Exception {
		return sqlSession.selectList("boardMapper.list");
	}
	
	public List<BoardDTO> list2(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectList("boardMapper.list2",boardDTO);
	}
	
	public List<BoardDTO> theme(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectList("boardMapper.theme",boardDTO);
	}
	
	public BoardDTO read(int bno) throws Exception {
		return sqlSession.selectOne("boardMapper.read", bno);
	}
	
	public void update(BoardDTO boardDTO) throws Exception {
		sqlSession.update("boardMapper.update", boardDTO);
	}

	public void delete(int bno) throws Exception {
		sqlSession.delete("boardMapper.delete", bno);
	}

}
