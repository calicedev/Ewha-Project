<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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


<body class="text-center">

	<form class="form-signin" id="signFrm" role="form" action="/member/group" name="signFrm" method="get">
		<h1 class="h3 mb-3 font-weight-normal">회원가입</h1>
		<p>원활한 서비스 이용을 위해 <br>정보를 입력해주세요.</p>

		<div class=" abc">
			<label for="userid" class="sr-only"></label>
			<div style="float: left">
				<input type="text" id="userid" name="userid" class="form-control mb-1" placeholder="아이디" required>
			</div>
			<div style="float: left; margin-left: 10px; margin-top: 2px">
				<input class="btn btn-outline-primary btn-sm  idCheck" type="button" id="check" value="중복 체크" />
			</div>
			<span class="id_ok mb-1">사용 가능한 아이디입니다.</span> 
			<span class="id_already mb-1">누군가 이 아이디를 사용하고 있어요.</span>
		</div>
		 <input type="password" name="password" id="pw"
			placeholder="비밀번호" class="form-control mb-1" />
		<p id="pw2ch" class="check m-2"></p>
		<input type="password" id="pw2" placeholder="비밀번호 확인"
			class="form-control mb-1">
		<p id="pwch" class="check m-2"></p>
		<input type="text" id="username" name="username"
			class="form-control mb-2" placeholder="사용자 이름" />
		<div style="float: left;">
			<input type="text" class="form-control" name="birthday" id="unum1"
				size="10" maxlength="6" placeholder="주민등록번호"></input>
		</div>
		<div style="float: left;">
			<input type="password" class="form-control" name="birthday"
				id="unum2" size="10" maxlength="7">
		</div>
		<div>
			<input style="margin-top: 3px; margin-left: 1px; padding-bottom: 3px"
				type="button" value="검사"
				class="btn btn-outline-primary btn-sm  idCheck"
				onclick="validate();" />
		</div>
		<p id="birth_check" class="mt-3 check"></p>
		<input type="text" id="phone" name="phone" class="form-control"
			maxlength="13" placeholder="휴대폰번호-없이 입력" />
		<p id="phonech" class="mt-2 check "></p>

		<div></div>

		<div class="checkbox_group">

			<input type="checkbox" id="check_all" checked="checked"> <label for="check_all">전체 동의(선택항목 포함)</label><br> 
			<input type="checkbox" id="check_1" class="normal" checked="checked"> <label for="check_1">이용약관</label> <br />
			<textarea class="form-control" cols="28" rows="2"
				style="font-size: 1em;" readonly="readonly">서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 네이버 서비스의 이용과 관련하여 네이버 서비스를 제공하는 주식회사와 이를 이용하는서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
				서비스를 이용하시거나 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.다양한 서비스를 즐겨보세요. www.naver.com을 비롯한 도메인의 웹사이트 및 응용프로그램(어플리케이션, 앱)을 통해 정보 검색, 다른 이용자와의 커뮤니케이션, 콘텐츠 제공, 상품 쇼핑 등 여러분의 생활에 편리함을 더할 수 있는 다양한 서비스를 제공하고 있습니다.
				여러분은 PC, 휴대폰 등 인터넷 이용이 가능한 각종 단말기를 통해 각양각색의 네이버 서비스를 자유롭게 이용하실 수 있으며, 개별 서비스들의 구체적인 내용은 각 서비스 상의 안내, 공지사항, 웹고객센터(이하 ‘고객센터’) 도움말 등에서 쉽게 확인하실 수 있습니다.
				네이버 서비스에 로그인을 시도 또는 로그인하거나, 네이버 서비스 상에 게시물을 게재하거나, 네이버 서비스를 통해 커뮤니케이션하거나(예: 전자메일, 쪽지 등), 네이버 서비스에 게재된 회원의 아이디(ID), 게시물 등을 수집하거나, 네이버 검색 서비스에서 특정 질의어로 검색하거나 혹은 그 검색결과에서 특정 검색결과를 선택(이른바 ‘클릭’)하는 등 이용자(사람)의 실제 이용을 전제로 하는 네이버 서비스의 제공 취지에 부합하지 않는 방식으로 네이버 서비스를 이용하거나 이와 같은 네이버 서비스에 대한 어뷰징(남용) 행위를 막기 위한 네이버의 기술적 조치를 무력화하려는 일체의 행위(예: IP를 지속적으로 바꿔가며 접속하는 행위, Captcha를 외부 솔루션 등을 통해 우회하거나 무력화 하는 행위 등)를 시도해서는 안 됩니다.
				네이버의 동의 없이 자동화된 수단에 의해 서비스 상에 광고가 게재되는 영역 또는 그 밖의 영역에 부호, 문자, 음성, 음향, 그림, 사진, 동영상, 링크 등으로 구성된 각종 콘텐츠 자체 또는 파일을 삽입해서는 안 됩니다. 또한, 네이버 서비스 또는 이에 포함된 소프트웨어를 복사, 수정할 수 없으며, 이를 판매, 양도, 대여 또는 담보로 제공하거나 타인에게 그 이용을 허락해서는 안 됩니다. 네이버 서비스에 포함된 소프트웨어를 역 설계, 소스코드 추출 시도, 복제, 분해, 모방, 기타 변형하는 등의 행위도 금지됩니다(다만, 오픈소스에 해당되는 경우 그 자체 조건에 따릅니다). 그 밖에 바이러스나 기타 악성 코드를 업로드하거나 네이버 서비스의 원활한 운영을 방해할 목적으로 서비스 기능을 비정상적으로 이용하는 행위 역시 금지됩니다.</textarea>
			<br /> <input type="checkbox" id="check_2" class="normal" checked="checked"> <label for="check_2">개인정보 수집및 이용에 대한 안내</label> <br />
			<textarea class="form-control" cols="28" rows="2" style="font-size: 1em;" readonly="readonly">개인정보보호법에 따라 네이버에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.</textarea>
			<br /> <input type="checkbox" id="check_3" class="normal" name="checkbox" checked="checked"> <label for="check_3">이벤트, 광고성 정보안내(선택)</label> <br />
			<textarea class="form-control" cols="28" rows="2" cols="200" rows="2"
				style="font-size: 1em;" readonly="readonly">위치정보 이용약관에 동의하시면, 위치를 활용한 광고 정보 수신 등을 포함하는 네이버 위치기반 서비스를 이용할 수 있습니다.</textarea>
			<br />
		</div>
		<input type="button" class="btn btn-lg btn-primary btn-block" id="signUp" value="다음" />
