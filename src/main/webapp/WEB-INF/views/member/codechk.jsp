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
</style>
<div class="row text-center" style="width: 100%">
	<main style="width: 50%; float: none; margin: 0 auto">

		
			<h4 class="mb-3 fw-normal">
			 편지가 도착했어요!<br />짝꿍 연결 후 함께 열어봐요 :)
			</h4>
			<br>
			<svg class="bd-placeholder-img rounded-circle" width="120" height="120"  xmlns="https://www.logoyogo.com/web/wp-content/uploads/edd/2021/03/logoyogo-1-60.jpg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false">
				<title>Placeholder</title><rect width="100%" height="100%" fill="#777" /></svg>
			<br>
			<br>
			<h6>
				<strong>당신의 번호</strong>
			</h6>
			
			
        <input type="text" value="THE OUTPUT OF PRODUCT FUNCTION" id="myvalue" size=8 readonly><br/>
			<button onclick="copy_to_clipboard()" class="w-20 btn btn-lg btn-sm btn-primary mt-2" type="button" id="link-copy" value="공유하기" >공유하기</button>
		
		<br>
		<br>
		<h6>
			<strong>상대방의 번호를 알고 있어요!</strong>
		</h6>
		<input class="w-50 btn btn-xs btn checkBtn" style="text-decoration: underline;" type="button" id="id" name="pswdloss" value="입력하기" />
	</main>
</div>

<script type="text/javascript">
function product() {
	var text = "";
	var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	for (var i = 0; i < 8; i++)
		text += possible.charAt(Math.floor(Math.random()
				* possible.length));

	return text;
}
    document.getElementById('myvalue').value = product();
 </script>

<script type="text/javascript">
	$(function() {

		/* $('#loginbtn').click(function() {
			$('#login').submit();
		});
 */
		$(".checkBtn").click(function() {
			location.href = "/member/codechk2";
		});

		$(window).on('load', function() {
			$("#pwch").html(makeid());
			$("#pwch").css("text-decoration", 'underline');
		});
		
		
		function makeid() {
			var text = "";
			var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

			for (var i = 0; i < 8; i++)
				text += possible.charAt(Math.floor(Math.random()
						* possible.length));

			return text;
		}

	});
	
	
</script>
<script type="text/javascript">
function product() {
	var text = "";
	var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	for (var i = 0; i < 8; i++)
		text += possible.charAt(Math.floor(Math.random()
				* possible.length));

	return text;
}
    document.getElementById('myvalue').value = product();
 </script>
<script>
function copy_to_clipboard() {
  var copyText = document.getElementById("myvalue");
  copyText.select();
  document.execCommand("Copy");
  alert("클립보드 복사")
}
</script>