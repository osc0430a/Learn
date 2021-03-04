<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/dbCon.jsp" %>

<%
	
	String uid = request.getParameter("userid");
	String eng = request.getParameter("eng");
	String kor = request.getParameter("kor");
	String math = request.getParameter("math");

	String qry = "update score set eng='"+eng+"',kor='"+kor+"',math='"+math+"' where userid='"+uid+"'";
	
	int result = stmt.executeUpdate(qry);
	
	if(result>0){
		%>
		
		<script>
			alert("변경 완료");
			location = "scoreList.jsp";
		</script>
		
		<%
		}
		else{
		%>
		<script>
			alert("변경 실패");
			location = "scoreList.jsp";
		</script>
		<%
		}

%>