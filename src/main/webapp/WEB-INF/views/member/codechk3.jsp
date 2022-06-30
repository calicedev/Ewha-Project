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
<div class="row text-center" style="width: 100%">
	<main style="width: 50%; float: none; margin: 0 auto">
		<form action="/member/login" method="post" id="login">
			<h4 class="mb-3 fw-normal">짝꿍연결 완료!</h4>
			<br>
			<svg class="bd-placeholder-img rounded-circle" width="120" height="120" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false">
				<title>Placeholder</title><rect width="100%" height="100%" fill="#777" />
				<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
			<br>
			<br>
			<h6>
				<strong>임혜은-이지민</strong>
			</h6>
			<br> <input class="w-20 btn btn-lg btn-sm btn-primary checkBtn" type="button" id="loginbtn" value="확인" />
		</form>
	</main>
</div>



<script type="text/javascript">
	$(function() {

		$('#loginbtn').click(function() {
			$('#login').submit();
		});

		$(".checkBtn").click(function() {
			var id = this.id;
			var userName;
			if ("id" == id)
				userName = "Y";
			else
				userName = "N";
			location.href = "/index2";
		});

	});
</script>