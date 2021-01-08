<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
table {
	margin: auto;
}

fieldset {
	margin: auto;
	text-align: center;
	width: 400px;
}
</style>
</head>
<body>

	<fieldset>
		<legend>Welcome</legend>
		${sessionScope.id}님 환영합니다.<br>
		<button type="button" id="board">게시판</button>
		<button type="button" id="mypage">마이페이지</button>
		<button type="button" id="logout">로그아웃</button>
	</fieldset>
	<script>
				document.getElementById("logout").onclick=function(){
					location.href="/bmember/logoutMember.member";
				}
				document.getElementById("mypage").onclick=function(){
					location.href="/bmember/getMyInfo.member";
				}
				document.getElementById("board").onclick=function(){
					location.href="/board/mainBoard.board?cpage=1";
				}
			</script>

</body>
</html>