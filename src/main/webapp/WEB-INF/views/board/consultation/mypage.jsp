<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <style type="text/css">
        
       
        /*TAB CSS*/

        ul.tabs {
            margin: 0;
            padding: 0;
            float: left;
            list-style: none;
            height: 32px; /*--Set height of tabs--*/
            border-bottom: 1px solid #999;
            border-left: 1px solid #999;
            width: 100%;
        }
        ul.tabs li {
            float: left;
            margin: 0;
            padding: 0;
            height: 31px; /*--Subtract 1px from the height of the unordered list--*/
            line-height: 31px; /*--Vertically aligns the text within the tab--*/
            border: 1px solid #999;
            border-left: none;
            margin-bottom: -1px; /*--Pull the list item down 1px--*/
            overflow: hidden;
            position: relative;
            background: #e0e0e0;
        }
        ul.tabs li a {
            text-decoration: none;
            color: #000;
            display: block;
            font-size: 1.2em;
            padding: 0 20px;
            /*--Gives the bevel look with a 1px white border inside the list item--*/
            border: 1px solid #fff; 
            outline: none;
        }
        ul.tabs li a:hover {
            background: #ccc;
        }
        html ul.tabs li.active, html ul.tabs li.active a:hover  {
             /*--Makes sure that the active tab does not listen to the hover properties--*/
            background: #fff;
            /*--Makes the active tab look like it's connected with its content--*/
            border-bottom: 1px solid #fff; 
        }

        /*Tab Conent CSS*/
        .tab_container {
            border: 1px solid #999;
            border-top: none;
            overflow: hidden;
            clear: both;
            float: left; 
            width: 100%;
            background: #fff;
        }
        .tab_content {
            padding: 20px;
            font-size: 1.2em;
        }
    </style>
    
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
<h2 class="pb-2 border-bottom">마이페이지</h2><br/>
<button class="btn btn-dark mb-2" id="memberUpdateBtn" type="button">회원정보수정</button>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" data-bs-toggle="tab" aria-current="page" href="#home">내가 쓴글</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-bs-toggle="tab" href="#menu1">나의 답변</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-bs-toggle="tab" href="#menu2">스크랩</a>
  </li>
</ul>

<!-- Tab panes -->
  <div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
      <h3>내가 쓴글</h3>
      <section id="container">
			<form role="form" method="get">
				<div>
					<!-- <div style="max-width: 20%;"> -->
					<table class="table table-striped" style=" vertical-align: middle;">
						<c:forEach items="${list4}" var="list">
							<tr>
								<th class="col-1" scope="row" style=" text-align: center;"><c:out value="${list.bno}" /></th>
								<td class="col-9">
									<div id="stat"
										style="overflow: hidden; text-overflow: ellipsis; display: -webkit-box; -webkit-line-clamp: 2; -webkit-box-orient: vertical;">
										<a href="/board/consultation/${list.bno}"
											style="text-decoration-line: none; color: black;">${list.title}</a>
									</div>
								</td>
								<td class="col-2" style=" text-align: center;">
									<table style=" text-align: center; margin: auto;">
										<tr>
											<td class="col" style=" text-align: center;"><c:out value="${list.bwriter}" /></td>
										</tr>
										<tr>
											<td class="col" style=" text-align: center;"><fmt:formatDate
													value="${list.modifiedDate}" pattern="yy/MM/dd" /></td>
										</tr>
									</table>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</form>
		</section>
    </div>
    <div id="menu1" class="container tab-pane fade"><br>
      <h3>나의 답변</h3>
      <section id="container">
			<form role="form" method="get">
				<div>
					<!-- <div style="max-width: 20%;"> -->
					<table class="table table-striped" style=" vertical-align: middle;">
						<c:forEach items="${list3}" var="list">
							<tr>
								<th class="col-1" scope="row" style=" text-align: center;"><c:out value="${list.bno}" /></th>
								<td class="col-9">
									<div id="stat"
										style="overflow: hidden; text-overflow: ellipsis; display: -webkit-box; -webkit-line-clamp: 2; -webkit-box-orient: vertical;">
										<a href="/board/consultation/${list.bno}"
											style="text-decoration-line: none; color: black;">${list.title}</a>
									</div>
								</td>
								<td class="col-2" style=" text-align: center;">
									<table style=" text-align: center; margin: auto;">
										<tr>
											<td class="col" style=" text-align: center;"><c:out value="${list.bwriter}" /></td>
										</tr>
										<tr>
											<td class="col" style=" text-align: center;"><fmt:formatDate
													value="${list.modifiedDate}" pattern="yy/MM/dd" /></td>
										</tr>
									</table>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</form>
		</section>
    </div>
    <div id="menu2" class="container tab-pane fade"><br>
      <h3>스크랩</h3>
      <section id="container">
			<form role="form" method="get">
				<div>
					<!-- <div style="max-width: 20%;"> -->
					<table class="table table-striped" style=" vertical-align: middle;">
						<c:forEach items="${list2}" var="list">
							<tr>
								<th class="col-1" scope="row" style=" text-align: center;"><c:out value="${list.bno}" /></th>
								<td class="col-9">
									<div id="stat"
										style="overflow: hidden; text-overflow: ellipsis; display: -webkit-box; -webkit-line-clamp: 2; -webkit-box-orient: vertical;">
										<a href="/board/consultation/${list.bno}"
											style="text-decoration-line: none; color: black;">${list.title}</a>
									</div>
								</td>
								<td class="col-2" style=" text-align: center;">
									<table style=" text-align: center; margin: auto;">
										<tr>
											<td class="col" style=" text-align: center;"><c:out value="${list.bwriter}" /></td>
										</tr>
										<tr>
											<td class="col" style=" text-align: center;"><fmt:formatDate
													value="${list.modifiedDate}" pattern="yy/MM/dd" /></td>
										</tr>
									</table>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</form>
		</section>
    </div>
  </div>





</main>
 
     <script type="text/javascript">
      $().ready(function(){
    	  $('#example').DataTable(
          		{
          			  order: [[0, 'desc']],
          			  ordering: true,
          			  serverSide: false,
          			  searching: false,
	      			  lengthChange: false,
	      			  info: false,
          		});
    	  $('#example2').DataTable(
            		{
            			  order: [[0, 'desc']],
            			  ordering: true,
            			  serverSide: false,
            			  searching: false,
            			  lengthChange: false,
            			  info: false,
            		});
    	  
    	  $("#show").click(function(){
    		    $("#p").show();
    		  });
    	  $("#show2").click(function(){
  		    $("#p2").show();
  		  });
    	  $("#hide").click(function(){
    		    $("#p").hide();
    		  });
    	  
    	  $("#memberUpdateBtn").on("click", function(){
  			location.href="/board/memberUpdateView";
  		})
      })
   
   </script>
  <script type="text/javascript">
        $(document).ready(function() {

            //When page loads...
            $(".tab_content").hide(); //Hide all content
            $("ul.tabs li:first").addClass("active").show(); //Activate first tab
            $(".tab_content:first").show(); //Show first tab content

            //On Click Event
            $("ul.tabs li").click(function() {

                $("ul.tabs li").removeClass("active"); //Remove any "active" class
                $(this).addClass("active"); //Add "active" class to selected tab
                $(".tab_content").hide(); //Hide all tab content

                var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
                $(activeTab).fadeIn(); //Fade in the active ID content
                return false;
            });

        });
        
        console.log(${sessionScope.loginId});
    </script>