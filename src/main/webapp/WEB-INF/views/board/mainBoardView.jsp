<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>board</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!--    스타일시트-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

<!--    자바스크립트-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
	crossorigin="anonymous"></script>

<style>
* {
	box-sizing: border-box;
}

.container {
	width: 1000px;
}
</style>
</head>

<body>
<div class="container">
	<form action="/board/mainBoard.board" method="post">
		<table class="table table-striped" border="1" align="center">
			<tr>
				<td colspan="5" align="center">자유게시판</td>
			</tr>
		</table>

		<table class="table table-hover table-striped">
			<tr>
				<td width=20>Seq</td>
				<td align="center" width=500>Title</td>
				<td align="center" width=100>Writer</td>
				<td align="center" width=100>Date</td>
				<td align="center">View</td>
			</tr>

			<tr>
				<c:forEach var="i" items="${list }">
					<tr>
						<td width=20>${i.seq}</td>
						<td align="center" width=500 id=title><a
							href=contentsBoard.board?seq=${i.seq}>${i.title}</a></td>
						<td width=100>${i.writer}</td>
						<td width=100>${i.write_date}</td>
						<td align="center">${i.view_count}</td>
					</tr>
				</c:forEach>
			</tr>
		</table>
		<table class="table table-striped">
			<tr>
				<td align="center" colspan="5">${navi }</td>
			</tr>

			<tr>
				<td align=right colspan="5"><input type="button"
					class="btn btn-primary" value="글쓰기" id=write></td>
			</tr>
		</table>
	</form>
	</div>
</body>
<script>
   document.getElementById("write").onclick=function(){
       location.href="/board/insertBoardClick.board";
   }
   </script>
</html>