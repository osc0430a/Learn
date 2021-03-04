<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/dbCon.jsp" %>
<%

String title="";
String content="";
String button="";
String saveUrl="planSave.jsp";
String pdate=request.getParameter("date");
String qry="select pdate, title, content from plan where pdate='"+pdate+"'";

ResultSet rs = stmt.executeQuery(qry);



if(rs.next()){

	title = rs.getString("title");
	content = rs.getString("content");
	saveUrl = "planUpdate.jsp";
	button = "<button type='button' onclick='fn_del()'>삭제</button>";
}

%>
<script>

function fn_submit(){ //사용자 함수
		
	if(document.frm.pdate.value == ""){
		alert("날짜를 입력해주세요.");
		return false;
	}
	if(document.frm.title.value == ""){
		alert("제목를 입력해주세요.");
		return false;
	}
	
	document.frm.submit();
	
}

function fn_del(){
	
	if(confirm("정말 삭제하시겠 습니까?")){
		
		location = "planDel.jsp?pdate=<%=pdate%>";
	
	}
}


</script>


<head>
<meta charset="UTF-8">
<title>일정관리화면</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>

<form name="frm" method="post" action="<%= saveUrl%>">

<table class="tabel2">

<colgroup>

<col width="25%" />
<col width="75%" />

</colgroup>

<tr>

<th class="td2">날짜</th>
<td class="td2"><input type="text" name="pdate" value=<%=pdate %> readonly></td>

</tr>
<tr>

<th class="td2">제목</th>
<td class="td2"><input type="text" name="title" value=<%=title %> ></td>

</tr>
<tr>

<th class="td2">내용</th>
<td class="td2">
<textarea rows="5" cols="30" name="content" ><%=content %></textarea>
</td>

</tr>


</table>

<div style="width:380px; text-align:center; margin-top:5px">

<button type="submit" onclick="fn_submit(); return false;">저장</button>
<button type="reset">취소</button>
<%=button %>

</div>

</form>

</body>
</html>