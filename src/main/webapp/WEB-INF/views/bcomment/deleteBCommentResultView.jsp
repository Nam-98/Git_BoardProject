<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test = "${result==1}">
		<script>alert("댓글 삭제 완료!");</script>		
	</c:when>
	<c:otherwise>
		<script>alert("Error! 다시 시도해주세요");</script>
	</c:otherwise>
	</c:choose>
	<script>location.href ="/board/contentsBoard.board?seq="+${board_seq}</script>

</body>
</html>