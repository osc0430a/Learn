<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/dbCon.jsp" %>

<% 
	
	String unq=request.getParameter("unq");

	if( unq == null ){
	%>
		<script>
		
		alert("잘못된 접근입니다.");
		location="/";
		
		</script>
		
	<%
		return;
	}
	
	String qry="delete from board1 where unq='"+unq+"'";
	
	int result = stmt.executeUpdate(qry);
	
	if(result>0){
	%>
		<script>
		
		alert("삭제 완료.");
		window.opener.location.href = "boardList.jsp";
		self.close();
		
		</script>
		
	<%
	}
	else{
	%>
		<script>
		
		alert("삭제 실패.");
		
		</script>
		
	<%
		return;
	}	

%>