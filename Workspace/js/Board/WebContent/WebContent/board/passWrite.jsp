<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/dbCon.jsp" %>

<!doctype html>

<html lang="en">

<%

	String unq = request.getParameter("unq");

	if(unq.equals("") || unq == null){
	%>
		<script>
		
			alert("잘못된 접근입니다.");
			location="../main/main.jsp";
			
		</script>
	<%	
		return;	
		
	}

	String qry = "select pass from board1 where unq="+unq;
	
	ResultSet rs = stmt.executeQuery(qry);
	
	String pass="";
	
	if(rs.next()){
		
		pass=rs.getString("pass");
		
	}
	
%>

<head>

<meta charset="UTF-8">

<title>비밀번호 확인</title>

<link rel="stylesheet" type="text/css" href="../css/layout.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">

</head>

<script>

function fn_submit(){
	
	var f = document.frm;
	if(f.pass.value == ""){
		
		alert("비밀번호를 입력해주세요.");
		f.pass.focus();
		return;
		
	}
	
	if(f.pass.value == <%=pass%>){
		
		f.submit();
		
	}
	else{
		
		alert("비밀번호 오류.");
		f.pass.focus();
		return;
		
	}
	
	
}

</script>


<body>

	

<div >
	
		<form name="frm" method="post" action="boardDelete.jsp">
	
		<input type="hidden" name = "unq" value=<%=unq %>>
	
		<div style="width:100%;text-align:center">
				
			비밀번호: 
						
			<input type="password" name="pass" style="width:50%;margin-bottom:5px;margin-top:30px" >
			
			<button type="submit" onclick="fn_submit(); return false;">완료</button>	
		
		</div>		
		
		</form>
	
	</div>

</body>

</html>