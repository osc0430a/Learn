<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/dbCon.jsp" %>

<%

// total 개수
String qry1 = "select count(*) total from reboard";

ResultSet rs1 = stmt.executeQuery(qry1);

int total = 0;
int totalPage = 0;
int number = 0;
int v_page = 1;
int startNo = 0;
int endNo = 0;
int page_unit = 10;

if( request.getParameter("v_page") != null ){
	
	v_page = Integer.parseInt(request.getParameter("v_page"));
	
}

startNo = ((v_page-1)*page_unit)+1;
endNo = startNo+(page_unit-1);

if(rs1.next()){
	
	total = rs1.getInt("total");
	/*
	if(total%10 == 0){
		
		totalPage = total/10;
	
	}
	else{
	
		totalPage = total/10 + 1;
		
	}
	*/
	totalPage = (int) Math.ceil((double)total/page_unit);
	number = total-((v_page-1)*page_unit);

}

// 목록 처리
String search = request.getParameter("search");
String searchCode = request.getParameter("searchCode");
String qry2 = "";
String where = "";

if(searchCode != null && search != null){

	where = "where "+searchCode+" like '%"+search+"%' ";

}

	qry2 = "select b2.* from "
				+ "( select rownum rn, b1.* from ( "
				+ "select unq, title, name, hits, rdate, fid, thread "
				+ "from reboard " + where
				+ "order by fid desc, thread asc ) b1 "
				+ ") b2 "
				+ "where rn >= "+startNo+" and rn <= "+endNo;



	ResultSet rs2 = stmt.executeQuery(qry2);

%>


<!doctype html>

<html lang="en">

<head>

<meta charset="UTF-8">

<title>게시글 목록</title>

<link rel="stylesheet" type="text/css" href="../css/layout.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">

</head>

<style>

	.divTable1 {
	
		position:relative;
		left:50px;
		top:20px;
		width:600px;
	
	}

</style>

<body>

	<div class="header">

		<%@ include file="../include/topMenu.jsp" %>

	</div>

	<div class="content">

	<div class="side">111</div>
	
	<div class="section" >
	
		<div style="width:600px;position:relative;left:52px;margin-top:5px">total: <%=total %>개</div>
		
		
		<div style="width:600px;position:relative;left:50px;text-align:right">
		
			<button type="button" style="float:right" onclick="location='reboardWrite.jsp'">글쓰기</button>		
			
			<form name="frm2" method="post" action=<%=request.getRequestURI() %>>
				
				<select name="searchCode">
				
					<option value="title">제목</option>
					<option value="content">내용</option>
				
				</select>
				
				<input type="text" name="search" ></input>
		
				<button type="submit" style="margin-right:5px">검색</button>
			
			</form>
		
		</div>
		
		<div class="divTable1">
		
			<table class="table1">
			
			<caption>게시판 목록</caption>
			
			<colgroup>
			
				<col width="10%"/>
				<col width="40%"/>
				<col width="15%"/>
				<col width="15%"/>
				<col width="15%" />
				
			
			</colgroup>
			
			<tr>
			
				<th class="td1">번호</th>
				<th class="td1">제목</th>
				<th class="td1">글쓴이</th>
				<th class="td1">등록일</th>
				<th class="td1">조회수</th>
				
			
			</tr>
			<%			
			
			while(rs2.next()){			
				String title = rs2.getString("title");
				String name = rs2.getString("name");
				String rdate = rs2.getString("rdate");
				String hits = rs2.getString("hits");
				String unq = rs2.getString("unq");
				String thread = rs2.getString("thread");
				
				int point = 0;
				
				point = rdate.indexOf(':');
				rdate = rdate.substring(0,point-2);
			%>
			
				<tr>
				
					<td class="td1" style="text-align:center"><%=number %></td>					
					<td class="td1"><a href="reboardDetail.jsp?unq=<%=unq%>">
					<% 
							
						for(int i=1; i<thread.length(); i++){
								
							out.print("&nbsp;&nbsp;");
								
						}
							

						if(thread.length() != 1)
							out.print("[RE]");
					
					%>
					<%=title %></a></td>
					<td class="td1" style="text-align:center"><%=name %></td>
					<td class="td1" style="text-align:center"><%=rdate %></td>
					<td class="td1" style="text-align:center"><%=hits %></td>
				
				</tr>			
			
			<%
				number--;
			}
			%>
			</table>
					
		</div>
		
		<div style="width:600px;text-align:center;position:relative;left:50px;top:20px">
			
				<%
				
				for(int i=1; i<=totalPage; i++){
				%>
				
					<a href="reboardList.jsp?v_page=<%=i%>" style="text-size:5px"><%=i %></a>
				
				<%
				}
				
				%>
			
			</div>
	
	</div>
	
	</div>
	
	<div class="footer"></div>

</body>

</html>