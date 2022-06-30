package com.humintec.poc.controller;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.humintec.poc.dto.BoardDTO;
import com.humintec.poc.dto.Criteria;
import com.humintec.poc.dto.MemberDTO;
import com.humintec.poc.dto.SearchCriteria;
import com.humintec.poc.dto.User;
import com.humintec.poc.service.BoardService;
import com.humintec.poc.service.MemberService;

@Controller
public class HomeController {

	@Autowired
	MemberService memberService;
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(MemberDTO dto, Model model, HttpSession session,SearchCriteria scri) throws Exception{
		
		
		model.addAttribute("list", boardService.list(scri));

		
		MemberDTO result=(MemberDTO)session.getAttribute("memberDTO");
		System.out.println(result);
		if(null == result){
			model.addAttribute("memberDTO",null);
		}else{
			model.addAttribute("memberDTO",result);
		}
		
		
		
		return "index";
	}

	// index2 게시판 
		@RequestMapping(value = "/index2", method = RequestMethod.GET)
		public String index2(Model model,HttpSession session,BoardDTO boardDTO,SearchCriteria scri) throws Exception{
			
			model.addAttribute("list", boardService.list(scri));
			return "index2";
			
		}
	
		
		//안드로이드
		@PostMapping(value="android")
		@ResponseBody
		public String androidResponse(@RequestBody MemberDTO dto, Model model, HttpSession session) {
			MemberDTO result=memberService.login(dto);
			String re="";
		      if(null == result){
		    	  model.addAttribute("message","ID나 PW가 틀립니다.");
		    	  model.addAttribute("memberDTO",null);
		         re= "실패";
		      }else{
		    	  session.setAttribute("loginName", result.getUsername());
		    	  session.setAttribute("loginId", result.getUserid());
		    	  session.setAttribute("memberDTO", result);
		    	  System.out.println(session);
		    	  model.addAttribute("memberDTO",result);
		    	  re= "성공";
		    	  }
		      System.out.println(re);
		      return re;
		      
		
		}
	
		
		
}
