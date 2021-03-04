<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/dbCon.jsp" %>

<!doctype html>

<html lang="en">

<%

	String unq = request.getParameter("unq");

	if( unq == null || unq.equals("") ){
	%>
		<script>
		
			alert("잘못된 접근입니다.");
			location="/";
			
		</script>
		
	<%	
		return;	
		
	}

	String qry = "select hits, title, name, content, to_char(rdate,'yyyy/mm/dd') as rdate, "
			   + " fid, thread "
			   + " from reboard where unq="+unq;
	
	ResultSet rs = stmt.executeQuery(qry);
	
	String title="";
	String name="";
	String content="";
	String rdate="";
	String fid="";
	String thread="";
	int hits = 0;
	
	if(rs.next()){
		
		title=rs.getString("title");
		name=rs.getString("name");
		content=rs.getString("content");
		rdate=rs.getString("rdate");
		hits = rs.getInt("hits");
		fid = rs.getString("fid");
		thread = rs.getString("thread");
		
		
	}
	
	hits++;
	
	String qry2 = "update reboard set hits='"+hits+"' where unq = '"+unq+"'";
	
	int result = stmt.executeUpdate(qry2);
	
	if(content == null){
		
		content = "";
		
	}
	else{
		
		content = content.replaceAll("\n","<br>");	
		
	}
	
%>

<head>

<meta charset="UTF-8">

<title>게시글 수정</title>

<link rel="stylesheet" type="text/css" href="../css/layout.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">

</head>

<script>

	function fn_popup(){
		
		var URL = "reboardPassWrite.jsp?unq=<%=unq%>";
		
		window.open( URL, 'popup', 'width=300, height=150' );
				
	}

</script>

<body>

	<div class="header">

		<%@ include file="../include/topMenu.jsp" %>

	</div>
	
	<div class="content">

	<div class="side">111</div>
	
	<div class="section" >
	
		<form name="frm" method="post" action="reboardModify.jsp?unq=<%=unq%>">
	
		<div style="position:relative;
					left:50px">
						
			<table class="table1" style="margin-left:5px;margin-top:5px;">
			
				<caption style="font-size:20px">답변 게시판 상세 보기</caption>
			
				<tr>
				
					<th class="td1">제목</th>
					<td class="td1" ><%=title %></td>
				
				</tr>
				
				<tr>
				
					<th class="td1">글쓴이</th>
					<td class="td1" ><%=name %></td>
				
				</tr>
				
				<tr>
				
					<th class="td1">등록일</th>
					<td class="td1" ><%=rdate %> </td>
				
				</tr>
				
				<tr style="height:220px">
				
					<th class="td1" style="width:20%">내용</th>
					<td class="td1" valign=top style="word-break:break-all;width:80%"><%=content %></td>
				
				</tr>
			
			</table>
		
		<div style="width:600px;text-align:center;margin-top:5px">
		
			<button type="button" onclick="location='reboardList.jsp'">목록</button>	
			
			<button type="button" onclick="location='reboardReply.jsp?unq=<%=unq%>&fid=<%=fid %>&thread=<%=thread %>'">답변</button>
			
			<button type="submit" onclick="fn_submit(); return false;">수정</button>						
			
			<button type="button" onclick="fn_popup(); return false;" style="float:right">삭제</button>
		
		</div>
		
		</div>		
		
		</form>
	
	</div>
	
	</div>
	
	<div class="footer"></div>

</body>

</html>