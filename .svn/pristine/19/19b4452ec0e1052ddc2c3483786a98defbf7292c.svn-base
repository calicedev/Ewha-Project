<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    .id_ok{color: blue; display: none;}
    .id_already{color:red; display: none;}
    .password_ok{color: blue; display: none;}
    .password_diff{color:red; display: none;}
  
   </style>
   
     <c:choose>
	<c:when test='${result=="id"}'>
		<main class="form-signin">
			<form action="/member/login" method="post" id="login">
				<h1 class="h3 mb-3 fw-normal">아이디 찾기</h1>

				<div class="form-floating">
					<input type="text" class="form-control" id="username"
						name="username"> <label for="floatingInput">이름</label>
					<p id="birth_check" class="check"></p>
				</div>

				<input class="w-100 btn btn-lg btn-primary" type="button" id="idlosschk" value="아이디 찾기" />

			</form>
		</main>
	</c:when>
	  <c:otherwise>
		<main class="form-signin">
			<form action="/member/login" method="post" id="login">
				<h1 class="h3 mb-3 fw-normal">비밀번호 찾기</h1>
				<div class="form-floating">
					<input type="text" class="form-control" id="userid" name="userid">
					<label for="floatingInput">아이디</label>
					<p id="birth_check2" class="check"></p>
				</div>

				<input class="w-100 btn btn-lg btn-primary" type="button"
					id="pswdlosschk" value="비밀번호 찾기" />

			</form>
		</main>

	</c:otherwise>

         </c:choose> 

<script type="text/javascript">
    $(function(){
//     	console.log();
    	
//     	var obj = ${dto};
    	
//     	obj.birthday = '1';
//     	obj.checkbox = '2';
//     	obj.enabled  = '3';
//     	obj.id       = '4';
//     	obj.list     = '5';
//     	obj.password = '6';
//     	obj.phone    = '7';
//     	obj.userid   = '8';
//     	obj.username =  $('#username').val();
    	
//     	console.log(obj);
    	
        var idx 	= false;
        var pwx		= false;
        var birthx 	= false;
        var phonex	= false;
        var checkx	= false;


        $('#idlosschk').click(function(){

            var userName =  $('#username').val();
            var param = {username: userName};
        	 $.ajax({
                 type : 'POST',
                 url  : "/member/idlosschk",
                 data : param,
                 success: function (result) {
                    console.log(result);
                      if (result['userid']!=null) {
                    	  $('#birth_check').text(result['userid']);
                          $('#birth_check').css('color', 'blue');

                     } 
                     
                     else{
                    	  $('#birth_check').text('가입된 아이디가 없습니다.');
                          $('#birth_check').css('color', 'red');
                     }
                      
                    
                 },
                 error: function (request, status,error) {
                     console.log(request);
                     console.log(status);
                     console.log(error);

                 }
             });
        	 
          
        });
        
        $('#pswdlosschk').click(function(){

            var userId =  $('#userid').val();
            var param = {userid: userId};
        	 $.ajax({
                 type : 'POST',
                 url: "/member/pswdlosschk",
                 data: param,
                 success: function (result) {
      
                      if (result['password']!=null) {
                    	  $('#birth_check2').text(result['password']);
                          $('#birth_check2').css('color', 'blue');

                     } 
                     
                     else{
                    	  $('#birth_check2').text('가입된 아이디가 없습니다.');
                          $('#birth_check2').css('color', 'red');
                     }
                      
                      param =result;
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
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

