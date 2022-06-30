<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid">
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<div class="container row d-flex justify-content-center" style="float: none; margin: 0">
		
			<div class="col-sm-4 text-center">
			<br>
				<svg class="bd-placeholder-img rounded-circle" width="140"height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false">
				<rect width="100%" height="100%" fill="#777" />
					<text x="50%" y="50%" fill="#777" dy=".3em"></text></svg>
				<h3>주제별 모아 보기</h3>
				<p>
					<a class="btn btn-secondary " href="/board/theme">View details &raquo;</a>
				</p>
			</div>
			<br />
			<div class="col-sm-4 text-center">
			<br>
				<svg class="bd-placeholder-img rounded-circle" width="140" height="140" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false">
					<rect width="100%" height="100%" fill="#777" /><text x="50%" y="50%" fill="#777" dy=".3em"></text></svg>
				<h3>나의 답변</h3>
				<c:choose>
					<c:when test="${null != memberDTO}">
						<p>
							<a class="btn btn-secondary" href="/board/myanswer">View details &raquo;</a>
						</p>
					</c:when>
					<c:otherwise>
						<p>
							<a href="/member/loginbtn">로그인</a>을 해주세요
						</p>
					</c:otherwise>
				</c:choose>
			</div>

		
	</div>
	<br> <br>


	<h5>새 글 소식</h5>
	<p>
		<a class="btn btn-outline-secondary btn-sm" href="/board/list"
			style="float: right;">더보기 &raquo;</a>
	</p>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">No</th>
				<th scope="col">제목</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<th scope="row"><c:out value="${list.bno}" /></th>
					<td><c:out value="${list.title}" /></td>
				</tr>
			</c:forEach>
	</table>

</main>
</div>
<script>
	$(document).ready(function() {
		$('#example').DataTable({
			order : [ [ 0, 'desc' ] ],
			ordering : true,
			serverSide : false
		});
	});
</script>
