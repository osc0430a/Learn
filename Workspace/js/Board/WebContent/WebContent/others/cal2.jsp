<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<!DOCTYPE html>
<%
String year = request.getParameter("year");
String month = request.getParameter("month");
	Calendar cal = Calendar.getInstance();
int y;
if(year!=null&&!year.equals("")) y= Integer.parseInt(year);
else y=cal.get(Calendar.YEAR);
int m;
if(month!=null&&!month.equals("")) m = Integer.parseInt(month)-1;
else m = cal.get(Calendar.MONTH);

cal.set(y, m, 1); //출력 월의 1일로 세팅
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1일날의 요일 일(1) 월(2) ~ 토(7)
int lastday = cal.getActualMaximum(Calendar.DATE); //마지막 날자
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<form name="frm" method="post" action="cal2.jsp">
년 <input type="text" name="year">
월 <input type="text" name="month">
<input type="submit" value="전송"> <br>
<% for(int i=1; i<13; i++){%>
<a href = "cal2.jsp?year=<%=y %>&month=<%=i %>" >	
<%=y%>년 <%=i%>월
</a>
<%
if(i!=0&&i==6)
	%><br><%
}
%>
<br>
</form>
<%
int next=m+2;
%>



</div>
<%
if(m==0){
%>
	<button type="button" onclick="location.href='cal2.jsp?year=<%=y-1%>&month=<%=12%>'">이전</button>
	<%}
else{
%>
	<button type="button" onclick="location.href='cal2.jsp?year=<%=y%>&month=<%=m%>'">이전</button>
<%
}
%>
<%=y%>년
		<%=m + 1%>월
	<%
if(m+1==12){
%>
<button type="button" onclick="location.href='cal2.jsp?year=<%=y+1%>&month=<%=1%>'">다음</button>
<%
}
else{
%>
<button type="button" onclick="location.href='cal2.jsp?year=<%=y%>&month=<%=next%>'">다음</button>
<%
}
%>
		

	<%
		/*
	switch( dayOfWeek ){
	case 1: out.print("일");
	break;
	case 2: out.print("월");
	break;
	case 3: out.print("화");
	break;
	case 4: out.print("수");
	break;
	case 5: out.print("목");
	break;
	case 6: out.print("금");
	break;
	case 7: out.print("토");
	break;
	}
	*/
	%>
	<table border="1">
		<!-- <th>의 경우 굵음표시 , 좌우정렬(센터)  -->
		<tr>
			<th>일</th>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
			<th>토</th>
		</tr>
		<tr align="center"> <!-- 가운데 정렬  -->			
			<%
				int cnt = 0;
				for (int i = 1; i < dayOfWeek; i++) {
					cnt++;
			%>
			<td></td>
			<%
				}
				for (int d = 1; d <= lastday; d++) {
				cnt++;
			%>
			<td><%=d%></td>
			<%
				if (cnt % 7 == 0)
				out.print("</tr><tr align=\"center\">");
			}
				for(;cnt%7!=0;cnt++){
			%>
					<td></td>
			<% 
				}
			%>			
			</tr>
		
	</table>

</body>
</html>