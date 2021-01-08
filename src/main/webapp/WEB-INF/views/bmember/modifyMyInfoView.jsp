<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
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

footer {
	width: 100%;
	height: 50px;
	background-color: #ccc;
	text-align: center;
	line-height: 50px;
}
/* ----- 기본틀 여기까지 ----- */
input {
	/* 	border: 1px solid black; */
	border-bottom: 1px solid black;
}

input:focus {
	outline: none;
}

#wrapper {
	height: 100%;
}

.row {
	text-align: left;
}

.row>.input>input {
	text-align: center;
}

.joinImg {
	/* 	9개 있을때 */
	height: 25px;
	/* 	height: 35px; */
}

.textSpace {
	width: 300px;
	/* 	9개 있을때 */
	height: 20px;
	/* 	height: 27px; */
}

#underBtn {
	margin-top: 20px;
	margin-bottom: 20px;
	padding-left: 75px;
}

.modify_btn {
	width: 150px;
	cursor: pointer;
}

#join {
	background-color: Transparent;
}

#join:focus {
	outline: none;
}
/* ----- 회원가입 여기까지 ----- */
</style>
</head>
<body>
	<div class="container">
		<header> </header>
		<section>
			<div class="sect1">
				<div class="tree"></div>
			</div>



			<div class="sect2">
				<div>
					<div class="ImgDetail"></div>
				</div>
				<div class="notice">

					<form action="/bmember/modifyProcessMember.mem" method="post"
						id="formBox">
						<div id=wrapper>
							<div class='row'>
								<div class='index'>아이디</div>
								<div class='input'>
									<input type="text" class="textSpace" required id="idmsg"
										name="id" placeholder="8-12글자의 알파벳 대소문자"
										value="${list[0].id }" readonly>
								</div>
							</div>
							<div class='row'>
								<div class='index'>비밀번호</div>
								<div class='input'>
									<input type="password" class="textSpace" required id="pw"
										name=pw>
								</div>
							</div>
							<div class='row'>
								<div class='index'>비밀번호 확인</div>
								<div class='input'>
									<input type="password" class="textSpace" required id="ckpw">
								</div>
								<div id="ckpwmsg"></div>

								<!-- 								<br> -->

							</div>
							<div class='row'>
								<div class='index'>이름</div>
								<div class='input'>
									<input type="text" class="textSpace" required name="name"
										value="${list[0].name }">
								</div>
							</div>
							<div class='row'>
								<div class='index'>전화번호</div>
								<div class='input'>
									<input type="text" class="textSpace" placeholder="00012345678"
										name="contact" required value="${list[0].contact }">
								</div>


							</div>
							<div class='row'>
								<div class='index'>이메일</div>
								<div class='input'>
									<input type="text" class="textSpace" required name="email"
										value="${list[0].email }">
								</div>
							</div>
							<div class='row' id=underBtn align=center>
								<button type="submit" id="join">수정 완료</button>
								<br>
							</div>
						</div>

						<input id="ckFlag" type="hidden" value="false">

					</form>


				</div>
			</div>
		</section>
		<footer></footer>
	</div>

	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

	<script>
	
		/*비번 일치불일치 코드*/
		let ckpwmsg = document.getElementById("ckpwmsg");
		let ckpw = document.getElementById("ckpw");
	
		document.getElementById("ckpw").oninput = function() {
			if (ckpw.value == document.getElementById("pw").value) {
				ckpwmsg.innerHTML = "비번 일치";
				ckpwmsg.style.color = "blue";
			} else {
				ckpwmsg.innerHTML = "비번 일치x";
				ckpwmsg.style.color = "red";
			}
		}
	
		/*우편번호 api 활용 코드*/

		function daumPostcode() {
			new daum.Postcode({
				oncomplete : function(data) {
					var roadAddr = data.roadAddress;
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('zipcode').value = data.zonecode;
					document.getElementById("address1").value = roadAddr;

				}
			}).open();
		}
		document.getElementById("search").onclick = daumPostcode;
	
	    
//     	$('.modify_btn').on('click', function(){
//     		location.href="/mypage/modifyMyInfo.mypage";
//     	})

    	
    	
    	
    	
    	
    	
    </script>

</body>
</html>