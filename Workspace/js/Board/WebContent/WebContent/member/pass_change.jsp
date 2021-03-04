<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script>

	$(function(){
		$("#pass_btn").click(function(){
			
			var pass1 = $("#pass1").val();
			var pass2 = $("#pass2").val();
			var pass3 = $("#pass3").val();
			
			if( pass1 == "" || pass2 == "" || pass3 == "" ){
				
				alert("내용을 채워주세요.");
				return false;
				
			}
			
			if( pass2 != pass3 ){
			
				alert("바꿀 암호가 서로 일치하지 않습니다.");
				return false;
				
			}
			
			$("#frm").submit();
			
		});		
	})

</script>

<body>

	<div style="width:98%; height:190px; 
				lien-height:30px; text-align:center; margin-top:20px">
	
		<form name = "frm" id = "frm" method = "post" action = "pass_changeSub.jsp">
		
			현재 암호: <input type="password" name="pass1" id="pass1"> <br>
			바꿀 암호: <input type="password" name="pass2" id="pass2"> <br>
			암호 확인: <input type="password" name="pass3" id="pass3"> <br>
		
			<button type="submit" id="pass_btn">변경하기</button>
			
		</form>		
	
	</div>

</body>
</html>