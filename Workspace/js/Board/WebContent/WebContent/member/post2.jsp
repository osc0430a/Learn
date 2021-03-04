<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/dbCon.jsp" %>

<%

	String dong = request.getParameter("dong");

	String qry = "select '['||a1||'] '||a2||' '||a3||' '||a4||' '||a5||' '||a6||' '||a7||' '||a8 as addr "
			   + "from post " 
			   + "where a4 like '%"+dong+"%' " 
			   + "or a5 like '%"+dong+"%' " 
			   + "or a6 like '%"+dong+"%' " 
			   + "or a7 like '%"+dong+"%' ";
	// [123456] 서울시강남구 ~ 형식으로 맞추기.
	
	ResultSet rs = stmt.executeQuery(qry);
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 입력</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

</head>

<script>

	$(function(){
		
		$("#action_btn").click(function(){
			
			var addr = $("#addr").val();
			var post = addr.substring(1,7);
			var address = addr.substring(9).trim();
			opener.frm.post.value = post;
			opener.frm.addr.value = address;
			self.close();
			
		});		
		
	});

</script>

<body>

	<select name="addr" id="addr">
	
	<%
		while(rs.next()){
			
			String addr = rs.getString("addr");
		%>
			
			<option value="<%=addr %>"><%=addr %></option>
			
		<%	
		}	
	%>
		
	
	</select>
	<br>
	<button type="button" id="action_btn">적용</button>

</body>
</html>