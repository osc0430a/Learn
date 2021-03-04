<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>

<%@ include file="../include/dbCon.jsp" %>

<%

String qry = "select userid,eng,kor,math from score";

ResultSet rs = stmt.executeQuery(qry);

%>


<html lang="en">

<head>

<meta charset="UTF-8">

<title>샘플</title>

<link rel="stylesheet" type="text/css" href="../css/layout.css">

</head>

<body>

	<div class="header">
		<%@ include file="../include/topMenu.jsp" %>		
	</div>

	<div class="side">111</div>
	<div class="section">
	<div style="margin-top:5px;margin-bottom:5px;width:600px;text-align:right">
	
	<button type="button" onclick="location='scoreWrite.jsp'">글쓰기</button>
	
	</div>	
		<table border="1" width="600">
			
			<tr>
				
				<th>아이디</th>
				<th>영어</th>
				<th>국어</th>
				<th>수학</th>
				<th>삭제</th>
			</tr>
			
			<%
			
			while(rs.next()){
				String userid = rs.getString("userid");
				int eng = rs.getInt("eng");
				int kor = rs.getInt("kor");
				int math = rs.getInt("math");
			%>
					<tr>
						<td align="center"><a href="scoreModify.jsp?userid=<%=userid%>"><%=userid %></a></td>
						<td align="center"><%=eng %></td>
						<td align="center"><%=kor %></td>
						<td align="center"><%=math %></td>	
						<td align="center"><a href="scoreDelete.jsp?userid=<%=userid %>">DEL</a></td>	
					</tr>			
			<%
			}
			%>
			
		</table>
		
	</div>
	<div class="footer"></div>

</body>

</html>