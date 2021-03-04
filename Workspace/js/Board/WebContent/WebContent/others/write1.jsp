<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script>

function fn_test(){  // 사용자 함수
	 //document=현재창 frm=폼의 이름 username=요소 vlaue=값
	if(document.frm.username.value == ""){
	
		alert("이름을 입력하세요.");
		return false; //자바 스크립트 종료
	}	
	document.frm.submit(); // 전송함수
}

</script>

<body>

<form name="frm" method="post" action="writeSub1.jsp">

이름 : <input type="text" name="username"><br>

년 : <select name="year">
<%for(int i=1900; i<2000; i++ ) {%>
<option value="<%=i%>">
<%=i %> 년
<%} %>
</select>

월 : <select name="month">
<%for(int i=1; i<13; i++ ) {%>
<option value="<%=i%>">
<%=i %> 월
<%} %>
</select>

일 : <select name="date">
<%for(int i=1; i<32; i++ ) {%>
<option value="<%=i%>">
<%=i %> 
<%} %>
</select> <br>  

연락처 : <input type="text" name="phone"><br>
주소 : <input type="text" name="address"><br>
<input type="submit" value="전송" 
						onclick="fn_test(); return false">

</form>

</body>
</html>