<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</head>
<body>
		<div class=container>
		<form action="/member/loginProc.mem" method="post">
			<span class="text-center">Login Box</span>
			<div class="input-container">
				<input type="text" required name=id /> <label>ID</label>
			</div>
			<div class="input-container">
				<input type="password" required name=pw /> <label>PassWord</label>
			</div>
			<button id="login" class=btn>로그인</button>
			<button type=button id="signUp" class=btn>회원가입</button>
		</form>
	</div>
	<script>
		$("#signUp").click(function() {
			location.href = "/member/toSignUpView.mem";
		})
	</script>
	<c:if test='${login==true}'>
		<script>
			alert("환영합니다.");
			location.href = "/";
		</script>
	</c:if>
	<c:if test='${login==false}'>
		<script>
			alert("로그인에 실패하였습니다.");
		</script>
	</c:if>
</body>
</html>