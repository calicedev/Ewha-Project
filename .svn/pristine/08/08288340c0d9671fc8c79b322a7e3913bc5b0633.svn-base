<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container-fluid">
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
		<div><h2 class="pb-2 border-bottom"><a href="/board/consultation" style="text-decoration-line: none;color: black; ">공감공간</a></h2></div>
		<section id="container">
			<form role="form" method="get">
				<c:choose>
					<c:when test="${null != memberDTO}">
						<div><button type="submit" id="create_btn" class="btn btn-dark btn-sm mb-1">글쓰기</button></div>
					</c:when>
				</c:choose>
				
<div>
<table class="table table-striped">
     <c:forEach items="${list}" var = "list">


    <tr>
      <th  class="col-1" scope="row"><c:out value="${list.bno}" /></th>
      <td class="col-9" ><div id="stat" style="  max-width: 65%;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical; "  >${list.title}</div></td>
      <td class="col-2">
      
      <table>
		    <tr>
		      <td class="col"> <c:out value="${list.bwriter}" /></td>
		    </tr>
		    <tr>
		      <td class="col"><fmt:formatDate value="${list.modifiedDate}" pattern="yy/MM/dd"  /></td>
		    </tr>
	
	</table>
      </td>
    </tr>
   
    </c:forEach>
</table>
</div>

        
        
				<div class="search input-group text-center">
					<div style="width: 10%">
						<select class="form-control " name="searchType">
							<option value="n"
								<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
							<option value="t"
								<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
							<option value="c"
								<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
							<option value="w"
								<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
							<option value="tc"
								<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
						</select>
					</div>
					
					<input type="text" class="form-control" name="keyword" id="keywordInput" placeholder="Search" value="${scri.keyword}" />
					<div class="input-group-btn">
						<button class="btn btn-dark text-center" id="searchBtn" type="button">검색</button>
					</div>
				</div>
				<br>

				<ul class="pagination  justify-content-center">
					<c:if test="${pageMaker.prev}">
						<li class="page-item"><a class="page-link" href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}">prev</a></li>
					</c:if>

					<c:forEach begin="${pageMaker.startPage}"
						end="${pageMaker.endPage}" var="idx">
						<li class="page-item"><a class="page-link" href="consultation${pageMaker.makeSearch(idx)}">${idx}</a></li>
					</c:forEach>

					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li class="page-item"><a class="page-link" href="list${pageMaker.makeSearch(pageMaker.endPage + 1)}">next</a></li>
					</c:if>
				</ul>
			</form>
		</section>
	</main>
</div>

<script>
	$().ready(
			function() {
				$("#create_btn").on("click", function() {
					event.preventDefault();
					location.href = "/board/consultation/create";
				});

				$('#searchBtn').click(
						function() {
							self.location = "consultation"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword="
									+ encodeURIComponent($('#keywordInput')
											.val());
						});
			})
</script>
