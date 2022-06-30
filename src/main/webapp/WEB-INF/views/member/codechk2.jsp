<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
html, body {
	height: 100%;
}

@font-face {
	font-family: 'LotteMartDream';
	font-style: normal;
	font-weight: 400;
	src:
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff2')
		format('woff2'),
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamMedium.woff')
		format('woff');
}

@font-face {
	font-family: 'LotteMartDream';
	font-style: normal;
	font-weight: 700;
	src:
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamBold.woff2')
		format('woff2'),
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamBold.woff')
		format('woff');
}

@font-face {
	font-family: 'LotteMartDream';
	font-style: normal;
	font-weight: 300;
	src:
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff2')
		format('woff2'),
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/lottemart/LotteMartDream/LotteMartDreamLight.woff')
		format('woff');
}

.lottemartdream * {
	font-family: 'LotteMartDream', sans-serif;
}

body {
	display: flex;
	align-items: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
	font-family: 'LotteMartDream';
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

.id_ok {
	color: blue;
	display: none;
}

.id_already {
	color: red;
	display: none;
}

.password_ok {
	color: blue;
	display: none;
}

.password_diff {
	color: red;
	display: none;
}
</style>
<main class="form-signin">

		<h4 class="mb-3 fw-normal">짝꿍의 번호를 입력해주세요</h4>
		<div class="form-floating">
			<input type="text" class="form-control" id="cl" > <label for="cl">번호 입력</label>
		</div>
		<br>
		<input class="w-100 btn btn-lg btn-primary checkBtn" type="button" id="loginbtn" value="연결하기" /> <br>
		<br>
	
</main>


<script type="text/javascript">
   $(function(){
	
        
        $(".checkBtn").click(function() {
        	if($('#cl').val() == ""){
		          alert("번호를 입력해주세요.");
		      }
        	else{location.href="/member/codechk3";}
		
		});
    });
</script>