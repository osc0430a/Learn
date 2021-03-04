<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	// 세션변수 없애는법 1. session.setAttribute("세션변수명", null);
	// 세션변수 없애는법 2. session.removeAttribute("SESSION_ID");
	// 전체 세션변수 없애는법 3. session.invalidate();
	
	session.removeAttribute("SESSION_ID");

%>

<script>

	alert("로그아웃 되었습니다.");
	location = "/";

</script>