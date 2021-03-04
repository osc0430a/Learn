<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/dbCon.jsp" %>

<%

	String pass1 = request.getParameter("pass1");
	String pass2 = request.getParameter("pass2");
	String pass3 = request.getParameter("pass3");
	String userid = (String)session.getAttribute("SESSION_ID");
	
	if( userid == null ){
	%>	
		
		<script>
		
			alert("로그인 해주십시오.");
			self.close();
		
		</script>
		
	<%	
	}
	
	if( pass1 == null || pass2 == null || pass3 == null ){
	%>	
		
		<script>
		
			alert("잘못된 접근입니다.");
			self.close();
		
		</script>
		
	<%
		return;
	}	
	
	if( !pass2.equals(pass3) ){
	%>
		<script>
		
			alert("변경할 암호가 일치하지 않습니다.");
			history.back();
		
		</script>
	<%
		return;
	}
	
	String qry1 = "select count(*) as cnt from memberInfo where userid = '"+userid+"' and pass = '"+pass1+"'";
	
	ResultSet rs = stmt.executeQuery(qry1);
	int cnt = 0;
	
	if( rs.next() ){
		
		cnt = rs.getInt("cnt");
		
	}
	
	if( cnt == 0 ){
	%>
		<script>
		
			alert("기존 암호가 일치하지 않습니다.");
			history.back();
		
		</script>
	<%
		return;
	}
	
	String qry2 = "update memberInfo set pass = '"+pass2+"' where userid = '"+userid+"' and pass = '"+pass1+"'";
	
	int result = stmt.executeUpdate(qry2);
	
	if( result > 0 ){
	%>
		<script>
		
			alert("변경 성공.");
			self.close();
		
		</script>
	<%
		return;
	}
	else{
	%>
		<script>
		
			alert("변경 실패.");
			self.close();
		
		</script>
	<%
		return;
	}

%>