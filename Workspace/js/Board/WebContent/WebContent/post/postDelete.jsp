<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/dbCon.jsp" %>
  
<%

String a1 = request.getParameter("a1");

String qry = "delete from post where "
			+"a1='"+a1+"'";

int result = stmt.executeUpdate(qry);

if(result >0){
	
%>
	
	<script>
	
	alert("삭제 완료");
	location = "postList.jsp"
	
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