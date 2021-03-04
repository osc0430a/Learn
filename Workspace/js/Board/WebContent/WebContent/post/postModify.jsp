<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 및 주소 수정화면</title>

<link rel="stylesheet" type="text/css" href="../css/main.css">

<%@include file = "../include/dbCon.jsp" %>

</head>

<%

int postNumber = 100011;
if( request.getParameter("a1") != null)
	postNumber = Integer.parseInt(request.getParameter("a1"));

String qry = "select + "
		+ "nvl(a1,' ') a1,"
		+ "nvl(a2,' ') a2,"
		+ "nvl(a3,' ') a3,"
		+ "nvl(a4,' ') a4,"
		+ "nvl(a5,' ') a5,"
		+ "nvl(a6,' ') a6,"
		+ "nvl(a7,' ') a7,"
		+ "nvl(a8,' ') a8 "
		+ " from post where a1='"+postNumber+"'";

ResultSet rs = stmt.executeQuery(qry);

String a1 = "";
String a2 = "";
String a3 = "";
String a4 = "";
String a5 = "";
String a6 = "";
String a7 = "";
String a8 = "";

if(rs.next()){
	
	a1 = rs.getString("a1");
	a2 = rs.getString("a2");
	a3 = rs.getString("a3");
	a4 = rs.getString("a4");
	a5 = rs.getString("a5");
	a6 = rs.getString("a6");
	a7 = rs.getString("a7");
	a8 = rs.getString("a8");

	if(a1.equals(" ")){
		
		a1="";
		
	}
	if(a2.equals(" ")){
		
		a2="";
		
	}
	if(a3.equals(" ")){
		
		a3="";
		
	}
	if(a4.equals(" ")){
		
		a4="";
		
	}
	if(a5.equals(" ")){
		
		a5="";
		
	}
	if(a6.equals(" ")){
		
		a6="";
		
	}
	if(a7.equals(" ")){
		
		a7="";
		
	}
	if(a8.equals(" ")){
		
		a8="";
		
	}	
	
}
else{
	
	return;
	
}

%>

<script>


function fn_submit(){
	
	var f = document.frm;
	//alret("우편번호를 입력해 주세요");
	if(f.a1.value == ""){
		alert("우편번호를 입력해 주세요");
		f.a1.focus();
		return false;
	}
	if(f.a1.value.length != 6){
		alert("우편번호를 다시 확인해 주세요");
		f.a1.focus();
		return false;
	}
	if(f.a2.value==""){
		alert("시, 도를 입력해 주세요.");
		f.a2.focus();
		return false;
	}
	f.submit();
	
}

function fn_del(){
	
	if(confirm("정말 삭제하시겠습니까?")){
		
		var url = "postDelete.jsp?a1=<%=a1 %>";	
		location = url;
		
	}
	
}

</script>

<body>

<form name="frm" method="post" action="postModifySave.jsp">

<table class="table1">

<caption>우편번호 등록</caption>

<colgroup>

	<col width="25%"/>
	<col width="*"/>

</colgroup>

<tr>
	<th class="td1">우편번호</th>
	<td class="td1"><input type="text" name="a1" value="<%=a1 %>" readonly></td>
</tr>

<tr>
	<th class="td1">시, 도</th>
	<td class="td1"><input type="text" name="a2" value="<%=a2 %>"></td>
</tr>

<tr>
	<th class="td1">군, 구</th>
	<td class="td1"><input type="text" name="a3" value="<%=a3%>"></td>
</tr>

<tr>
	<th class="td1">동, 면</th>
	<td class="td1"><input type="text" name="a4" value="<%=a4 %>"></td>
</tr>

<tr>
	<th class="td1">리</th>
	<td class="td1"><input type="text" name="a5" value="<%=a5 %>"></td>
</tr>

<tr>
	<th class="td1">도서</th>
	<td class="td1"><input type="text" name="a6" value="<%=a6 %>"></td>
</tr>

<tr>
	<th class="td1">번지</th>
	<td class="td1"><input type="text" name="a7" value="<%=a7 %>"></td>
</tr>

<tr>
	<th class="td1">기타(건물명)</th>
	<td class="td1"><input type="text" name="a8" value="<%=a8 %>"></td>
</tr>

</table>


<div style= "width:600px;text-align:center;margin-top:5px">

	<button type="submit" onclick="fn_submit(); return false;">수정</button>
	<button type="reset" >취소</button>
	<button type="button" onclick="location='postList.jsp';">목록</button>
	<button type="button" onclick="fn_del(); return false;" style="float:right">삭제</button>

</div>


</form>


</body>
</html>