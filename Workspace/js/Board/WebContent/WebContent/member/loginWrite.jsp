<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script>

	$(function(){
		
		$("#login_btn").click(function(){
			
			var userid = $("#userid").val().trim();
			var pass = $("#pass").val().trim();
			
			if( userid == "" ){
				
				alert("아이디를 입력해 주세요.");
				$("#userid").focus();
				return false;
				
			}
			
			if( pass == "" ){
				
				alert("비밀번호를 입력해 주세요.");
				$("#pass").focus();
				return false;
				
			}
			
			$("#frm").submit();
			
		});
		
	})

</script>

<body>

	<div style="width:98%; height:190px;  
				lien-height:30px; text-align:center">
	
		<form name="frm" id="frm" method="post" action="loginSub.jsp">
		<br>
			아이디: <input type="text" name="userid" id="userid" style="width:50%;margin-bottom:2px"> <br>
			암&nbsp;&nbsp;&nbsp;&nbsp;호: <input type="password" name="pass" id="pass" style="width:50%">
		<br>
		<button type="submit" id="login_btn" style="margin-top:5px">로그인</button>
		</form>
		
	</div>

</body>
</html>