<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid">
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
 <form name="updateForm" role="form" method="post" action="/board/update/${update.bno}" enctype="multipart/form-data">
    <input type="hidden" id="bno" name="bno" value="${update.bno}" />
    <input type="hidden" id="fileNoDel" name="fileNoDel[]" value=""> 
	<input type="hidden" id="fileNameDel" name="fileNameDel[]" value=""> 
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">제목</label>
	  <input class="form-control" type="text" id="title" name="title" value="${update.title}">
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlInput1" class="form-label">주제</label>
	  <select class="form-control" id="theme" name="theme" >
	  <option value="none">=== 선택 ===</option>
		  <option value="추억">추억</option>
		  <option value="현장">현장</option>
		  <option value="체험">체험</option>
		  <option value="학습">학습</option>
		  <option value="기억">기억</option>
	</select>
	 
	</div>
	<div class="mb-3">
	  <label for="exampleFormControlTextarea1" class="form-label">내용</label>
	  <textarea class="form-control" id="content" name="content" rows="6"><c:out value="${update.content}" /></textarea>
	</div>

	<button type="button" class="fileAdd_btn">파일추가</button><br>
	
	<table>
				<tr>
					<td id="fileIndex"></td>
				</tr>
			</table>
		<c:forEach var="file" items="${file}" varStatus="var">
		<div>
			<input type="hidden" id="FILE_NO" name="FILE_NO_${var.index}" value="${file.FILENO }">
			<input type="hidden" id="FILE_NAME" name="FILE_NAME" value="FILE_NO_${var.index}">
			<a href="#" id="fileName" onclick="return false;">${file.ORGFILENAME}</a>(${file.FILESIZE}kb)
			<button id="fileDel" onclick="fn_del('${file.FNO}','FILE_NO_${var.index}');" type="button">삭제</button><br>
		</div>
		</c:forEach>
	
	<div>
		<br></br>
      <button type="submit" id="update_btn" class="btn btn-dark">저장</button>
      <button type="submit" id="cancel_btn" class="btn btn-dark">취소</button>
      <br>
      
    </div>
</form>
</main>
</div>
     <script type="text/javascript">
      $(function(){
    	  
    	  var obj = ${update};
    	  $("#theme").val(obj.theme);
    	  
    	  $("#cancel_btn").on("click", function(){
            event.preventDefault();
            location.href = "/board/list";
         })
      })
 
   </script>
   
    
      <script type="text/javascript">
		$(document).ready(function(){
			
			$(document).on("click","#fileDel", function(){
				$(this).parent().remove();
			})
			
			fn_addFile();

	
		})
			
 		function fn_addFile(){
			var fileIndex = 1;
			//$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"<button type='button' style='float:right;' id='fileAddBtn'>"+"추가"+"</button></div>");
			$(".fileAdd_btn").on("click", function(){
				$("#fileIndex").append("<div><input type='file' style='float:left;' name='file_"+(fileIndex++)+"'>"+"</button>"+"<button type='button' style='float:right;' id='fileDelBtn'>"+"삭제"+"</button></div>");
			});
			$(document).on("click","#fileDelBtn", function(){
				$(this).parent().remove();
				
			});
		}
 		var fileNoArry = new Array();
 		var fileNameArry = new Array();
 		function fn_del(value, name){
 			
 			fileNoArry.push(value);
 			fileNameArry.push(name);
 			$("#fileNoDel").attr("value", fileNoArry);
 			$("#fileNameDel").attr("value", fileNameArry);
 		}
	</script>
