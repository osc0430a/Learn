<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@include file="../include/dbCon.jsp" %>

<%

String pdate = request.getParameter("pdate");
String title = request.getParameter("title");
String content = request.getParameter("content");

String qry1 = "update plan set title='"+title+"', content='"+content+"' where pdate='"+pdate+"'";

int result = stmt.executeUpdate(qry1);

if(result > 0){
%>

<script>

alert("갱신 완료");
self.close();

</script>

<%
}
else {
%>

<script>

alert("갱신 실패");
history.back();

</script>
	
<%
}
%>