<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>

<%
String name = request.getParameter("name");
String phone = request.getParameter("phone");

if(name != null && phone != null && !name.equals("") && !phone.equals(""))
	out.print(name+"의 전번은 "+phone+" 입니다.");
%>

<form name="frm" method="post" action="requestMethod.jsp">


이름 : <input type="text" name="name">
전번 : <input type="text" name="phone">
<input type="submit" value="전송">

</form>


</body>
</html>