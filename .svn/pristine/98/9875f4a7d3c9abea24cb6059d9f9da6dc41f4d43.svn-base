<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
	<table id="example" class="display">
		<thead>
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>주제</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${theme}" var="list">
				<tr>
					<td width="100"><c:out value="${list.bno}" /></td>
					<td><a href="/board/readView?bno=${list.bno}"><c:out value="${list.title}" /></a></td>
					<td width="100"><c:out value="${list.theme}" /></td>
				</tr>
			</c:forEach>
	</table>

</main>

	<script type="text/javascript">
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
        } );
        
 
   	</script>

