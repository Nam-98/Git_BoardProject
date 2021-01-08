<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
<style>
* {
	box-sizing: border-box;
	margin: 0px;
	padding: 0px;
	border: 0px solid black;
}

a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	color: gray;
	text-decoration: none;
}

.container {
	width: 1280px;
	height: 720px;
	margin: auto;
}

header {
	width: 100%;
	height: 50px;
}

section {
	width: 100%;
	height: 100%;
}

#ImgDetail {
	margin-top: 30px;
	margin-bottom: 30px;
}

.tree {
	width: 100%;
	border: 1px solid black;
	border-right: none;
	border-left: none;
	margin-top: 20px;
}

.sect2 {
	width: 80%;
	height: 100%;
	margin-top: 10px;
	margin: auto; 
}

.notice {
/* 	width: 85%; */
	width: 350px;
	height: 100%;
	margin: auto;
/* 	margin-left: 150px; */
}

/* ----- 기본틀 여기까지 ----- */



input{
/* 	border: 1px solid black; */
	border-bottom: 1px solid black;
}
input:focus {
	outline:none;
}
#wrapper{
	height: 100%;
}
.row {
	text-align:left;
}
.row>.input>input{
	text-align: center;
}
.joinImg{
/* 	9개 있을때 */
/* 	height: 25px; */
	height: 35px;
}
.textSpace{
	width : 300px;
/* 	9개 있을때 */
/* 	height: 20px; */
	height: 27px;
}

#underBtn{
	margin-top : 20px;
	margin-bottom : 20px;
	padding-left: 75px;
}
.modify_btn{
	width: 150px;
	height: 300px;
	cursor:pointer;
}
#join{
	background-color: Transparent;
}
#join:focus {
	outline:none;
}


        footer{
            width: 100%;
            height: 10px;
            text-align: center;
            float:left;
            margin-top : 150px;
        }

/* ----- 회원가입 여기까지 ----- */

</style>
</head>
<body>
	<div class="container">
		<header></header>
		<section>
			<div class="sect1">
				<div class="tree">					
				</div>
			</div>



			<div class="sect2">
				<div>
					<div class="ImgDetail">
					</div>
				</div>
				<div class="notice">


					<div id=wrapper>
						<div class='row'>
							<div class='index'>
								아이디
							</div>
							<div class='input'>
								<input type="text" class="textSpace" required id="idmsg" name="id"
									placeholder="8-12글자의 알파벳 대소문자" value="${list[0].id }" readonly>
							</div>
						</div>
<!-- 						<div class='row'> -->
<!-- 							<div class='index'> -->
<!-- 								<img class="joinImg"  -->
<!-- 									src="/resources/limmade/password.png"> -->
<!-- 							</div> -->
<!-- 							<div class='input'> -->
<!-- 								<input type="password" class="textSpace" required id="pw" name=password> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 						<div class='row'> -->
<!-- 							<div class='index'><img class="joinImg"  -->
<!-- 									src="/resources/limmade/pwCheck.png"></div> -->
<!-- 							<div class='input'> -->
<!-- 								<div id="ckpws"> -->
<!-- 									<input type="password" class="textSpace" required id="ckpw"> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 									<div id="ckpwmsg">　</div> -->
								
<!-- 							<br> -->
<!-- 						</div> -->
						<div class='row'>
							<div class='index'>
								이름
							</div>
							<div class='input'>
								<input type="text" class="textSpace" required name="name" value="${list[0].name }" readonly>
							</div>
						</div>
						<div class='row'>
							<div class='index'>
								전화번호
							</div>
							<div class='input'>
								<input type="text" class="textSpace" placeholder="01012341234" name="contact"
									required value="${list[0].contact }" readonly>
							</div>


						</div>
						<div class='row'>
							<div class='index'>
								이메일
							</div>
							<div class='input'>
								<input type="text" class="textSpace" required name="email" value="${list[0].email }" readonly>
							</div>
						</div>
						<div class='row' id=underBtn align=center>
							<input type="button" id="modify_btn" value="수정하기">
<!-- 								<img width="300" src="/resources/limmade/join2.png"> -->
<!-- 								<img class="modify_btn" src ="/resources/limmade/myInfoFix.png" onmouseover="this.src='/resources/limmade/myInfoFixClick.png'" onmouseout="this.src='/resources/limmade/myInfoFix.png'"> -->
							<input type="button" id="goHome_btn" value="홈으로 가기">
							<br>
						</div>
						
					</div>

					<input id="ckFlag" type="hidden" value="false">




				</div>
			</div>
		</section>
		         <footer>
         </footer>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	
	    <script>
    	$('#modify_btn').on('click', function(){
    		location.href="/bmember/modifyMyInfo.member";
    	})
    	$('#goHome_btn').on('click', function(){
    		location.href="/";
    	})

    	
    </script>

</body>
</html>