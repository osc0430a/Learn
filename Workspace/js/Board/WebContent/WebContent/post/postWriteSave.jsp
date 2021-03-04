<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/dbCon.jsp" %>
  
<%

String a1 = request.getParameter("a1");
String a2 = request.getParameter("a2");
String a3 = request.getParameter("a3");
String a4 = request.getParameter("a4");
String a5 = request.getParameter("a5");
String a6 = request.getParameter("a6");
String a7 = request.getParameter("a7");
String a8 = request.getParameter("a8");

if(a1 == null || a2 == null){
%>
	
	<script>
	
	alert("잘못된 접근입니다.");
	history.back();
		
	</script>

<%	
return;

}

a1 = a1.trim();
a2 = a2.trim();

if(a1.length() != 6 || a2.equals("")){
%>
	
	<script>
	
	alert("다시 시도해주세요.");
	history.back();
	
	</script>
	
<%
return;
}

String qry = "insert into post(a1,a2,a3,a4,a5,a6,a7,a8) values('"+a1+"','"+a2+"','"+a3+"'"+
",'"+a4+"','"+a5+"','"+a6+"','"+a7+"','"+a8+"')";

int result = stmt.executeUpdate(qry);

if(result >0){
	
%>
	
	<script>
	
	alert("저장 완료");
	location = "postList.jsp"
	
	</script>

<%	
}
else{
%>

	<script>
	
	alert("저장 실패");
	history.back();
	
	</script>

<%
}
%>  