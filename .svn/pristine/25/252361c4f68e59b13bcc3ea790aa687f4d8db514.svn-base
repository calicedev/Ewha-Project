package com.humintec.poc.controller;



import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humintec.poc.dto.AddfrdDTO;
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
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService boardService;

	@Inject
	ReplyService replyService;
	
	@Inject
	MemberService memberService;


	// 게시판 글 작성 화면
	@RequestMapping(value = "/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");

	}

	// 게시판 글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardDTO boardDTO) throws Exception{
		logger.info("write");
		boardService.write(boardDTO);
		System.out.println("getWriter:"+boardDTO.getWriter());
		return "redirect:/board/list";
	}

	// 게시판 목록 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		logger.info("list");
		model.addAttribute("list",boardService.list());
		System.out.println("list:"+boardService.list());
		return "board/list";

	}

	// 내가 쓴글 조회
	@RequestMapping(value = "/myanswer", method = RequestMethod.GET)
	public String list2(Model model, HttpSession session, ReplyDTO replyDTO, BoardDTO boardDTO) throws Exception{

		String userName =((MemberDTO)session.getAttribute("memberDTO")).getUsername();
		boardDTO.setWriter(userName);

		List<BoardDTO> ar =  boardService.list2(boardDTO);
		model.addAttribute("list2",ar);
		return "board/myanswer";

	}

	// 테마 목록 조회
	
	@RequestMapping(value = "/theme2", method = RequestMethod.GET)
	public String theme2(Model model,BoardDTO boardDTO) throws Exception{
		model.addAttribute("theme",boardService.theme(boardDTO));
		return "board/theme2";

	}

  //주제별 모아보기 버튼 타고 들어가는 거
	@RequestMapping(value = "/theme", method = RequestMethod.GET)
	public String themebtn(Model model) throws Exception{
		return "board/theme";

	}

	//게시판 조회
	
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(@RequestParam("bno") int bno, BoardDTO boardDTO, Model model,HttpSession session) throws Exception{
		logger.info("read");
		model.addAttribute("read", boardService.read(boardDTO.getBno()));

		List<ReplyDTO> reply=null;
		reply=replyService.list(bno);
		model.addAttribute("reply",reply);

		List<ReplyDTO> replyList=replyService.readReply(boardDTO.getBno());
		model.addAttribute("replyList", replyList);
		return "board/readView";
	}
	@ResponseBody
	@RequestMapping(value = "/readView2", method = RequestMethod.POST)
	public List<ReplyDTO> read2(@RequestParam("bno") int bno, BoardDTO boardDTO, Model model,HttpSession session) throws Exception{
		logger.info("read");
		model.addAttribute("read", boardService.read(boardDTO.getBno()));

		List<ReplyDTO> reply=null;
		reply=replyService.list(bno);
		model.addAttribute("reply",reply);

		List<ReplyDTO> replyList=replyService.readReply(boardDTO.getBno());
		model.addAttribute("replyList", replyList);
		return replyList;
	}
	
    @RequestMapping("/delete/{rno}") //댓글 삭제  
    @ResponseBody
    private int mCommentServiceDelete(@PathVariable int rno) throws Exception{
        
        return replyService.deleteReply(rno);
    }
    
    @RequestMapping("/updater") //댓글 수정  
    @ResponseBody
    private int mCommentServiceUpdateProc(@RequestParam int rno, @RequestParam String content) throws Exception{
        
    	ReplyDTO comment = new ReplyDTO();
        comment.setRno(rno);
        comment.setContent(content);
        
        return replyService.commentUpdate(comment);
    }
    
	@RequestMapping(value = "/replylist", method = RequestMethod.POST)
	public List<ReplyDTO> replylist(@RequestParam("bno") int bno, BoardDTO boardDTO, Model model,HttpSession session) throws Exception{
		System.out.println("dur");
		return replyService.readReply(boardDTO.getBno());
	
	}
	
	// 게시판 수정뷰
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardDTO boardDTO, Model model) throws Exception{
		logger.info("updateView");

		model.addAttribute("update", boardService.read(boardDTO.getBno()));

		return "board/updateView";
	}

	// 게시판 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardDTO boardDTO, int bno) throws Exception{
		logger.info("update");

		boardService.update(boardDTO);

		return "redirect:/board/readView?bno="+bno;
	}

	// 게시판 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardDTO boardDTO) throws Exception{
		logger.info("delete");

		boardService.delete(boardDTO.getBno());

		return "redirect:/board/list";
	}

	//댓글 작성
	@ResponseBody
	@RequestMapping(value="/replyWrite", method = RequestMethod.POST)
	public int replyWrite(ReplyDTO replyDTO, SearchCriteria scri, RedirectAttributes rttr,HttpSession session, @RequestParam int bno, @RequestParam String content) throws Exception {
		/*
		 * logger.info("reply Write"); 
		 * replyService.writeReply(replyDTO);
		 * rttr.addAttribute("bno", replyDTO.getBno());
		 */
		ReplyDTO comment = new ReplyDTO();
	        comment.setBno(bno);
	        comment.setContent(content);
	        String userName =((MemberDTO)session.getAttribute("memberDTO")).getUsername();
	        comment.setWriter(userName);
	        rttr.addAttribute("bno", replyDTO.getBno());
	        return replyService.writeReply(comment);

			/*
			 * return "redirect:/board/readView";
			 */
	}

	/*
	 * //댓글 삭제 GET
	 * 
	 * @RequestMapping(value="/replyDeleteView", method = RequestMethod.GET) public
	 * String replyDeleteView(ReplyDTO replyDTO, SearchCriteria scri, Model model)
	 * throws Exception { logger.info("reply Write");
	 * 
	 * model.addAttribute("replyDelete",
	 * replyService.selectReply(replyDTO.getRno()));
	 * 
	 * return "board/replyDeleteView"; }
	 * 
	 * //댓글 삭제
	 * 
	 * @RequestMapping(value="/replyDelete", method = RequestMethod.POST) public
	 * String replyDelete(ReplyDTO replyDTO, RedirectAttributes rttr) throws
	 * Exception { logger.info("reply Write");
	 * 
	 * replyService.deleteReply(replyDTO);
	 * 
	 * rttr.addAttribute("bno", replyDTO.getBno());
	 * 
	 * return "redirect:/board/readView"; }
	 */
	// 목록에서 알림 누르면 들어감
	@RequestMapping(value = "/friendadd", method = RequestMethod.GET)
	public String friendadd(Model model,HttpSession session,AddfrdDTO addfrdDTO, MemberDTO memberDTO) throws Exception{
		String userName =((MemberDTO)session.getAttribute("memberDTO")).getUsername();
		addfrdDTO.setReceiver(userName);
		System.out.println(addfrdDTO.getReceiver());
		List<AddfrdDTO> ar =  memberService.addfrd(addfrdDTO);
		model.addAttribute("list",ar);
		System.out.println("list:"+ar);
		return "board/setting";

	}
	
	//왜있는지 모르는 애들

	/*
	 * @RequestMapping(value = "/settinggroup", method = RequestMethod.GET) public
	 * String settinggroup(Model model, HttpSession session, ReplyDTO replyDTO,
	 * BoardDTO boardDTO) throws Exception{ return "member/groupchk";
	 * 
	 * }
	 */
	
	/*
	 * @RequestMapping(value = "/setting", method = RequestMethod.GET) public String
	 * setting(Model model, HttpSession session, ReplyDTO replyDTO, BoardDTO
	 * boardDTO) throws Exception{ return "board/setting"; }
	 */


}