package com.humintec.poc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.Criteria;
import com.humintec.poc.dto.SearchCriteria;

@Repository
public class BoardDao {
	@Inject
	private SqlSession sqlSession;
	
	// 게시글 작성
	public int write(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert("boardMapper.insert", boardDTO);
	}
	
	public List<BoardDTO> list(SearchCriteria scri) throws Exception {
		return sqlSession.selectList("boardMapper.listPage",scri);
	}
	
	public int listCount(SearchCriteria scri) throws Exception {
		return sqlSession.selectOne("boardMapper.listCount",scri);
	}
	
	public List<BoardDTO> myreply(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectList("boardMapper.myreply",boardDTO);
	}
	public List<BoardDTO> mypagescrap(BoardDTO boardDTO) throws Exception {
		return sqlSession.selectList("boardMapper.mypagescrap",boardDTO);
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

//추천
	public void updateLike(int bno) throws Exception{
	 sqlSession.update("boardMapper.updateLike", bno);
	}

	public void updateLikeCancel(int bno) throws Exception{
		 sqlSession.update("boardMapper.updateLikeCancel", bno);

	}

	

	public void insertLike(int bno,String likeuserid) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("likeuserid", likeuserid);
		map.put("bno", bno);
		sqlSession.insert("boardMapper.insertLike", map);
	}
	
	public void deleteLike(int bno,String likeuserid)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("likeuserid", likeuserid);
		map.put("bno", bno);
		sqlSession.delete("boardMapper.deleteLike", map);
	}
	

	public int likeCheck(int bno,String likeuserid) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("likeuserid", likeuserid);
		map.put("bno", bno);
		return sqlSession.selectOne("boardMapper.likeCheck", map);
	}
	

	public void updateLikeCheck(int bno,String likeuserid) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("likeuserid", likeuserid);
		map.put("bno", bno);
		sqlSession.update("boardMapper.updateLikeCheck", map);
		
	}
			

	public void updateLikeCheckCancel(int bno,String likeuserid) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("likeuserid", likeuserid);
		map.put("bno", bno);
		sqlSession.update("boardMapper.updateLikeCheckCancel", map);
	}

	public void scrap(int bno,String scrapuserid) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("scrapuserid", scrapuserid);
		map.put("bno", bno);
		sqlSession.insert("boardMapper.scrap", map);
	}

	public void scrapCancel(int bno,String scrapuserid)throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("scrapuserid", scrapuserid);
		map.put("bno", bno);
		sqlSession.delete("boardMapper.scrapCancel", map);
	}
	

	public int scrapCount(int bno,String scrapuserid) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("scrapuserid", scrapuserid);
		map.put("bno", bno);
		return sqlSession.selectOne("boardMapper.scrapCount", map);
	}
	
	public int scrapCheck(int bno,String scrapuserid) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("scrapuserid", scrapuserid);
		map.put("bno", bno);
		return sqlSession.selectOne("boardMapper.scrapCheck", map);
	}
	
	// 파일 첨부
	public void insertFile(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("boardMapper.insertFile", map);
	}
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.selectFileList", bno);
	}
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.selectFileInfo", map);
	}

	public void updateFile(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("boardMapper.updateFile", map);
	}
	public int prevbno(int bno) throws Exception {
		return sqlSession.selectOne("boardMapper.prevbno", bno);
	}
	public int nextbno(int bno) throws Exception {
		return sqlSession.selectOne("boardMapper.nextbno", bno);
	}

	public List<BoardDTO> myboard(BoardDTO boardDTO) {
		return sqlSession.selectList("boardMapper.myboard",boardDTO);
	}
}
