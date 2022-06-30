<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				
				location.href = "/";
						    
			})
		
			$("#submit").on("click", function(){
				if($("#password").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#password").focus();
					return false;
				}
				if($("#username").val()==""){
					alert("성명을 입력해주세요.");
					$("#username").focus();
					return false;
				}
			});
			
				
			
		})
	</script>
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
		<section id="container">
			<form action="/board/memberUpdate" method="post">
				<div class="form-group has-feedback mb-1">
					<label class="control-label" for="userid">아이디</label>
					<input class="form-control" type="text" id="userid" name="userid" value="${memberDTO.userid}" readonly="readonly"/>
				</div>
				<div class="form-group has-feedback mb-1">
					<label class="control-label" for="password">비밀번호</label>
					<input class="form-control" type="password" id="password" name="password" />
				</div>
				<div class="form-group has-feedback mb-1">
					<label class="control-label" for="username">성명</label>
					<input class="form-control" type="text" id="username" name="username" value="${memberDTO.username}" readonly="readonly"/>
				</div>
				<div class="form-group has-feedback">
					<label class="control-label" for="phone">핸드폰</label>
					<input class="form-control" type="text" id="phone" name="phone" value="${memberDTO.phone}"/>
				</div>
				<div class="form-group has-feedback mt-3">
					<button class="btn btn-success" type="submit" id="submit">회원정보수정</button>
					<button class="cencle btn btn-danger" type="button">취소</button>
				</div>
			</form>
		</section>
		</main>
	