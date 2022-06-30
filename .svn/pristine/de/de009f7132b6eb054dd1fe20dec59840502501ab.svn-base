<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
 <form name="updateForm" role="form" method="post" action="/board/update">
    <input type="hidden" id="bno" name="bno" value="${update.bno}" />
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
	<div>
      <button type="submit" id="update_btn" class="btn btn-dark">저장</button>
      <button type="submit" id="cancel_btn" class="btn btn-dark">취소</button>
    </div>
</form>
</main>


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
   
    
      
