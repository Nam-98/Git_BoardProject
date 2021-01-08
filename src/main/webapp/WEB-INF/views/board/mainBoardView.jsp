<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<style>
	*{box-sizing: border-box;}
	div{border:1px solid black;}
	.container{margin:auto; width:350px; height:400px;}
	.contents{height:80%;overflow-y:auto;word-wrap:break-word; background-color:#9bbacf; text-align:right;}
	.input{height:20%;}
	.input>div{float:left;}
	.message{width:80%;height:100%;overflow-y:auto;}
	.contents .my{background-color:white;
				  display:inline-block;
				  max-width:140px;
				  border-radius:3px;
				  margin:3px;
				  padding:2px;
				  float:left;
				  clear:both; /* float를 리셋하는것 */
    }
	.contents .nmy{background-color:yellow;
				   display:inline-block;
				   max-width:140px;
				   border-radius:3px;
				   margin:3px;
				   padding:2px;
				   
	}
	
	.controls{width:20%; height:100%; text-align:center;}
</style>
</head>
<body>
<form action="/board/mainBoard.board" method="post">
	<table border="1" align="center">
        <tr>
            <td colspan="5" align="center">자유게시판</td>  
        </tr>
        <tr>
            <td width=20></td>
            <td align="center" width=500>Title</td>
            <td align="center" width=100>Writer</td>
            <td align="center" width=100>Date</td>
            <td align="center">View</td>
        </tr>
        
        <tr>
            <c:forEach var="i" items="${list }">
        	 	<tr>
            		<td width=20>${i.seq}</td>
            		<td align="center" width=500 id=title><a href=contentsBoard.board?seq=${i.seq}>${i.title}</a></td>
            		<td width=100>${i.writer}</td>
            		<td width=100>${i.write_date}</td>
            		<td>${i.view_count}</td>
        		</tr>
        	</c:forEach>
        </tr>
        
        <tr>
            <td align="center" colspan="5">${navi }</td>
        </tr>
        
        <tr>
            <td align=right colspan="5">
            <input type="button" value="글쓰기" id=write>
            </td>
        </tr>
</table>
</form>
	
	<script>
	document.getElementById("write").onclick=function(){
    	location.href="/board/insertBoardClick.board";
   }
		
	</script>
</body>
</html>