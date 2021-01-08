<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${dtos.title}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

</head>
<style>
.container{
width : 1000px;
}

* {
	border-right: none;
	border-left: none;
	border-top: none;
	font-family: "고딕";
}

.component>* {
	text-align: center;
	background-color: beige
}

#subTitle>* {
	background-color: darksalmon;
}

#contents {
	background-color: antiquewhite;
}

#commentsubTitle {
	background-color: darksalmon;
}
</style>
<body>
	<div class="container">
	
	<a href="/board/mainBoard.board?cpage=1"><h1>자유게시판</h1></a>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Seq</th>
      <th scope="col">Title</th>
      <th scope="col">Writer</th>
      <th scope="col">Date</th>
      <th scope="col">View</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">${dtos.seq}</th>
      <td id="seq">${dtos.title}</td>
      <td id="title">${dtos.writer}</td>
      <td>${dtos.write_date}</td>
      <td>${dtos.view_count}</td>
    </tr>
    <tr>
	  <td colspan="5" align=center id="contents">${dtos.content}</td>
	</tr>
			<tr>
			<td align=right colspan="5">
				<button id="fix">수정하기</button>
				<button id="delete">삭제하기</button> <input type="button" id="return"
				value="목록으로">
			</td>
		</tr>
		<tr id="commentsubTitle">
			<th width=20>Seq</th>
			<th align="center" width=500>댓글 내용</th>
			<th align="center" width=100>댓글 작성자</th>
			<th align="center" width=50>작성날짜</th>
			<th align="center" width=50>삭제</th>
		</tr>
		<c:forEach var="i" items="${sessionScope.list}">
			<tr class="component">
				<td width=20 id="seq">${i.seq}
				<td width=500>${i.contents}
				<td width=100>${i.writer}
				<td width=50>${i.write_date}
				<td><c:choose>
						<c:when test="${i.writer==sessionScope.id}">
							<button type="button" id="deleteComment"
								onclick="location.href='/bcomment/deleteBComment.bcomment?seq=${i.seq}&board_seq=${dtos.seq}' ">X</button>
						</c:when>
					</c:choose>
			</tr>

		</c:forEach>
		<form action="/bcomment/writeBComment.bcomment?seq=${dtos.seq}" method="post">
			<tr>
				<th colspan="3" height=100 width=500 align=center><textarea
						style="width: 100%" name="content" id="content" required></textarea></th>
				<th colspan="3"><button id="add_co" >댓글 등록</button></th>
			</tr>
		</form>
	
  </tbody>
</table>
	
	</div>
</body>

<script>
	document.getElementById("return").onclick = function() {
		location.href = "/board/contentsBoard.board?cpage=${sessionScope.cpage}";
	}

	if ("${dtos.writer}" == "${sessionScope.id}") {
		document.getElementById("delete").onclick = function() {
			location.href = "/board/deleteBoard.board?seq=${dtos.seq}";
		}

		document.getElementById("fix").onclick = function() {
			location.href = "/board/fixBeforeBoard.board?seq=${dtos.seq}";
		}
	} else {
		document.getElementById("delete").style.visibility = "hidden";
		document.getElementById("fix").style.visibility = "hidden";
	}
</script>
</html>