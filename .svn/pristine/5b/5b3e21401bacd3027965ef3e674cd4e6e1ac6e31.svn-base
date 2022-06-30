<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
   <form role="form" method="post" action="/board/write">
		<div class="mb-3">
		  <label for="title" class="form-label">제목</label>
		  <input class="form-control" type="text" id="title" name="title">
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
		  <textarea class="form-control" id="content" name="content" rows="6"></textarea>
		</div>

		<input type="hidden" id="writer" name="writer" value="${sessionScope.loginId}" />
<div>
	<button class=" btn btn-dark" type="submit" >저장</button>
</div>
</form>

</main>
   
    
      
