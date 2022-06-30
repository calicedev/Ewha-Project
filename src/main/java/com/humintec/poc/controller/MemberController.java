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
	
	/*ȸ������ ���� (ȸ���� DB�� ���� �ִ� ����)
	 * signup.jsp ������ form�� ����Ǿ� ����. post ���.
	 * */
	
	@RequestMapping(method = RequestMethod.GET)
	public String signup() {
		return "member/signup";
	}
	
	//�׷�üũ�ϰ� ������ ȸ������ �ϴ� ����
	@RequestMapping(method = RequestMethod.POST)
	public String signup(MemberDTO dto, Model model) {
			memberService.signup(dto);
			String result = "member/login";
		return result;
	}
	
	//ȸ�����Կ��� ������ư ������ �Ѿ. �׷� Ȯ�� �Ϸ� ���� ��
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public String group(MemberDTO dto, Model model) {
		//member�� ������ hidden���� �޾Ƽ� �ѱ�
		model.addAttribute("member",dto);
		 return "member/groupchk";
	}
	
	//�׷� Ȯ��
	@ResponseBody
	@RequestMapping(value="/groupCheck", method = RequestMethod.GET)
	public GroupDTO groupCheck(GroupDTO groupDTO) throws Exception {
		GroupDTO result = memberService.groupCheck(groupDTO);
		return result;
	}
	
	//�α��� �Ϸ� ���� ��
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( Model model,HttpSession session) {
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		System.out.println("���̹�:" + naverAuthUrl);
		model.addAttribute("url", naverAuthUrl);
		return "member/login";
	}
	
	/*�α��� �ϴ� ��
	 * �α��� ��ư ������ �������� �Ѿ�� ���� �˸�â �߳� �ϴ� �κ�
	 * login.jsp�� form�̶� ����Ǿ�����.
	 * */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberDTO dto, Model model, HttpSession session) {
		MemberDTO result=memberService.login(dto);
		String re="";
	      if(null == result){
	    	  model.addAttribute("message","ID�� PW�� Ʋ���ϴ�.");
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
	
	//���̹� �α��� ������ callbackȣ�� �޼ҵ�

	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException {
		
		System.out.println("����� callback");
		OAuth2AccessToken oauthToken;
       oauthToken = naverLoginBO.getAccessToken(session, code, state);

       //1. �α��� ����� ������ �о�´�.
		apiResult = naverLoginBO.getUserProfile(oauthToken);  //String������ json������
		/** apiResult json ����
		{"resultcode":"00",
		 "message":"success",
		 "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
		**/
		
		//2. String������ apiResult�� json���·� �ٲ�
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		
		//3. ������ �Ľ� 
		//Top���� �ܰ� _response �Ľ�
		JSONObject response_obj = (JSONObject)jsonObj.get("response");
		//response�� nickname�� �Ľ�
		String nickname = (String)response_obj.get("name");
		String nickname2 = (String)response_obj.get("id");
		
		session.setAttribute("loginName", nickname);
  	  	session.setAttribute("loginId", nickname2);
  	  	session.setAttribute("memberDTO", response_obj);
  	  	model.addAttribute("memberDTO",response_obj);
		System.out.println(response_obj);
		return "index";
	}
	
	/*ȸ������ ���̵� �ߺ�Ȯ��
	 * signup.jsp ������ ajax�� ����Ǿ� ����. post ���.
	 * */
	@ResponseBody
	@RequestMapping(value="/idDuplicationCheck", method = RequestMethod.GET)
	public int idDuplicationCheck(MemberDTO dto) throws Exception {
		int result = memberService.idDuplicationCheck(dto);
		return result;
	}

	/*���̵� ã��
	 * */
	@ResponseBody
	@RequestMapping(value="/idlosschk", method = RequestMethod.POST)
	public MemberDTO idlosschk(MemberDTO dto) throws Exception {
		MemberDTO result = memberService.idlosschk(dto);
		return result;
	}
	
	/*��й�ȣ ã��
	 * */
	@ResponseBody
	@RequestMapping(value="/pswdlosschk", method = RequestMethod.POST)
	public MemberDTO pswdlosschk(MemberDTO dto) throws Exception {
		MemberDTO result = memberService.pswdlosschk(dto);
		return result;
	}
	//���̵� �н�
		@RequestMapping(value = "/loss", method = RequestMethod.GET)
		public String loss(Model model,HttpServletRequest request) {
			String result = request.getParameter("result");
			model.addAttribute("result",result);
			return "member/idlosschk";
		}
		
	
	//¦�� ����
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
	
	
	/*index ���������� �α׾ƿ� ��ư ������ �α׾ƿ� ȭ������ �̵�
	 * index.jsp�� logout��ư�� ����Ǿ� ����.
	 * */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(MemberDTO dto, Model model, HttpSession session) {
		session.invalidate();		
		model.addAttribute("memberDTO",null);
		System.out.println(session);
		return "redirect:/";
	}
	//�α��� ���������� ���̵�ã�� ������ �Ѿ
	//	@ResponseBody
	//	@RequestMapping(value = "/loss", method = RequestMethod.POST)
	//	public String idlosschkbtn(String pswdloss,String idloss,Model model,HttpServletRequest request) {
	//		String result = request.getParameter("userName");
	//		
	//		return result;
	//	}

	
	
	//	/*ȸ������ ���� (���� �𸣰���)
	//	 * */
	//	@ResponseBody
	//	@RequestMapping(value = "/account/register", method = {RequestMethod.POST})
	//	public String registercheck(UserDTO dto, Model model) {
	//		memberService.loginUser( dto);
	//		return "1";
	//	}
		//�α��� ���������� ���̵�ã�� ������ �Ѿ
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
