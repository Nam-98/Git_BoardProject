<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body>
<c:choose>
	<c:when test = "${result==1}">
		<script>alert("댓글 작성 완료!");</script>		
	</c:when>
	<c:otherwise>
		<script>alert("Error! 다시 시도해주세요");</script>
	</c:otherwise>
	</c:choose>
	<script>location.href ="/board/contentsBoard.board?seq="+${board_seq}</script>

</body>
</html>