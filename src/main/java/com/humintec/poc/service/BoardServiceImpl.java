package com.humintec.poc.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.humintec.poc.dao.BoardDao;
import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.Criteria;
import com.humintec.poc.dto.SearchCriteria;
import com.humintec.poc.util.FileUtils;
@Service
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="fileUtils")
	private FileUtils fileUtils;
	
	@Inject
	private BoardDao boardDao;
	
	// 게시글 작성
	public int write(BoardDTO boardDTO, MultipartHttpServletRequest mpRequest) throws Exception {
		int i = boardDao.write(boardDTO);
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(boardDTO, mpRequest); 
		int size = list.size();
		for(int j=0; j<size; j++){ 
			boardDao.insertFile(list.get(j)); 
		}
		return i;
	}
	
	@Override
	public List<BoardDTO> list(SearchCriteria scri) throws Exception {
		return boardDao.list(scri);
	}
	
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return boardDao.listCount(scri);
	}
	
	@Override
	public List<BoardDTO> myboard(BoardDTO boardDTO) throws Exception {
		return boardDao.myboard(boardDTO);
	}
	@Override
	public List<BoardDTO> myreply(BoardDTO boardDTO) throws Exception {
		return boardDao.myreply(boardDTO);
	}
	
	@Override
	public List<BoardDTO> mypagescrap(BoardDTO boardDTO) throws Exception {
		return boardDao.mypagescrap(boardDTO);
	}
	@Override
	public List<BoardDTO> theme(BoardDTO boardDTO) throws Exception {
		return boardDao.theme(boardDTO);
	}
	@Override
	public BoardDTO read(int bno) throws Exception {

		return boardDao.read(bno);
	}
	
//	@Override
//	public void update(BoardDTO boardDTO) throws Exception {
//
//		boardDao.update(boardDTO);
//	}

	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}
//추천
	@Override
	public void updateLike(int bno) throws Exception{
		boardDao.updateLike(bno);
	}
	
	@Override
	public void updateLikeCancel(int bno) throws Exception{
		boardDao.updateLikeCancel(bno);
	}

	
	@Override
	public void insertLike(int bno,String likeuserid) throws Exception{
		boardDao.insertLike(bno, likeuserid);
	}
	
	@Override
	public void deleteLike(int bno,String likeuserid)throws Exception{
		boardDao.deleteLike(bno, likeuserid);
	}
	
	@Override
	public int likeCheck(int bno,String likeuserid) throws Exception{
		return boardDao.likeCheck(bno, likeuserid);
	}
	
	@Override
	public void updateLikeCheck(int bno,String likeuserid)throws Exception{
		boardDao.updateLikeCheck(bno, likeuserid);
	}
	
	@Override
	public void scrap(int bno,String scrapuserid)throws Exception{
		boardDao.scrap(bno, scrapuserid);
	}
	
	@Override
	public void scrapCancel(int bno,String scrapuserid)throws Exception{
		boardDao.scrapCancel(bno, scrapuserid);
	}
	@Override
	public int prevbno(int bno) throws Exception{
		return boardDao.prevbno(bno);
	}
	@Override
	public int nextbno(int bno) throws Exception{
		return boardDao.nextbno(bno);
	}
	@Override
	public int scrapCount(int bno,String scrapuserid) throws Exception{
		return boardDao.scrapCount(bno, scrapuserid);
	}
	@Override
	public int scrapCheck(int bno,String scrapuserid) throws Exception{
		return boardDao.scrapCheck(bno, scrapuserid);
	}

	@Override
	public void updateLikeCheckCancel(int bno, String scrapuserid) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.selectFileList(bno);
	}
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.selectFileInfo(map);
	}
	public void update(BoardDTO boardDTO, String[] files, String[] fileNames, MultipartHttpServletRequest mpRequest) throws Exception {
		boardDao.update(boardDTO);
			List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(boardDTO, files, fileNames, mpRequest);
			Map<String, Object> tempMap = null;
			int size = list.size();
			for(int i = 0; i<size; i++) {
				tempMap = list.get(i);
				if(tempMap.get("IS_NEW").equals("Y")) {
					boardDao.insertFile(tempMap);
				}else {
					boardDao.updateFile(tempMap);
				}
			}
		}
}
