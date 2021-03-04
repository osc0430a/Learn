<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/dbCon.jsp" %>

<%
	
	String uid = request.getParameter("userid");
	String qry = "delete from score where userid='"+uid+"'";
	
	int result = stmt.executeUpdate(qry);
	
	if(result>0){
	%>
	
	<script>
		alert("삭제 완료");
		location = "scoreList.jsp";
	</script>
	
	<%
	}
	else{
	%>
	<script>
		alert("삭제 실패");
		history.back();
	</script>
	<%
	}

%>