<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@include file="../include/dbCon.jsp" %>

<%

String pdate = request.getParameter("pdate");
String title = request.getParameter("title");
String content = request.getParameter("content");

String qry1 = "insert into plan(pdate, title, content) values('"+pdate+"', '"+title+"', '"+content+"')";
String qry2 = "select count(*) as cnt from plan where pdate='"+pdate+"'";

ResultSet rs = stmt.executeQuery(qry2);

if(rs.next()){
	int cnt = rs.getInt("cnt");
	
	if(cnt>0){
		%>
		
		<script>
		
		alert("이미 저장된 날짜입니다.");
		self.close();
		
		</script>
		
		<%
		return;
	}
	
}

int result = stmt.executeUpdate(qry1);

if(result > 0){
%>

<script>

alert("저장 완료");
self.close();

</script>

<%
}
else {
%>

<script>

alert("저장 실패");
history.back();

</script>
	
<%
}
%>