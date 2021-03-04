<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

</head>

<script>

	$(function(){
		
		$("#search_btn").click(function(){
			
			if( $("#dong").val() == "" ){
				
				alert("동을 입력해주세요.");
				return false;
				
			}
			$("#frm").submit();
		
		});
				
	});

</script>

<body>

<div style="width:98%; height:190px; text-align:center; line-height:30px">
	동/면/리를 제외하고 이름만 입력해 주세요. <br>
	(예: 서초 입력 후 검색)
	<br>

	<form name="frm" id="frm" method="post" action="post2.jsp">
	
		<input type="text" name="dong" id="dong">&nbsp;(동/면/리)&nbsp;
		<button type="button" id="search_btn">검색</button>
	
	</form>

</div>

</body>
</html>