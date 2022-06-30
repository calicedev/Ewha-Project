package com.humintec.poc.controller;


import java.io.IOException;

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

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.humintec.poc.sns.NaverLoginBO;

/**
* Handles requests for the application home page.
*/
@Controller
public class LoginController {

/* NaverLoginBO */
private NaverLoginBO naverLoginBO;
private String apiResult = null;

@Autowired
private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
	this.naverLoginBO = naverLoginBO;
}

//�α��� ù ȭ�� ��û �޼ҵ�
@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
public String login(Model model, HttpSession session) {
	
	/* ���̹����̵�� ���� URL�� �����ϱ� ���Ͽ� naverLoginBOŬ������ getAuthorizationUrl�޼ҵ� ȣ�� */
	String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
	
	//https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
	//redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
	System.out.println("���̹�:" + naverAuthUrl);
	
	//���̹� 
	model.addAttribute("url", naverAuthUrl);

	return "login";
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
	String nickname = (String)response_obj.get("nickname");

	System.out.println(nickname);
	
	//4.�Ľ� �г��� �������� ����t
	session.setAttribute("sessionId",nickname); //���� ����
	
	model.addAttribute("result", apiResult);
    
	return "login";
}

//�α׾ƿ�
@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
public String logout(HttpSession session)throws IOException {
		System.out.println("����� logout");
		session.invalidate();

       
		return "redirect:index.jsp";
	}

}