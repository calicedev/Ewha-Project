<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="container-fluid">
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
		<form name="readForm" role="form" method="post">
			<input type="hidden" id="bno" name="bno" value="${read.bno}" /> <input type="hidden" id="FNO" name="FNO" value="">
		</form>

		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">제목</label> 
			<input class="form-control" type="text" id="title" name="title" value="${read.title}" readonly="readonly"> 
			<input class="form-control" type="text" id="modifiedDate" name="modifiedDate" value="${read.modifiedDate}" readonly="readonly">
		</div>
		
		<div class="mb-3">
			<label for="exampleFormControlInput1" class="form-label">주제</label> 
			<input class="form-control" type="text" id="theme" name="theme" value="${read.theme}" readonly="readonly">
		</div>
		
		<div class="mb-3">
			<label for="exampleFormControlTextarea1" class="form-label">내용</label>
			<textarea class="form-control" id="content2" name="content2" readonly="readonly" rows="6"><c:out value="${read.content}" /></textarea>
		</div>
		
		<c:forEach var="file" items="${file}">
			<div class="inputArea">
				<label for="gdsImg">이미지</label> <img src="<spring:url value='/images/${file.STOFILENAME}'/>">
			</div>
			<hr>
			<span>파일 목록</span>
			<div class="form-group" style="border: 1px solid #dbdbdb;">
				<a href="#" onclick="fn_fileDown('${file.FNO}'); return false;">${file.ORGFILENAME}</a>(${file.FILESIZE})<br>
			</div>
			<hr>
		</c:forEach>
		
		<c:choose>
			<c:when test="${read.bwriterid == sessionScope.loginId}">
				<div>
					<button type="submit" id="edit_btn" class="btn btn-dark">수정</button>
					<button type="submit" id="delete_btn" class="btn btn-dark">삭제</button>
					<button type="submit" id="list_btn" class="btn btn-dark">목록</button>
				</div>
			</c:when>
		</c:choose>
		
			<br/> <br/>
		<div class="mb-3">
		<c:choose>
			<c:when test="${prevbno!=9999}">
			<button type="submit" id="prevbno_btn" class="btn btn-dark">이전글 </button>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${nextbno!=9999}">
			<button type="submit" id="nextbno_btn" class="btn btn-dark" style="float:right;">다음글</button>
			</c:when>
		</c:choose>
		</div>
		<br/>

		<c:if test="${sessionScope.loginId != read.bwriterid}">
			<input type="button" class="btn btn-warning " id="like" name="like" value="추천 ${read.likehit}">
			<input type="button" class="btn btn-success" id="scrap" name="like" value="스크랩">
		</c:if>
		
		<c:if test="${sessionScope.loginId == read.bwriterid}">
			<input type="button" class="btn btn-warning" disabled='disabled' id="like" name="like" value="추천 ${read.likehit}">
		
		</c:if>
		<br>
		<div class="card mt-3">
		
			<form name="commentInsertForm">
				<div class="input-group">
					<input type="hidden" name="bno" value="${read.bno}" />
					<div class="card-body bg-light">
						<input type="text" class="form-control" id="content" name="content" placeholder="댓글을 입력하세요.">
					</div>
					<button class="btn btn-dark btn-sm" type="button" name="commentInsertBtn">등록</button>
				</div>
			</form>
		</div>
		<br/>
		<div id="reply" class="card">
			<div class="replyList card-header">
				<div class="commentList"></div>
			</div>
		</div>
		<br />
		<br />
	</main>


