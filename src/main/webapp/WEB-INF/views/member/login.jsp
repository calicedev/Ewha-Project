<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
       <style>
html,
body {
  height: 100%;
}
@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 400;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff') format('woff');
}
@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 700;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamBold.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamBold.woff') format('woff');
}
@font-face {
  font-family: 'LotteMartDream';
  font-style: normal;
  font-weight: 300;
  src: url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff2') format('woff2'), url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff') format('woff');
}
.lottemartdream * {
 font-family: 'LotteMartDream', sans-serif;
}
body {
  font-family: 'LotteMartDream';
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
    .id_ok{color: blue; display: none;}
    .id_already{color:red; display: none;}
    .password_ok{color: blue; display: none;}
    .password_diff{color:red; display: none;}
  
   </style>
<main class="form-signin">
  <form action="/member/login" method="post" id="login">
    <h1 class="h3 mb-3 fw-normal">Please Login!</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" name="userid">
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control mt-2" id="floatingPassword" name="password">
      <label for="floatingPassword">비밀번호</label>
      <font color="red" class="mb-1">${message}</font>
    </div>
    <input class="w-100 btn btn-lg btn-primary" type="button" id="loginbtn" value="로그인"/>
    <input class="w-100 btn btn-lg btn-dark mt-2" type="button" id="signupbtn"  value="회원가입"/>
    <br><br>
    </form>
   	 <input class="w-100 btn btn-xs btn findIdPassword" type="button"  id="id" name="pswdloss" value="ID 찾기"/>
     <input class="w-100 btn btn-xs btn findIdPassword" type="button" id="pw" name="pswdloss" value="비밀번호 찾기"/>
 
 	
			<!-- 네이버 로그인 창으로 이동 -->
			<div id="naver_id_login" style="text-align:center"><a href="${url}">
			<img width="223" src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png"/></a></div>
			<br>

</main>


<script type="text/javascript">
   $(function(){
	   $('#loginbtn').click(function(){
        	$('#login').submit();
        });
        
        $(".findIdPassword").click(function() {
			var id = this.id;
			var result;
			if("id"==id)result = "id";
			else		result = "password";
			location.href="/member/loss?result="+result;
		});
		$("#signupbtn").click(function() {
			
			location.href="/member";
		});
    	
    });
    
</script>