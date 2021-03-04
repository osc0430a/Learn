<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 및 주소관리 (입력화면)</title>

<link rel="stylesheet" type="text/css" href="../css/main.css">

<%@include file = "../include/dbCon.jsp" %>

</head>

<%

String qry = "select max(a1)+1 as postNumber from post";
int postNumber = 0;

ResultSet rs = stmt.executeQuery(qry);

if(rs.next()){
	
	postNumber = rs.getInt("postNumber");
	
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

</script>

<body>

<form name="frm" method="post" action="postWriteSave.jsp">

<table class="table1">

<caption>우편번호 등록</caption>

<colgroup>

	<col width="25%"/>
	<col width="*"/>

</colgroup>

<tr>
	<th class="td1">우편번호</th>
	<td class="td1"><input type="text" name="a1" value="<%=postNumber %>"></td>
</tr>

<tr>
	<th class="td1">시, 도</th>
	<td class="td1"><input type="text" name="a2"></td>
</tr>

<tr>
	<th class="td1">군, 구</th>
	<td class="td1"><input type="text" name="a3"></td>
</tr>

<tr>
	<th class="td1">동, 면</th>
	<td class="td1"><input type="text" name="a4"></td>
</tr>

<tr>
	<th class="td1">리</th>
	<td class="td1"><input type="text" name="a5"></td>
</tr>

<tr>
	<th class="td1">도서</th>
	<td class="td1"><input type="text" name="a6"></td>
</tr>

<tr>
	<th class="td1">번지</th>
	<td class="td1"><input type="text" name="a7"></td>
</tr>

<tr>
	<th class="td1">기타(건물명)</th>
	<td class="td1"><input type="text" name="a8"></td>
</tr>

</table>


<div style= "width:600px;text-align:center;margin-top:5px">

	<button type="submit" onclick="fn_submit(); return false;">저장</button>
	<button type="reset" >취소</button>
	<button type="button" onclick="location='postList.jsp';">목록</button>

</div>


</form>


</body>
</html>