</div>
<script type="text/javascript">
	var bno = '${read.bno}'; //게시글 번호

	$('[name=commentInsertBtn]').click(function(){ //댓글 등록 버튼 클릭시 
	   if($('#content').val()=="")
	      alert("댓글을 입력해주세요.");
	   else
	       var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져옴
	       commentInsert(insertData); //Insert 함수호출(아래)
	});


   $(function() {
      init();
      var formObj = $("form[name='readForm']");
      var testView2 = ${read};
      console.log(testView2);
      
      $("#content3").html(testView2.content);
      
      // 수정 
      $("#edit_btn").on("click", function() {
         formObj.attr("action", "/board/edit/"+bno);
         formObj.attr("method", "get");
         formObj.submit();
      })

      // 삭제
      $("#delete_btn").on("click", function() {
         formObj.attr("action", "/board/delete/"+bno);
         formObj.attr("method", "post");
         formObj.submit();
      })

      // 취소
      $("#list_btn").on("click", function() {
         location.href = "/board/consultation";
      })
      
      $("#like").on("click", function() {
         var bno = '${read.bno}';
         var likeuserid="${sessionScope.loginId}";
         var param = {
               bno : bno,
               likeuserid : likeuserid
         };
           $.ajax({
              type : "POST",  
                 url : "/board/like",
                 
                 data: param,
                 success : function(likeCheck){
                      if(likeCheck == 0){
                             console.log("추천완료.");
                             location.reload();
                          }
                          else if (likeCheck == 1){
                             console.log("추천취소");
                             location.reload();

                      }
                 }
             });
      })
	$("#prevbno_btn").on("click", function() {
         location.href = "/board/consultation/"+${prevbno};
      })
     $("#nextbno_btn").on("click", function() {
         location.href = "/board/consultation/"+${nextbno};
      })

      $("#scrap").on("click", function(){ 
         
         var bno = '${read.bno}';
         var scrapuserid="${sessionScope.loginId}";
         var param = {
               bno : bno,
               scrapuserid : scrapuserid
         };
           $.ajax({
                  type : "POST",  
                  url : "/board/scrap",       
                  
                  data :param,
                  error : function(){
                     alert("통신 에러");
                  },
                  success : function(scrap) {
                      
                           if(scrap == 0){
                        	   alert("스크랩완료");
                               location.reload();
                            
                           }else if(scrap == 1){
                        	   alert("스크랩취소");
                               location.reload();
                              
                           }
                          
                  }
              });
       })

      //댓글 삭제
      function commentDelete(rno){
         alert("삭제하시겠습니까?");
          $.ajax({
              url : '/board/delete/'+rno,
              type : 'post',
              success : function(data){
                  if(data == 1) commentList(bno); //댓글 삭제후 목록 출력 
              }
          });
      }
       
      
      //댓글 삭제 View
      //댓글 수정 View
      $(".delete_rbtn").click(function() {
         commentDelete(rno)
            });

      $(".close").click(function(e) {
         $('#testModal').modal("hide");

      });

      $(".delete5_rbtn").click(function(e) {
         var rno = $('#rno').val();
         var bno = $('#bno').val();
         var param = {
            username : rno,
            username2 : bno
         };
         return;
         $.ajax({
            type : 'POST',
            url : "/board/replyDelete",
            data : param,
            success : function(boardDTO) {
               $('#testModal').modal("hide");
               //                      replyList(boardDTO.bno);

            },
            error : function(request, status, error) {
               console.log(request);
               console.log(status);
               console.log(error);

            }
         });
      });
   });

   function init() {
      //댓글 ajax 로 그리기
      var bno = 0;
      replyList(bno);
   }
   function replyList(bno) {
      //ajax 실헹  >> 댓글 리스트 출력
   }
   
   $(document).ready(function(){
       commentList(); //페이지 로딩시 댓글 목록 출력 
   });
    
   function commentList(){
      var bno = $('#bno').val();
      var param = {
            bno : bno
      };
       $.ajax({
           url : "/board/readView2",
           type : 'post',
           data : param,
           success : function(data){
              console.log(${read.likehit});
              console.log("여기까지 찍힘");
              var a =''; 
               $.each(data, function(key, value){ 
                    a += '<div class="card">';
                      a += '<div class="card-body">';
                      a += '<div class="commentInfo'+value.rno+'">'+value.bwriter;
                      if  (value.bwriter == ${memberDTO}.username){
                      a += '<button onclick="commentUpdate('+value.rno+',\''+value.content+'\');" style="float: right; margin-right:1px;" class="btn btn-dark btn-sm"> 수정 </button>';
                      a += '<button onclick="commentDelete('+value.rno+');"  style="float: right;  margin-right:1px;" class="btn btn-dark btn-sm"> 삭제 </button> </div>';}
                      a += '<div class="commentContent'+value.rno+'"> <p>'+value.content +'</p>';
                      a += '</div></div></div>';
               });
               
               $(".commentList").html(a);
           }
       });
   }
   
   function commentInsert(insertData){
       $.ajax({
           url : '/board/reply/create',
           type : 'post',
           data : insertData,
           success : function(data){
               if(data == 1) {
                   commentList(); //댓글 작성 후 댓글 목록 reload
                   $('[name=content]').val('');
               }
           }
       });
   }


   
   function commentUpdate(rno, content){
       var a ='';
       a += '<br>';
       a += '<div class="input-group">';
       a += '<input type="text" class="form-control" name="content_'+rno+'" value="'+content+'"/>';
       a += '<span class="input-group-btn"><button class="btn btn-default btn-sm" type="button" onclick="commentUpdateProc('+rno+');">수정</button> </span>';
       a += '</div>';
       
       $('.commentContent'+rno).html(a);
       
   }
   function commentUpdate2(rno, content){
       if (!confirm("수정 하시겠습니까?")) {
              return;
           } else {
              commentUpdate(rno,content);
              status=True;
           }
       
   }
   
   //댓글 수정
   function commentUpdateProc(rno){
       var updateContent = $('[name=content_'+rno+']').val();
       $.ajax({
           url : '/board/reply/edit/'+rno,
           type : 'post',
           data : {'content' : updateContent, 'rno' : rno},
           success : function(data){
               if(data == 1) commentList(bno); //댓글 수정후 목록 출력 
           }
       });
   }
   
   function commentDelete(rno){
      alert("삭제합니다");
       $.ajax({
           url : '/board/reply/delete/'+rno,
           type : 'post',
           success : function(data){
        	   alert("삭제!!!");
               if(data == 1) commentList(bno); //댓글 삭제후 목록 출력 
           }
       });
   }
   function fn_fileDown(fileNo){
      var formObj = $("form[name='readForm']");
      $("#FNO").attr("value", fileNo);
      formObj.attr("action", "/board/fileDown");
      formObj.submit();
   }
    
   
   
</script>

