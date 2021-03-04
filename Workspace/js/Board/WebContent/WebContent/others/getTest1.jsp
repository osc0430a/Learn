<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 String eng = request.getParameter("eng");
 String kor = request.getParameter("kor");
 String math = request.getParameter("math");
 %>
 
<%=eng %>, <%=kor %>, <%=math %>
<br>
<% 
String sum = eng + kor + math;
int sum2 =Integer.parseInt(eng) + Integer.parseInt(kor) + Integer.parseInt(math);
int avg = sum2/3;
%>
합계 : <%=sum2%> <br>
평균 : <%=avg %>
