<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/dbCon.jsp" %>

<%

	String userid = request.getParameter("userid");
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String post = request.getParameter("post");
	String addr = request.getParameter("addr");
	String edu = request.getParameter("edu");
	String gender = request.getParameter("gender");
	String[] tmp = birth.split("/");
	birth = tmp[2]+"-"+tmp[0]+"-"+tmp[1];

	String qry = "update memberInfo set " 
			   + "name = '"+name+"', birth = '"+birth+"', post = '"+post+"', addr = '"+addr+"', "
			   + "edu = '"+edu+"', gender = '"+gender+"' "
			   + "where userid = '"+userid+"'";
	
	int result = stmt.executeUpdate(qry);
	
	if( result > 0 ){
	%>
		
		<script>

			alert("수정 완료");
			location = "/";
			
		</script>
		
	<%
	}
	else{
	%>
	
		<script>

			alert("수정 실패");
			history.back();
			
		</script>	
				
	<%
	}
	
%>