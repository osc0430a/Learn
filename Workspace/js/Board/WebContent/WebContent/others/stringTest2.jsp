<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<br>풀어보기2<br>
<%String birthday = "20100115 20011225 19981102"; 
String[] array = birthday.split(" ");
/* 위는 Strtng[] array = {"20100 ~~~~"} 과 동일 */

%>

<% 
for(int i=0; i<3; i++){
%>

<%=array[i] %> <br>
	
<%
}
%>

<%
out.print(birthday.trim().substring(0,9) + "<br>" ); 
out.print(birthday.trim().substring(9,18) + "<br>");
out.print(birthday.trim().substring(18) + "<br>");

%>

</body>
</html>