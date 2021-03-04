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
	
	String qry1="select fid, thread from reboard where unq = '"+unq+"'";
	String fid="";
	String thread="";
	int cnt = 0;
	
	ResultSet rs = stmt.executeQuery(qry1);
	
	if(rs.next()){
		
		fid = rs.getString("fid");
		thread = rs.getString("thread");
		
	}
	
	String qry2= "select count(*) as cnt from reboard where fid = "+fid
				+" and thread like '"+thread+"_'";
	
	rs = stmt.executeQuery(qry2);
	
	if(rs.next()){
		
		cnt = rs.getInt("cnt");
	
		
	}
	
	String qry3 = "";
	
	if( cnt == 0 ){
	
		qry3 = "delete from reboard where unq='"+unq+"'";
		
	}
	else{
		
		qry3 = "update reboard set title='게시자에 의한 삭제', content='' where unq='"+unq+"'";
		
	}
	
	int result = stmt.executeUpdate(qry3);
	
	if( result > 0 ){
	%>
		<script>
		
		alert("삭제 완료.");
		window.opener.location.href = "reboardList.jsp";
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