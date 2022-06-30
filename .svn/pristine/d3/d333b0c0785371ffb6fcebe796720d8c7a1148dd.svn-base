<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <style>
    @import url("https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css");
    </style>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

<h2 class="pb-2 border-bottom"><i class="bi bi-bell"></i> 알림</h2><br/>
	<div class="row" style="float: none; margin: 0">
	
			<div id="reply" class="card">
			<div class="replyList card-header">
				<c:forEach items="${list}" var="list">
					<ul class="list-group">
						<li class="list-group-item d-flex justify-content-between">
							<div>${list.sender} 님으로부터의 친구 신청</div>
						
								<p><a class="btn btn-sm btn-warning " id="all" href="/member/codechk?=${list.sender}"> &raquo;</a></p>
								<!-- <button type="button" class="btn btn-dark btn-sm friendchk">삭제</button> -->
							
						</li>
					</ul>
				</c:forEach>
			</div>
		</div>
			
		
		</div>
	<br> <br>
</main>

<script type="text/javascript">
	$(function() {
		// 취소
		$(".friendchk").on("click", function() {

			location.href = "/member/codechk";
		})

	



	});


</script>


