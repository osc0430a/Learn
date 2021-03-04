<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/dbCon.jsp" %>

<!doctype html>

<html lang="en">

<head>

<meta charset="UTF-8">

<title>회원 가입</title>

<link rel="stylesheet" type="text/css" href="../css/layout.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="../js/script.js" ></script>

<script>
	
	$(function() {
		$("#birth").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});
	
	function fn_popup(){
		
		var url = "post1.jsp";
		
		window.open(url,'post','width=400, height=200');
		
	}
	
</script>

</head>

<script>



</script>

<body>

	<div class="header">

		<%@ include file="../include/topMenu.jsp" %>

	</div>

<div class="content">

	<div class="side">111</div>
	
	<div class="section" >
	
		<form name="frm" id="frm" method="post" action="memberWriteSave.jsp">
	
		<div style="position:relative;
					left:50px">
						
			<table class="table1" style="margin-left:5px;margin-top:5px;">
			
				<caption style="font-size:20pt">회원 등록 화면</caption>
			
				<tr>
				
					<th class="td1">아이디</th>
					<th class="td1"><input type="text" name="userid" id="userid" style="width:80%"></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">암호</th>
					<th class="td1"><input type="password" name="pass" id="pass" style="width:80%"></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">이름</th>
					<th class="td1"><input type="text" name="name" id="name" style="width:80%"></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">생일</th>
					<th class="td1"><input type="text" name="birth" style="width:80%" id="birth"></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">성별</th>
					<th class="td1">
					
							<input type="radio" name="gender" value="M">남성
							<input type="radio" name="gender" value="F">여성
									
					</th>
				
				</tr>
				
				<tr>
				
					<th class="td1">주소</th>
					<th class="td1">
					
						<input type="text" name="post" style="width:40%;float:left;margin-left:50px">
						<button type="button" onclick="fn_popup()" style="margin-left:48px;margin-bottom:5px">우편번호 검색</button> <br>
						<input type="text" name="addr" style="width:80%">
						
					</th>
				
				</tr>
				
				<tr>
				
					<th class="td1">학력</th>
					<th class="td1">
						
						<input type="radio" name="edu" value="1">고졸
						<input type="radio" name="edu" value="2">대졸
						<input type="radio" name="edu" value="3">대학원
						
					</th>
				
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