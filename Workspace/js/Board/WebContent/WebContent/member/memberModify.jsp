<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/dbCon.jsp" %>

<!doctype html>

<html lang="en">

<head>

<meta charset="UTF-8">

<title>회원 정보</title>

<link rel="stylesheet" type="text/css" href="../css/layout.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="../js/script.js" ></script>

<script>

	$(function() {
		$("#birth").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});

	function fn_popup() {

		var url = "post1.jsp";

		window.open(url, 'post', 'width=400, height=200');

	}
	
	$(function(){
		$("#pass_btn").click(function(){
			
			var url = "pass_change.jsp";
			
			window.open(url,'pass_change','width=400, height=200');
			
		});		
	});
	
</script>

</head>

<body>

	<div class="header">

		<%@ include file="../include/topMenu.jsp" %>

	</div>
	
<%
	
	if( SESSION_ID == null ){
	%>
		
		<script>
		
			alert("잘못된 접근입니다.");
			location = "/";
		
		</script>
		
	<%	
		return;
	}
	
	String qry = "select pass, name, to_char(birth, 'mm/dd/yyyy') as birth, gender, nvl(post,' ') post, nvl(addr,' ') addr, edu, " 
			   + "to_char(rdate,'yyyy-mm-dd') rdate "
			   + "from memberInfo " 
			   + "where userid = '"+SESSION_ID+"' ";

	ResultSet rs = stmt.executeQuery(qry);
	
	String pass="";
	String name="";
	String birth="";
	String gender="";
	String post="";
	String addr="";
	String edu="";
	String rdate="";
	
	if(rs.next()){
		
		pass = rs.getString("pass");
		name = rs.getString("name");
		birth = rs.getString("birth");
		gender = rs.getString("gender");
		post = rs.getString("post");
		addr = rs.getString("addr");
		edu = rs.getString("edu");
		rdate = rs.getString("rdate");
		
		
	}
	String time = rdate.substring(0,10);
	post = post.trim();
	addr = addr.trim();
	
%>

<div class="content">

	<div class="side">111</div>
	
	<div class="section" >
	
		<form name="frm" id="frm" method="post" action="memberModifySave.jsp">
	
		<div style="position:relative;
					left:50px">
						
			<table class="table1" style="margin-left:5px;margin-top:5px;">
			
				<caption style="font-size:20pt">회원 정보</caption>
			
				<tr>
				
					<th class="td1">아이디</th>
					<th class="td1"><input type="text" name="userid" id="userid" style="width:80%" 
					value = <%=SESSION_ID %> readonly></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">암호</th>
					<th class="td1"><button type="button" id="pass_btn">암호변경</button></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">등록일</th>
					<th class="td1"><input type="text" name="rdate" style="width:80%"
					value = <%=time %> readonly></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">이름</th>
					<th class="td1"><input type="text" name="name" id="name" style="width:80%" 
					value = <%=name %>></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">생일</th>
					<th class="td1"><input type="text" name="birth" style="width:80%" id="birth"
					value = "<%=birth %>"></th>
				
				</tr>
				
				<tr>
				
					<th class="td1">성별</th>
					<th class="td1">
					<%
					
						if( gender.equals("M") ){
					
					%>
							<input type="radio" name="gender" value="M" checked="checked">남성
							<input type="radio" name="gender" value="F">여성
					<%
						}
						else{
					%>
							<input type="radio" name="gender" value="M" >남성
							<input type="radio" name="gender" value="F" checked="checked">여성
					<%
						}
					
					%>
									
					</th>
				
				</tr>
				
				<tr>
				
					<th class="td1">주소</th>
					<th class="td1">
					
						<input type="text" name="post" style="width:40%;float:left;margin-left:50px" value=<%=post%>>
						<button type="button" onclick="fn_popup()" style="margin-left:48px;margin-bottom:5px">우편번호 검색</button> <br>
						<input type="text" name="addr" style="width:80%" value="<%=addr%>">
						
					</th>
				
				</tr>
				
				<tr>
				
					<th class="td1">학력</th>
					<th class="td1">
						<%
						
						switch(edu){
						
						case "1":
						%>
							<input type="radio" name="edu" value="1" checked="checked">고졸
							<input type="radio" name="edu" value="2">대졸
							<input type="radio" name="edu" value="3">대학원
						<%
							break;
						case "2":
							%>
								<input type="radio" name="edu" value="1" >고졸
								<input type="radio" name="edu" value="2" checked="checked">대졸
								<input type="radio" name="edu" value="3">대학원
							<%
								break;
						case "3":
							%>
								<input type="radio" name="edu" value="1" >고졸
								<input type="radio" name="edu" value="2">대졸
								<input type="radio" name="edu" value="3" checked="checked">대학원
							<%
								break;
						default:
							%>
								<input type="radio" name="edu" value="1" >고졸
								<input type="radio" name="edu" value="2">대졸
								<input type="radio" name="edu" value="3">대학원
							<%
							break;
						}
						
						%>
					</th>
				
				</tr>
			
			</table>
		
		<div style="width:600px;text-align:center;margin-top:5px">
		
			<button type="submit" onclick="fn_submit(); return false;">수정</button>
			
			<button type="reset">다시쓰기</button>		
		
		</div>
		
		</div>		
		
		</form>
	
	</div>
	
	</div>
	
	<div class="footer"></div>

</body>

</html>