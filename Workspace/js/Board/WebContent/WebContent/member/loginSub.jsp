<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/dbCon.jsp" %>

<%

	String userid = request.getParameter("userid");
	String pass = request.getParameter("pass");
	
	if( userid == null || pass == null ){
	%>
		<script>
		
			alert("잘못된 접근입니다.");
			location="/";
		
		</script>				
	<%
		return;
	}
	
	String qry = "select count(*) as cnt from memberInfo where userid = '"+userid+"' and " 
			   + "pass = '"+pass+"' ";
	
	ResultSet rs = stmt.executeQuery(qry);
	
	int cnt = 0;
	
	if(rs.next()){
		
		cnt = rs.getInt("cnt");
		
		if( cnt == 0 ){
		%>
			<script>
			
				alert("아이디 혹은 비밀번호 오류");
				history.back();
			
			</script>			
		<%	
			return;
		}
		
	}
	
	session.setAttribute("SESSION_ID", userid);
	
%>

	<script>
	
		alert("<%=userid%>님 환영합니다.");
		self.close();
		opener.location="/";
	
	</script>


