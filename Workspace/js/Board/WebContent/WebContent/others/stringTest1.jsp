<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String str1 = "first string";
String str2 = "First string";
out.print(str1 + "<br>");
out.print(str2 + "<br>");
%>
<%=str1 %> <br>
<%=str2 %> <br>
<%=str1.length() %> , <%=str2.length() %> <br>
<%=str1.charAt(4) %> , <%=str2.charAt(4) %> <br>
<%=str1.indexOf("first") %> <br>
<%=str1.indexOf('s') %> <br>
<%=str1.substring(5) %> <br>
<%=str1.substring(5,12) %> <br>
<%=str1.equals(str2) %>

<br><br>풀어보기1<br>
<%String address = " 123456 대구시 수성구 "; %>
<%=address.length() %> <br>
<%=address.trim().substring(0,7) %> <br>
<%=address.trim().substring(7) %> <br>
<%String result;
int t = address.indexOf("대구");
if(t==-1) result = "없습니다.";
else result = "있습니다.";
%><%=result %> <br>

</body>
</html>