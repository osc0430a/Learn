<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/dbCon.jsp" %>

<%

String pdate = request.getParameter("pdate");

String qry1 = "delete from plan where pdate='"+pdate+"'";

int result = stmt.executeUpdate(qry1);

if(result > 0){
%>

<script>

alert("삭제 완료");
self.close();

</script>

<%
}
else {
%>

<script>

alert("삭제 실패");
history.back();

</script>
	
<%
}
%>