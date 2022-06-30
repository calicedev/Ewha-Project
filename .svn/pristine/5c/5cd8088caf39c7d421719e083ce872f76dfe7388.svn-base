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
	<form action="/member" method="post" id="login" >
		<input type="hidden" id="username" name="username" value="${member.username}" />
		<input type="hidden" id="userid" name="userid" value="${member.userid}" />
		<input type="hidden" id="password" name="password" value="${member.password}" />
		<input type="hidden" id="birthday" name="birthday" value="${member.birthday}" />
		<input type="hidden" id="phone" name="phone" value="${member.phone}" />
		<input type="hidden" id="checkbox" name="checkbox" value="${member.checkbox}" />
		
		<h1 class="h3 mb-3 fw-normal">
			소속기관의 번호를 <br />입력해주세요
		</h1>
		<div class="form-floating">
			<input type="text" class="form-control" name="gnum" id="gnum"> <label for="floatingInput">소속기관</label> 
			<p id="pwch" class="check m-2"></p>
		</div>

		<input class="w-100 btn btn-lg btn-primary mb-1" type="button" id="loginbtn" value="소속기관확인" /> <br>
		<input class="w-100 btn btn-lg btn-dark" type="button" id="loginbtn2" value="연결하기" /> <br>
		<br>
	</form>

</main>


<script type="text/javascript">

	var checkx=false;
	$(function() {
		 $('#loginbtn2').click(function() {
			 if(checkx==false){
	                alert("소속 기관 확인을 해주세요.");
	                return;
	            }
			 else{
				 $('#login').submit();
			 }
			
		});
 
		
		 $('#loginbtn').click(function(){

	            var gNum =  $('#gnum').val();
	            var param = {gnum: gNum};
	            console.log("before ajax");
	            $.ajax({
	                type : 'GET',
	                url: "/member/groupCheck",
	                data: param,
	                success: function (result) {
	                	var group=result.gname;
	                	if (group != null){
	                	 $("#pwch").html("소속기관: "+ group);
	                     $("#pwch").css("color",'blue');
	                     checkx = true;
	                     }
	                	else{
	                		$("#pwch").html("소속 기관이 확인되지 않았습니다. ");
		                     $("#pwch").css("color",'red');
	                	}
	                  
	                    /* if (result=="0") {
	                        idx=true;
	                        $('.id_ok').css("display","inline-block");
	                        $('.id_already').css("display", "none");


	                    } 
	                    
	                    else if (result==0){
	                    	alert("입력 안돼");
	                    }
	                    
	                    else {
	                        idx=false
	                        $('.id_already').css("display","inline-block");
	                        $('.id_ok').css("display", "none");
	                        $("#userid").focus();

	                    } */
	                },
	                error: function (request, status,error) {
	                    console.log(request);
	                    console.log(status);
	                    console.log(error);

	                }
	            });

	        });
 
		
	});
</script>