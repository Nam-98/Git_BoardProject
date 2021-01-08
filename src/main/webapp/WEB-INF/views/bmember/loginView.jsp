<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<style type="text/css">
.container{	
	text-align:center;
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);}
.loginContainer {
	width: 300px;
	height: max-content;
	margin: auto;
}
.buttons{
	margin-top:10px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="loginContainer">
			<form action="/bmember/loginMember.member" method="post">
			<h1 class="display-6">Login</h1>
				<div class="input-group input-group-lg py-1">
					<span class="input-group-text" id="inputGroup-sizing-lg">ID</span>
					<input type="text" class="form-control"
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-lg" name=id>
				</div>
				<div class="input-group input-group-lg py-1">
					<span class="input-group-text" id="inputGroup-sizing-lg">PW</span>
					<input type="password" class="form-control"
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-lg" name=pw>
				</div>
				<div class="buttons">
					<input type=submit id="login" class="btn btn-secondary" value="로그인">
					<button type=button id="signUp" class="btn btn-secondary">회원가입</button>
				</div>
			</form>

		</div>
	</div>
	<script>
		$("#signUp").click(function() {
			location.href = "/bmember/toSignUpViewMember.member";
		})
	</script>
	
	<script>
		let signResult = ${loginResult};
		console.log(signResult);
		if(signResult==1){
			alert("환영합니다.");
			location.href = "/";
		}else if(signResult==0){
			alert("로그인에 실패하였습니다.");
		}
	</script>

</body>
</html>