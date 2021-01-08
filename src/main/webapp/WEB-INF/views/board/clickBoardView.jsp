<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- include summernote css/js-->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>
<title>${dtos.title}</title>
</head>
<style>
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

	<table border="1" align="center" width=760>
		<tr>
			<td colspan="5" align="center" id="mainTitle"><a
				href="/board/mainBoard.board?cpage=1"><h1>자유게시판</h1></a></td>
		</tr>
		<tr id="subTitle">
			<td width=20>Seq</td>
			<th align="center" width=500>Title</th>
			<th align="center" width=100>Writer</th>
			<th align="center" width=100>Date</th>
			<th align="center">View</th>
		</tr>
		<tr class="component">
			<td width=20 id="seq">${dtos.seq}
			<td width=500 id="title">${dtos.title}
			<td width=100>${dtos.writer}
			<td width=100>${dtos.write_date}
			<td>${dtos.view_count}
		</tr>

		<tr>
			<td colspan="5" height=500 align=center valign=center id="contents">${dtos.content}</td>
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
							<%-- <button id="fixComment" onclick="location.href='${pageContext.request.contextPath}/fix.comment?seq=${vo.seq}' ">Fix</button> --%>
							<button type="button" id="deleteComment"
								onclick="location.href='${pageContext.request.contextPath}/deleteBComment.bcomment?seq=${i.seq}' ">X</button>
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
	</table>
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