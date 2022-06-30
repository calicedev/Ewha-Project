package com.humintec.poc.controller;



import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humintec.poc.dto.AddfrdDTO;
import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.Criteria;
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
	@RequestMapping(value = "/consultation/create", method = RequestMethod.GET)
	public String newForm() throws Exception{
		return "board/consultation/writeView";
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/consultation/save", method = RequestMethod.POST)
	public String write(BoardDTO boardDTO, MultipartHttpServletRequest mpRequest) throws Exception{
		logger.info("write");
		String result="";
		int i = boardService.write(boardDTO,mpRequest);
		if (i==1) {
			result= "redirect:/board/consultation/";
			}
		else {}
		
		return result;
		
	}

	// 게시판 목록 조회
	@RequestMapping(value = "/consultation", method = RequestMethod.GET)
	public String list(Model model,@ModelAttribute("scri") SearchCriteria scri) throws Exception{
		
		
//	  model.addAttribute("selectBox", CodeService.getSelectList(key));
		
		logger.info("list");
		model.addAttribute("list",boardService.list(scri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(boardService.listCount(scri));
		model.addAttribute("pageMaker", pageMaker);
		return "board/consultation/list";

	}


	// 테마 목록 조회
	
	@RequestMapping(value = "/theme2", method = RequestMethod.GET)
	public String theme2(Model model,BoardDTO boardDTO) throws Exception{
		model.addAttribute("theme",boardService.theme(boardDTO));
		return "board/consultation/theme2";

	}

  //주제별 모아보기 버튼 타고 들어가는 거
	@RequestMapping(value = "/theme", method = RequestMethod.GET)
	public String themebtn(Model model) throws Exception{
		return "board/consultation/theme";

	}

	//게시판 조회
	@RequestMapping(value = "/consultation/{bno}", method = RequestMethod.GET)
	public String read(@PathVariable("bno") int bno, BoardDTO boardDTO, Model model,HttpSession session) throws Exception{
		logger.info("read");
		model.addAttribute("read", boardService.read(boardDTO.getBno()));
		model.addAttribute("scrap", boardService.scrapCount(boardDTO.getBno(), null));
		model.addAttribute("prevbno", boardService.prevbno(boardDTO.getBno()));
		model.addAttribute("nextbno", boardService.nextbno(boardDTO.getBno()));
		List<ReplyDTO> reply=null;
		reply=replyService.list(bno);
		model.addAttribute("reply",reply);

		List<ReplyDTO> replyList=replyService.readReply(boardDTO.getBno());
		model.addAttribute("replyList", replyList);
		
		List<Map<String, Object>> fileList = boardService.selectFileList(boardDTO.getBno());
		model.addAttribute("file", fileList);
		return "board/consultation/readView";
	}
	
	
	// 게시판 수정뷰
		@RequestMapping(value = "/edit/{bno}", method = RequestMethod.GET)
		public String updateView(BoardDTO boardDTO, Model model) throws Exception{
			logger.info("updateView");

			model.addAttribute("update", boardService.read(boardDTO.getBno()));
			List<Map<String, Object>> fileList = boardService.selectFileList(boardDTO.getBno());
			model.addAttribute("file", fileList);
			return "board/consultation/updateView";
		}

		// 게시판 수정
		@RequestMapping(value = "/update/{bno}", method = RequestMethod.POST)
		public String update(BoardDTO boardDTO, int bno,RedirectAttributes rttr,
				 @RequestParam(value="fileNoDel[]") String[] files,
				 @RequestParam(value="fileNameDel[]") String[] fileNames,
				 MultipartHttpServletRequest mpRequest) throws Exception{
			logger.info("update");

			boardService.update(boardDTO, files, fileNames, mpRequest);

			return "redirect:/board/consultation/"+bno;
		}

		// 게시판 삭제
		@RequestMapping(value = "/delete/{bno}", method = RequestMethod.POST)
		public String delete(BoardDTO boardDTO) throws Exception{
			logger.info("delete");

			boardService.delete(boardDTO.getBno());

			return "redirect:/board/consultation";
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
	
    @RequestMapping(value ="/reply/delete/{rno}", method = RequestMethod.POST) //댓글 삭제  
    @ResponseBody
    private int mCommentServiceDelete(@PathVariable int rno) throws Exception{
    	logger.info("댓글 삭제");
        return replyService.deleteReply(rno);
    }
    
    @RequestMapping("/reply/edit/{rno}") //댓글 수정  
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
	
	

	//댓글 작성
	@ResponseBody
	@RequestMapping(value="/reply/create", method = RequestMethod.POST)
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
	        String userId =((MemberDTO)session.getAttribute("memberDTO")).getId();
	        comment.setBwriter(userName);
	        comment.setBwriterid(userId);
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
		return "board/consultation/setting";

	}
	//목록에서 mypage누르면 둘어감
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Model model, HttpSession session,  BoardDTO boardDTO, ReplyDTO replyDTO,@ModelAttribute("scri") SearchCriteria scri) throws Exception{
		System.out.println("111111111111111111111111111111111111111");
		System.out.println(session.getAttribute("memberDTO"));
		String userId =((MemberDTO)session.getAttribute("memberDTO")).getId();
		System.out.println("2222222222222222222222222222222222222222");
		model.addAttribute("list",boardService.list(scri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(boardService.listCount(scri));
		model.addAttribute("pageMaker", pageMaker);
		
		boardDTO.setBwriterid(userId);
	
		List<BoardDTO> ar =  boardService.mypagescrap(boardDTO);
		List<BoardDTO> ar2 =  boardService.myreply(boardDTO);
		List<BoardDTO> ar3 =  boardService.myboard(boardDTO);
		model.addAttribute("list2",ar);
		model.addAttribute("list3",ar2);
		model.addAttribute("list4",ar3);
		return "board/consultation/mypage";



	}
	//추천 기능
	@ResponseBody
	@RequestMapping(value = "/like", method = RequestMethod.POST)
	public int like(@RequestParam("bno") int bno, @RequestParam("likeuserid") String likeuserid) throws Exception{

		int likeCheck = boardService.likeCheck(bno, likeuserid);
		System.out.println("likeCheck");
		if(likeCheck == 0) {
			//좋아요 처음누름
			System.out.println("0");
			boardService.insertLike(bno, likeuserid); //like테이블 삽입
			boardService.updateLike(bno);	//게시판테이블 +1
			boardService.updateLikeCheck(bno, likeuserid);//like테이블 구분자 1
	
		}else if(likeCheck == 1) {
			System.out.println("3");
			boardService.updateLikeCheckCancel(bno, likeuserid); //like테이블 구분자0
			boardService.updateLikeCancel(bno); //게시판테이블 - 1
			boardService.deleteLike(bno, likeuserid); //like테이블 삭제
		}
		return likeCheck;
	}
	
	//스크랩 기능
	@ResponseBody
	@RequestMapping(value = "/scrap", method=RequestMethod.POST)
	public int scrap (@RequestParam("bno") int bno, @RequestParam("scrapuserid")String scrapuserid) throws Exception{
		int scrap = boardService.scrapCheck(bno, scrapuserid);
		if (scrap == 0) {
			boardService.scrap(bno, scrapuserid);
		}else if(scrap == 1) {
			boardService.scrapCancel(bno, scrapuserid);
		}
		return scrap;
	}
	@RequestMapping(value="/memberUpdateView", method = RequestMethod.GET)
	public String registerUpdateView() throws Exception{
		
		return "board/consultation/memberUpdateView";
	}
	//회원 정보 수정
	@RequestMapping(value="/memberUpdate", method = RequestMethod.POST)
	public String registerUpdate(MemberDTO memberDTO, HttpSession session) throws Exception{
		
		memberService.memberUpdate(memberDTO);
		return "redirect:/";
	}
	//파일 다운로드
	@RequestMapping(value="/fileDown")
	public void fileDown(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception{
		Map<String, Object> resultMap = boardService.selectFileInfo(map);
		String stofilename = (String) resultMap.get("STOFILENAME");
		String orgfilename = (String) resultMap.get("ORGFILENAME");
		
		// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\Users\\220302_humintec\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\humintecMVC\\src\\main\\webapp\\resources\\img\\"+stofilename));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(orgfilename, "UTF-8")+"\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
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