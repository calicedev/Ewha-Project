package com.humintec.poc.controller;
import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.GroupDTO;
import com.humintec.poc.dto.MemberDTO;
import com.humintec.poc.service.MemberService;
import com.humintec.poc.sns.NaverLoginBO;


@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	
	 /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;
    
    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }
	
	@Autowired
	MemberService memberService;
	
	/*회원가입 로직 (회원을 DB에 집어 넣는 로직)
	 * signup.jsp 파일의 form과 연결되어 있음. post 방식.
	 * */
	
	@RequestMapping(method = RequestMethod.GET)
	public String signup() {
		return "member/signup";
	}
	
	//그룹체크하고 마지막 회원가입 하는 과정
	@RequestMapping(method = RequestMethod.POST)
	public String signup(MemberDTO dto, Model model) {
			memberService.signup(dto);
			String result = "member/login";
		return result;
	}
	
	//회원가입에서 다음버튼 누르면 넘어감. 그룹 확인 하러 가는 것
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public String group(MemberDTO dto, Model model) {
		//member의 정보를 hidden으로 받아서 넘김
		model.addAttribute("member",dto);
		 return "member/groupchk";
	}
	
	//그룹 확인
	@ResponseBody
	@RequestMapping(value="/groupCheck", method = RequestMethod.GET)
	public GroupDTO groupCheck(GroupDTO groupDTO) throws Exception {
		GroupDTO result = memberService.groupCheck(groupDTO);
		return result;
	}
	
	//로그인 하러 가는 것
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( Model model,HttpSession session) {
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		System.out.println("네이버:" + naverAuthUrl);
		model.addAttribute("url", naverAuthUrl);
		return "member/login";
	}
	
	/*로그인 하는 것
	 * 로그인 버튼 누르면 다음으로 넘어가냐 오류 알림창 뜨냐 하는 부분
	 * login.jsp의 form이랑 연결되어있음.
	 * */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberDTO dto, Model model, HttpSession session) {
		MemberDTO result=memberService.login(dto);
		String re="";
	      if(null == result){
	    	  model.addAttribute("message","ID나 PW가 틀립니다.");
	    	  model.addAttribute("memberDTO",null);
	         re= "member/login";
	      }
	      else{
	    	  session.setAttribute("loginName", result.getUsername());
	    	  session.setAttribute("loginId", result.getId());
	    	  session.setAttribute("memberDTO", result);
	    	  model.addAttribute("memberDTO",result);
	    	  System.out.println(result);
	  		
	    	  re= "redirect:/";
	    	  }
	      return re;
	}
	
	//네이버 로그인 성공시 callback호출 메소드

	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException {
		
		System.out.println("여기는 callback");
		OAuth2AccessToken oauthToken;
       oauthToken = naverLoginBO.getAccessToken(session, code, state);

       //1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken);  //String형식의 json데이터
		/** apiResult json 구조
		{"resultcode":"00",
		 "message":"success",
		 "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		**/
		
		//2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		
		//3. 데이터 파싱 
		//Top레벨 단계 _response 파싱
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		//response의 nickname값 파싱
		String nickname = (String)response_obj.get("name");
		String nickname2 = (String)response_obj.get("id");
		
		session.setAttribute("loginName", nickname);
  	  	session.setAttribute("loginId", nickname2);
  	  	session.setAttribute("memberDTO", response_obj);
  	  	model.addAttribute("memberDTO",response_obj);
		System.out.println(response_obj);
		return "index";
	}
	
	/*회원가입 아이디 중복확인
	 * signup.jsp 파일의 ajax와 연결되어 있음. post 방식.
	 * */
	@ResponseBody
	@RequestMapping(value="/idDuplicationCheck", method = RequestMethod.GET)
	public int idDuplicationCheck(MemberDTO dto) throws Exception {
		int result = memberService.idDuplicationCheck(dto);
		return result;
	}

	/*아이디 찾기
	 * */
	@ResponseBody
	@RequestMapping(value="/idlosschk", method = RequestMethod.POST)
	public MemberDTO idlosschk(MemberDTO dto) throws Exception {
		MemberDTO result = memberService.idlosschk(dto);
		return result;
	}
	
	/*비밀번호 찾기
	 * */
	@ResponseBody
	@RequestMapping(value="/pswdlosschk", method = RequestMethod.POST)
	public MemberDTO pswdlosschk(MemberDTO dto) throws Exception {
		MemberDTO result = memberService.pswdlosschk(dto);
		return result;
	}
	//아이디 분실
		@RequestMapping(value = "/loss", method = RequestMethod.GET)
		public String loss(Model model,HttpServletRequest request) {
			String result = request.getParameter("result");
			model.addAttribute("result",result);
			return "member/idlosschk";
		}
		
	
	//짝꿍 연결
	@RequestMapping(value = "/codechk", method = RequestMethod.GET)
	public String codechk() {
		return "member/codechk";
	}

	@RequestMapping(value = "/codechk2", method = RequestMethod.GET)
	public String codechk2() {
		return "member/codechk2";
	}
	@RequestMapping(value = "/codechk3", method = RequestMethod.GET)
	public String codechk3() {
		return "member/codechk3";
	}
	
	
	/*index 페이지에서 로그아웃 버튼 누르면 로그아웃 화면으로 이동
	 * index.jsp의 logout버튼과 연결되어 있음.
	 * */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(MemberDTO dto, Model model, HttpSession session) {
		session.invalidate();		
		model.addAttribute("memberDTO",null);
		System.out.println(session);
		return "redirect:/";
	}
	//로그인 페이지에서 아이디찾기 누르렴 넘어감
	//	@ResponseBody
	//	@RequestMapping(value = "/loss", method = RequestMethod.POST)
	//	public String idlosschkbtn(String pswdloss,String idloss,Model model,HttpServletRequest request) {
	//		String result = request.getParameter("userName");
	//		
	//		return result;
	//	}

	
	
	//	/*회원가입 로직 (뭔지 모르겠음)
	//	 * */
	//	@ResponseBody
	//	@RequestMapping(value = "/account/register", method = {RequestMethod.POST})
	//	public String registercheck(UserDTO dto, Model model) {
	//		memberService.loginUser( dto);
	//		return "1";
	//	}
		//로그인 페이지에서 아이디찾기 누르렴 넘어감
	//	@ResponseBody
	//	@RequestMapping(value = "/loss", method = RequestMethod.POST)
	//	public String idlosschkbtn(String pswdloss,String idloss,Model model,HttpServletRequest request) {
	//		String result = request.getParameter("userName");
	//		
	//		return result;
	//	}

	/*
	 * @RequestMapping(value = "/groupsave", method = {RequestMethod.POST}) public
	 * String groupsave(GroupDTO groupDTO, Model model,HttpSession session,MemberDTO
	 * memberDTO) { String userName
	 * =((MemberDTO)session.getAttribute("memberDTO")).getUsername();
	 * memberDTO.setUsername(userName); String result = "redirect:/"; return result;
	 * }
	 */
	
}
