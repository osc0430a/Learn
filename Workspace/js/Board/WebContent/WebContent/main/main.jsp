<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>

<!doctype html>

<html lang="en">

<%
Calendar cal = Calendar.getInstance();
int y = cal.get(Calendar.YEAR);
int m = cal.get(Calendar.MONTH);

cal.set(y, m, 1); //출력 월의 1일로 세팅
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //1일날의 요일 일(1) 월(2) ~ 토(7)
int lastday = cal.getActualMaximum(Calendar.DATE); //마지막 날자
%>

<head>

<meta charset="UTF-8">

<title>일정 관리화면</title>

<link rel="stylesheet" type="text/css" href="../css/layout.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">

</head>

<script>

function fn_popup(day){
	
	var date = "<%=y%>-<%=m+1%>-"+day;
	window.open('plan.jsp?date='+date,'popup','width=400,height=400');
	
}


</script>

<body>

	<div class="header">

		<%@ include file="../include/topMenu.jsp" %>

	</div>

	<div class="side">111</div>
	<div class="section" >
	
		<div>
		<%=y%>년
		<%=m + 1%>월
		</div>
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
	<table class="table1">
		<!-- <th>의 경우 굵음표시 , 좌우정렬(센터)  -->
		<tr>
			<th class="td1">일</th>
			<th class="td1">월</th>
			<th class="td1">화</th>
			<th class="td1">수</th>
			<th class="td1">목</th>
			<th class="td1">금</th>
			<th class="td1">토</th>
		</tr>
		<tr align="center"> <!-- 가운데 정렬  -->			
			<%
				int cnt = 0;
				for (int i = 1; i < dayOfWeek; i++) {
					cnt++;
			%>
			<td class="td1"></td>
			<%
				}
				for (int d = 1; d <= lastday; d++) {
				cnt++;
			%>
			<td class="td1"><a href="javascript:fn_popup('<%=d %>');"><%=d%></a></td>
			<%
				if (cnt % 7 == 0)
				out.print("</tr><tr align=\"center\">");
			}
				for(;cnt%7!=0;cnt++){
			%>
					<td class="td1"></td>
			<% 
				}
			%>			
			</tr>
		
	</table>	
	
	</div>
	<div class="footer"></div>

</body>

</html>