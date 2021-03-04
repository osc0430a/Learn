<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/dbCon.jsp" %>

<!doctype html>

<html lang="en">

<head>

<meta charset="UTF-8">

<title>게시글 작성</title>

<link rel="stylesheet" type="text/css" href="../css/layout.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">

</head>

<script>

function fn_submit(){
	
	var f = document.frm;
	
	if(f.title.value == ""){
		alert("제목을 입력해주세요.");
		f.title.focus();
		return;
	}
	if(f.pass.value == ""){
		alert("비밀번호를 입력해주세요.");
		f.pass.focus();
		return;
	}
	f.submit();
}

</script>


<body>

	<div class="header">

		<%@ include file="../include/topMenu.jsp" %>

	</div>

<div class="content">

	<div class="side">111</div>
	
	<div class="section" >
	
		<form name="frm" method="post" action="boardWriteSave.jsp">
	
		<div style="position:relative;
					left:50px">
						
			<table class="table1" style="margin-left:5px;margin-top:5px;">
			
				<caption>글쓰기 화면</caption>
			
				<tr>
				
					<th class="td1">제목</th>
					<th class="td1"><input type="text" name="title" style="width:80%"></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">암호</th>
					<th class="td1"><input type="password" name="pass" style="width:80%"></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">글쓴이</th>
					<th class="td1"><input type="text" name="name" style="width:80%"></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">내용</th>
					<th class="td1"><textarea rows="5" cols="50" name="content"></textarea></th>
				
				</tr>
			
			</table>
		
		<div style="width:600px;text-align:center;margin-top:5px">
		
			<button type="submit" onclick="fn_submit(); return false;">저장</button>
			
			<button type="reset">다시쓰기</button>		
		
		</div>
		
		</div>		
		
		</form>
	
	</div>
	
	</div>
	
	<div class="footer"></div>

</body>

</html>