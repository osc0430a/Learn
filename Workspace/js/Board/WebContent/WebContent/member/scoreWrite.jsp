<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>

<html lang="en">

<head>

<meta charset="UTF-8">

<title>점수 등록화면</title>

<link rel="stylesheet" type="text/css" href="../css/layout.css">

</head>

<body>

	<div class="header">

		<%@ include file="../include/topMenu.jsp" %>

	</div>

	<div class="side">111</div>
	<div class="section">
	
		<form name="frm" method="post" action="scoreWriteSave.jsp">
		
			<table border="1" class="table1">
			
				<tr>
					<th>아이디</th>
					<td style="text-align:center"><input type="text" name="userid" style="width:90%"></td>
				</tr>
				<tr>
					<th>영어점수</th>
					<td style="text-align:center"><input type="text" name="eng" style="width:90%"></td>
				</tr>
				<tr>
					<th>국어점수</th>
					<td style="text-align:center"><input type="text" name="kor" style="width:90%"></td>
				</tr>
				<tr>
					<th>수학점수</th>
					<td style="text-align:center"><input type="text" name="math" style="align:center;width:90%"></td>
				</tr>
				
			</table>
		<div style="text-align:center;margin-top:10px;width:600px">
				<button type="submit" style="margin-right:50px">저장</button>
				<button type="reset" >취소</button>
		</div>
		</form>	
	
	</div>
	<div class="footer"></div>

</body>

</html>