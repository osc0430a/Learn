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
String username = request.getParameter("username");
String address = request.getParameter("address");
String year = request.getParameter("year");
String month = request.getParameter("month");
String date = request.getParameter("date");
String birthday = year + "-" + month + "-" + date;
String phone = request.getParameter("phone");
%>
이름 : <%=username %> <br>
생일 : <%=birthday %> <br>
연락처 : <%=phone %> <br>
주소 : <%=address %> <br>

<input type="button" value="이전화면1" onclick="history.back()"> <br>
<button type="button" onclick="history.go(-1)">이전화면2</button> <br>


</body>
</html>