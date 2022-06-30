<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
<h2 class="pb-2 border-bottom">공감공간</h2><br/>
<table id="example" class="display">
    <thead>
    <tr>
        <th>No</th>
        <th>주제</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성 시간</th>
    </tr>
    </thead>
    <tbody>
     <c:forEach items="${list}" var = "list">
	    <tr >
	        <td><c:out value="${list.bno}" /></td>
	        <td><c:out value="${list.theme}" /></td>
	        <td><a href="/board/readView?bno=${list.bno}"><c:out value="${list.title}"/></a></td>
	        <td><c:out value="${list.writer}" /></td>
	        <td><c:out value="${list.modifiedDate}" /></td>
	    </tr>
    </c:forEach>
   
</table>

 <c:choose>  
 <c:when test="${null != memberDTO}">
<div>
<button type="submit" id="write_btn" class="btn btn-dark">글쓰기</button> </div> <br>
</c:when>  
</c:choose>  

</main>
 
       <script>
        $().ready(function() {
            $('#example').DataTable(
            		{
            			  order: [[0, 'desc']],
            			  ordering: true,
            			  serverSide: false
       		});
         
	         $("#write_btn").on("click", function(){
	            event.preventDefault();
	            location.href = "/board/writeView";
	         })
	         
      })
   
   </script>
