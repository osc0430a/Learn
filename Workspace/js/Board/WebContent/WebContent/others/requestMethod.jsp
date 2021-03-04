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

나의 IP = <%=request.getRemoteAddr() %> <br>
데이터 길이 = <%=request.getContentLength()%> <br>
인코딩 = <%=request.getCharacterEncoding() %> <br>
컨텐츠타입 = <%=request.getContentType() %> <br>
프로토콜 = <%=request.getProtocol() %> <br>
전송방식 = <%=request.getMethod() %> <br>
URL = <%=request.getRequestURI() %> <br>
컨텍스트 경로 = <%=request.getContextPath() %> <br>
서버 이름 = <%=request.getServerName() %> <br>
서버 포트 = <%=request.getServerPort() %> <br>

</body>
</html>