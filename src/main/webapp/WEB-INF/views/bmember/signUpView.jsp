<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<style type="text/css">
	#container{
		width:50%;
		margin:auto;
		margin-top:100px;
	}
</style>
</head>
<body>
	<div id=container>
	<div class="row">
		<h1 class="display-6" style="text-align:center;">회원가입</h1>
	</div>
	<div class="row">
    <form id="signForm" class="col s12" action="/bmember/signUpMember.member" method="post" >
      <div class="row">
        <div class="input-field col s6">
          <input type="text" class="validate" id="id" name="id">
          <label for="id">ID</label>
          <span id="idResult"></span>          
        </div>
        <div class="col s6">
			<button type="button" class="btn btn-outline-secondary my-3" id="idCheck">중복확인</button>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s6">
          <input id="password" type="password" class="validate" name=pw>
          <label for="password">Password</label>
          <span id="pwcAlert"></span>          
        </div>
        <div class="input-field col s6">
          <input id="pwChk" type="password" class="validate">
          <label for="pwChk">Password Check</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="name" type="text" class="validate" name=name>
          <label for="name">Name</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="email" type="email" class="validate" name=email>
          <label for="email">Email</label>
          <span class="helper-text" data-error="wrong" data-success="right"></span>
        </div>
      </div>
      <div class="row">
      	<div class="input-field col s3">
      	  <input id="contact1" type="number" class="validate" data-length="3" max='999'>
          <label for="contact1">Contact</label>
      	</div>
      	<div class="input-field col s3">
      	   <input id="contact2" type="number" class="validate" data-length="4" max='9999'>
      	</div>
      	<div class="input-field col s3">
      	   <input id="contact3" type="number" class="validate" data-length="4" max='9999'>
      	   <input type=hidden name=contact id=contact>
      	</div>
      	<div class="row">
      		<div class="col s6" style="text-align:center;">
				<button id=submit class="btn btn-outline-secondary my-5">회원가입</button>
				<input type="reset" value="다시 입력" id="reset" class="btn btn-outline-secondary my-5">
        	</div>
      	</div>
      </div>
    </form>
  </div>
	</div>
  
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
  
  <script>
  $(document).ready(function() {
	    $('input#contact1, input#contact2, input#contact3').characterCounter();
	  });
  
document.getElementById("signForm").onsubmit = function() {
	  let mergeContact = $("#contact1").val()+$("#contact2").val()+$("#contact3").val();
	  $("#contact").val(mergeContact);	  
	if($("#idResult").html()==''){
		alert("중복확인은 필수 입니다.");  
		return;
	  }else if($("#idResult").html()=='사용할 수 없는 아이디 입니다.'){
		  alert("사용가능한 아이디를 입력하여 주세요");
		  return;
	  }
	let pwchk = $("#pwcAlert").html();
	if(pwchk==uncor){
		alert("비밀번호 확인창에 동일한 비밀번호를 작성하여 주세요.");
		return;
	}
  }
  
	//ID Check
	//(비동기화 방식)
	$("#idCheck").click(function() {
		$.ajax({
			url : "isIdExistMember.member",
			type : "get",
			data : {
			id : $("#id").val()
			},
			dataType : "json" // 넘어온 data를 json형태로 받아옴. -> JSON.parse()를 대체 가능
		}).done(function(result) {
			console.log(result);
			//result = JSON.parse(result);//넘어온 data를 json형태로 casting
			$("#idResult").html(result.msg);
			$("#idResult").css("fontSize","small")
			if (result.result == true) {
				$("#idResult").css("color","green");
			}else{
				$("#idResult").css("color","red");
			}

		})
	})

	//비밀번호 일치 불일치 알림
	let cor = "비밀번호가 일치합니다."
	let uncor = "비밀번호가 일치하지 않습니다."
	let pwc = document.getElementById("pwcAlert");

	document.getElementById("pwChk").oninput = function() {
		if (document.getElementById("password").value == document.getElementById("pwChk").value) {
			pwc.innerHTML = cor;
			pwc.style.color = "green";
			pwc.style.fontSize = "small"
		} else {
			console.log(document.getElementById("password").value)
			console.log(document.getElementById("pwChk").value)
			pwc.innerHTML = uncor;
			pwc.style.color = "red";
			pwc.style.fontSize = "small"
		}
	}
  </script>
  
  	<script>
		let signResult = ${result};
		if(signResult==true){
			alert('회원가입을 축하합니다!');
			location.href = "/";
		}else if(signResult==false){
			alert('회원가입에 실패하였습니다.');
		}
	</script>
</body>
</html>