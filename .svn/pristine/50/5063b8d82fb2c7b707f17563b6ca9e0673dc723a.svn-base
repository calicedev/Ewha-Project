<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid">
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
		<form role="form" method="post" action="/board/consultation/save" enctype="multipart/form-data">
			<div class="mb-3">
				<label for="title" class="form-label">제목</label> <input class="form-control" type="text" id="title" name="title">
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">주제</label>
				<select class="form-control" id="theme" name="theme">
					<option value="none">=== 선택 ===</option>
					<option value="추억">추억</option>
					<option value="현장">현장</option>
					<option value="체험">체험</option>
					<option value="학습">학습</option>
					<option value="기억">기억</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="content" class="form-label">내용</label>
				<textarea class="form-control" id="myEditor" name="content" rows="6"></textarea>
			</div>
			<input type="hidden" id="bwriter" name="bwriter" value="${sessionScope.loginName}" /> 
			<input type="hidden" id="bwriterid" name="bwriterid" value="${sessionScope.loginId}" />
			
			<button class=" fileAdd_btn" type="button">파일추가</button>
			<br>
			<br>
			<table>
				<tr>
					<td id="fileIndex"></td>
				</tr>
			</table>
			<div>
				<br></br>
				<button class=" btn btn-dark" type="submit">저장</button>
			</div>
		</form>
	</main>
</div>
<script type="text/javascript">
	function fn_addFile() {
	var fileIndex = 1;
	//$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"<button type='button' style='float:right;' id='fileAddBtn'>"+"추가"+"</button></div>");
	$(".fileAdd_btn")
			.on(
					"click",
					function() {
						$("#fileIndex")
								.append(
										"<div><input type='file' style='float:left;' name='file_"
												+ (fileIndex++)
												+ "'>"
												+ "</button>"
												+ "<button type='button' style='float:right;' id='fileDelBtn'>"
												+ "삭제" + "</button></div>");
					});
	
	$(document).on("click", "#fileDelBtn", function() {
		$(this).parent().remove();

	});
	}
	
	$(document).ready(function() {
		fn_addFile();
	})

	
</script>