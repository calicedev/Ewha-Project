<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="container-fluid">	
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">


	<div class="row" style="float: none; margin: 0">
		<div class="d-flex justify-content-center">
			<div class="col-lg-4">
				<svg class="bd-placeholder-img rounded-circle" width="140"
					height="140" xmlns="http://www.w3.org/2000/svg" role="img"
					aria-label="Placeholder: 140x140"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#777" />
					<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
				<h3>주제별 모아 보기</h3>
				<p>
					<a class="btn btn-secondary " href="/board/theme">View details
						&raquo;</a>
				</p>
			</div>
			<br />
			<div class="col-lg-4">
				<svg class="bd-placeholder-img rounded-circle" width="140"
					height="140" xmlns="http://www.w3.org/2000/svg" role="img"
					aria-label="Placeholder: 140x140"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#777" />
					<text x="50%" y="50%" fill="#777" dy=".3em">140x140</text></svg>
				<h3>나의 답변</h3>
				<c:choose>
					<c:when test="${null != memberDTO}">
						<p>
							<a class="btn btn-secondary" href="/board/myanswer">View
								details &raquo;</a>
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

	<div class="modal fade" id="testModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">

					<button class="delete_rbtn"  type="button" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true"  >X</span>
					</button>
				</div>
				<div class="modal-body">
					아직 답변을 작성하지 않았습니다. 답변을 작성하시겠습니까? <br />(미작성시 공감게시판 확인 불가)
				</div>
				<div class="modal-footer">
					<section id="container">
						<div>
							<input type="button" class="delete_rbtn" name="delete" value="괜찮아요" /> 
							<input type="button" class="cancel_rbtn" name="delete" value="작성할게요" />
						</div>

					</section>
				</div>
			</div>
		</div>

	</div>

</main>
</div>
<script type="text/javascript">
	$().ready(function() {
		$('#example').DataTable({
			order : [ [ 0, 'desc' ] ],
			ordering : true,
			serverSide : false
		});
	});

	$(".cancel_rbtn").click(function() {
		location.href = "/board/list";
	});
	$(".delete_rbtn").click(function() {
		$('#testModal').modal('hide');
	});

	$(window).on('load', function() {
		$('#testModal').modal('show');
	});
</script>