package com.humintec.poc.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.MemberDTO;
import com.humintec.poc.dto.PageMaker;
import com.humintec.poc.dto.ReplyDTO;
import com.humintec.poc.dto.SearchCriteria;
import com.humintec.poc.service.BoardService;
import com.humintec.poc.service.MemberService;
import com.humintec.poc.service.ReplyService;

@Controller
@RequestMapping(value="/board")
public class CommunityController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommunityController.class);

	@Inject
	BoardService boardService;

	@Inject
	ReplyService replyService;
	
	@Inject
	MemberService memberService;

	

	// 게시판 글 작성 화면
	@RequestMapping(value = "/community/create", method = RequestMethod.GET)
	public String newForm() throws Exception{
		return "board/community/writeView";
	}

	
	// 게시판 글 작성
	@RequestMapping(value = "/community/save", method = RequestMethod.POST)
	public String write(BoardDTO boardDTO, MultipartHttpServletRequest mpRequest) throws Exception{
		logger.info("write");
		boardService.write(boardDTO,mpRequest);
		return "redirect:/board/community";
	}

	// 게시판 목록 조회
	@RequestMapping(value = "/community", method = RequestMethod.GET)
	public String list(Model model,@ModelAttribute("scri") SearchCriteria scri) throws Exception{
		
		
//	  model.addAttribute("selectBox", CodeService.getSelectList(key));
		
		logger.info("list");
		model.addAttribute("list",boardService.list(scri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(boardService.listCount(scri));
		model.addAttribute("pageMaker", pageMaker);
		return "board/community/list";

	}



}
