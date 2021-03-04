<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/dbCon.jsp" %>

<%

	String userid = request.getParameter("userid");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	String post = request.getParameter("post");
	String addr = request.getParameter("addr");
	String edu = request.getParameter("edu");
	String gender = request.getParameter("gender");
	String[] tmp = birth.split("/");
	birth = tmp[2]+"-"+tmp[0]+"-"+tmp[1];

	String qry = "insert into memberInfo(unq, userid, pass, name, birth, gender, post, addr, edu, rdate) " 
			   + "values(memberInfo_seq.nextval, " 
			   + "'"+userid+"', '"+pass+"', '"+name+"'," 
			   + " '"+birth+"', '"+gender+"', '"+post+"', '"+addr+"', "+edu+", sysdate)";
	
	int result = stmt.executeUpdate(qry);
	
	if( result > 0 ){
	%>
		
		<script>

			alert("가입 완료");
			location = "/";
			
		</script>
		
	<%
	}
	else{
	%>
	
		<script>

			alert("가입 실패");
			history.back();
			
		</script>	
				
	<%
	}
	
%>