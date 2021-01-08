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
			<%
				if(session.getAttribute("id")==null){
			%>
			<table border=1px>
			<tr>
				<th colspan=2>Login Box
			</tr>
			<form action="/bmember/loginMember.member" method="post">
				<tr>
					<td>아이디 : 
					<td><input type=text name=id>
				</tr>
				<tr>
					<td>패스워드 :
					<td><input type=password name=pw>
				</tr>
				<tr>
					<td colspan=2 align=center>
						<button id=login>로그인</button>
						<button type=button id=signUp>회원가입</button>
				</tr>
			</form>
			</table>
			
			<script>
				document.getElementById("signUp").onclick=function(){
					location.href="/bmember/signUpMember.member";
				}
				document.getElementById("login").onclick=function(){
					location.href="/bmember/loginMember.member";
				}
			</script>
			<%
		}else{%>
			<fieldset><legend>Welcome</legend>
				<%=session.getAttribute("id") %>님 환영합니다.<br>
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
	<%}%>

</body>
</html>