<br><br>
	</form>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
    $(document).ready(function(){

        var idx = false;
        var pwx= false;
        var birthx = true;
        var phonex= false;
        var checkx=false;


        $('#signUp').click(function(){

            if(idx==false){
                alert("아이디 중복체크를 해주세요.");
                return;
            }

            else if(pwx==false){
                alert("비밀번호 확인을 해주세요.");
                return;
            }
            else if(birthx==false){
                alert("주민등록번호를 확인해주세요.");
                return;
            }
            else if($("#check_1").is(":checked") == false){
                alert("모든 약관에 동의 하셔야 다음 단계로 진행 가능합니다.");
                return;
            }else if($("#check_2").is(":checked") == false){
                alert("모든 약관에 동의 하셔야 다음 단계로 진행 가능합니다..");
                return;
            }
            else{
                $('#signFrm').submit();
            }
        });



        $("#pw2").blur(function(){
      
           if( $("#pw").val()==""){
                $("#pwch").html("비밀번호가 입력되지 않았습니다.");
                $("#pwch").css("color",'red');
                pwx = false;
            }
           else if( $("#pw2").val()!=$("#pw").val()){
                $("#pwch").html("비밀번호가 다릅니다");
                $("#pwch").css("color",'red');
                pwx = false;
            }else{
                $("#pwch").html("비밀번호가 일치합니다");
                $("#pwch").css("color",'blue');
                pwx = true;
            }
        });

        $("#pw").blur(function(){
         console.log( $("#pw").val()=="");
         console.log( $("#pw").val()!=$("#pw2").val());
           if( $("#pw").val()==""){
                $("#pwch").html("비밀번호가 입력되지 않았습니다.");
                $("#pwch").css("color",'red');
                pwx = false;
            }
           else if($("#pw").val()!=$("#pw2").val()){
                $("#pwch").html("비밀번호가 다릅니다");
                $("#pwch").css("color",'red');
                pwx = false;

            }else{
                $("#pwch").html("비밀번호가 일치합니다");
                $("#pwch").css("color",'blue');
                pwx = true;
            }
        });

        $('#birthday').blur(function(){
            var dateStr = $(this).val();
            var year = Number(dateStr.substr(0,4)); // 입력한 값의 0~4자리까지 (연)
            var month = Number(dateStr.substr(4,2)); // 입력한 값의 4번째 자리부터 2자리 숫자 (월)
            var day = Number(dateStr.substr(6,2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일)
            var today = new Date(); // 날짜 변수 선언
            var yearNow = today.getFullYear(); // 올해 연도 가져옴

            if (dateStr.length ==8) {
                // 연도의 경우 1900 보다 작거나 yearNow 보다 크다면 false를 반환합니다.
                if (1900 > year || year > yearNow){

                    $('#birth_check').text('생년월일을1 확인해주세요.');
                    $('#birth_check').css('color', 'red');

                }else if (month<1 || month>12) {

                    $('#birth_check').text('생년월일을2 확인해주세요.');
                    $('#birth_check').css('color', 'red');

                }else if (day<1 || day>31) {

                    $('#birth_check').text('생년월일을3 확인해주세요.');
                    $('#birth_check').css('color', 'red');

                }else if ((month==4 || month==6 || month==9 || month==11) && day==31) {

                    $('#birth_check').text('생년월일을 확인해주세요.');
                    $('#birth_check').css('color', 'red');

                }else if (month == 2) {

                    var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));

                    if (day>29 || (day==29 && !isleap)) {

                        $('#birth_check').text('생년월일을 확인해주세요.');
                        $('#birth_check').css('color', 'red');

                    }else{
                        $('#birth_check').text('');
                        birthx = true;
                    }

                }else{

                    $('#birth_check').text('');
                    birthx = true;
                }

            }else{
                //1.입력된 생년월일이 8자 초과할때 :  auth:false
                $('#birth_check').text('생년월일을 확인해주세요.');
                $('#birth_check').css('color', 'red');
            }
        });

        $("#phone").on('keydown', function(e){
            // 숫자만 입력받기
            var trans_num = $(this).val().replace(/-/gi,'');
            var k = e.keyCode;

            if(trans_num.length >= 11 && ((k >= 48 && k <=126) || (k >= 12592 && k <= 12687 || k==32 || k==229 || (k>=45032 && k<=55203)) ))
            {
                e.preventDefault();
            }
        }).on('blur', function(){ // 포커스를 잃었을때 실행합니다.
            if($(this).val() == '') return;

            // 기존 번호에서 - 를 삭제합니다.
            var trans_num = $(this).val().replace(/-/gi,'');

            // 입력값이 있을때만 실행합니다.
            if(trans_num != null && trans_num != '')
            {
                // 총 핸드폰 자리수는 11글자이거나, 10자여야 합니다.
                if(trans_num.length==11 || trans_num.length==10)
                {
                    // 유효성 체크
                    var regExp_ctn = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})([0-9]{3,4})([0-9]{4})$/;
                    if(regExp_ctn.test(trans_num))
                    {
                        // 유효성 체크에 성공하면 하이픈을 넣고 값을 바꿔줍니다.
                        trans_num = trans_num.replace(/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?([0-9]{3,4})-?([0-9]{4})$/, "$1-$2-$3");
                        $('#phonech').text('');
                        $(this).val(trans_num);
                    }
                    else
                    {
                        $('#phonech').text('유효하지 않는 전화번호입니다.');
                        $('#phonech').css('color', 'red');
                        $(this).val("");
                        $(this).focus();
                    }
                }
                else
                {
                    $('#phonech').text('유효하지 않는 전화번호입니다.');
                    $('#phonech').css('color', 'red');
                    $(this).val("");
                    $(this).focus();
                }
            }
        });


        $('#check').click(function(){

            var userId =  $('#userid').val();
            var param = {userid: userId};
            console.log("before ajax");
            $.ajax({
                type : 'GET',
                url: "/member/idDuplicationCheck",
                data: param,
                success: function (result) {
                   console.log(result*1);
                    // console.log(result["1"]);
                    if (result=="0") {
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

                    }
                },
                error: function (request, status,error) {
                    console.log(request);
                    console.log(status);
                    console.log(error);

                }
            });

        });
        
     // 체크박스 전체 선택
        $(".checkbox_group").on("click", "#check_all", function () {
            $(this).parents(".checkbox_group").find('input').prop("checked", $(this).is(":checked"));
            checkx=true;
        });

        // 체크박스 개별 선택
        $(".checkbox_group").on("click", ".normal", function() {
            var is_checked = true;

            $(".checkbox_group .normal").each(function(){
                is_checked = is_checked && $(this).is(":checked");
            });

            $("#check_all").prop("checked", is_checked);
        });
        
        
    });
    
    
    function YnCheck(obj) {
        var checked = obj.checked;
        if(checked){
           obj.value = "Y";
        }else{
           obj.value = "N";
        }
     };
     
     function validate() {
         var re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
         var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
         // 이메일이 적합한지 검사할 정규식

         var num1 = document.getElementById("unum1");
         var num2 = document.getElementById("unum2");

         var arrNum1 = new Array(); // 주민번호 앞자리숫자 6개를 담을 배열
         var arrNum2 = new Array(); // 주민번호 뒷자리숫자 7개를 담을 배열

         // -------------- 주민번호 -------------

         for (var i=0; i<num1.value.length; i++) {
             arrNum1[i] = num1.value.charAt(i);
         } // 주민번호 앞자리를 배열에 순서대로 담는다.

         for (var i=0; i<num2.value.length; i++) {
             arrNum2[i] = num2.value.charAt(i);
         } // 주민번호 뒷자리를 배열에 순서대로 담는다.

         var tempSum=0;

         for (var i=0; i<num1.value.length; i++) {
             tempSum += arrNum1[i] * (2+i);
         } // 주민번호 검사방법을 적용하여 앞 번호를 모두 계산하여 더함

         for (var i=0; i<num2.value.length-1; i++) {
             if(i>=2) {
                 tempSum += arrNum2[i] * i;
             }
             else {
                 tempSum += arrNum2[i] * (8+i);
             }
         } // 같은방식으로 앞 번호 계산한것의 합에 뒷번호 계산한것을 모두 더함

         if((11-(tempSum%11))%10!=arrNum2[6]) {
        	 $('#birth_check').text('올바른 주민등록 번호가 아닙니다.');
             $('#birth_check').css('color', 'red');
             num1.value = "";
             num2.value = "";
             num1.focus();
             return false;
         }else{
        	 $('#birth_check').text('올바른 주민등록 번호입니다.');
             $('#birth_check').css('color', 'blue');
             birthx = true;
         }
     }

     function check(re, what, message) {
         if(re.test(what.value)) {
             return true;
         }
         alert(message);
         what.value = "";
         what.focus();
         //return false;
     }

</script>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>

</body>
</html>