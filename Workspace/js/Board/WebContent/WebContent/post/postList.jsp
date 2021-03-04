<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../include/dbCon.jsp" %>

<%

String pageNo = request.getParameter("pageNo");

if(pageNo == null || pageNo == ""){
	
	pageNo = "1";	
	
}

int rnMin, rnMax, num;

num = Integer.parseInt(pageNo);

if(num<1){
	
	rnMin = 0;
	rnMax = 0;
}
else{
	
	rnMin = 1+10*(num-1);
	rnMax = rnMin+(10-1);
	
}

%>
  
<%

String qry1 = "select count(*) as total from post";
int total=0;
ResultSet rs1 = stmt.executeQuery(qry1);

if(rs1.next()){
	
	total = rs1.getInt("total");
	
}

//String qry2 = "select a1,a2,a3,a4,a5,a6,a7,a8 from post "
//			+"order by a1 asc";
String qry2 = "select p2.* from "
			+ "( select rownum rn,p1.* "
			+ "from ( select "
			+ "nvl(a1,' ') a1,"
			+ "nvl(a2,' ') a2,"
			+ "nvl(a3,' ') a3,"
			+ "nvl(a4,' ') a4,"
			+ "nvl(a5,' ') a5,"
			+ "nvl(a6,' ') a6,"
			+ "nvl(a7,' ') a7,"
			+ "nvl(a8,' ') a8 "
			+ "from post order by a1 asc )"
			+ " p1	) "
			+ "p2 where rn >= "+rnMin+" and rn <= "+rnMax;

			ResultSet rs2 = stmt.executeQuery(qry2);

			



%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 목록</title>
</head>

<link rel="stylesheet" type="text/css" href="../css/layout.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">

<body>
<div> 총: <%=total %>개 </div>

<table class="table1">

<tr>
<th class="td1">번호</th>
<th class="td1">우편번호</th>
<th class="td1">시, 도</th>
<th class="td1">구, 군</th>
<th class="td1">동, 면</th>
<th class="td1">읍, 리</th>
<th class="td1">도서</th>
<th class="td1">번지</th>
<th class="td1">기타</th>
</tr>

<%

	while(rs2.next()){
		String a1 = rs2.getString("a1");
		String a2 = rs2.getString("a2");
		String a3 = rs2.getString("a3");
		String a4 = rs2.getString("a4");
		String a5 = rs2.getString("a5");
		String a6 = rs2.getString("a6");
		String a7 = rs2.getString("a7");
		String a8 = rs2.getString("a8");
		
%>

<tr>

<td class="td1"><%=rs2.getInt("rn") %></td>
<td class="td1"><a href="postModify.jsp?a1=<%=a1 %>"><%=a1 %></a></td>
<td class="td1"><%=a2 %></td>
<td class="td1"><%=a3 %></td>
<td class="td1"><%=a4 %></td>
<td class="td1"><%=a5 %></td>
<td class="td1"><%=a6 %></td>
<td class="td1"><%=a7 %></td>
<td class="td1"><%=a8 %></td>

</tr>


<%
} 
%>
</table>

<div style="width:600px;margin-top:5px">
	
	<%
	
		if(num<=1){
		%>
		
			<button type="button" style="float:left" >이전</button>
			
		<% 				
		}
		else{
		%>
			<button type="button" style="float:left" onclick="location='postList.jsp?pageNo=<%=num-1%>'">이전</button>
		<%
		}
	%>
	
	<button type="button" style="float:right" onclick="location='postList.jsp?pageNo=<%=num+1 %>'">다음</button>
	<button type="button" style="position:relative; left:230px" onclick="location='postWrite.jsp'">삽입</button>
</div>

</body>
</html>