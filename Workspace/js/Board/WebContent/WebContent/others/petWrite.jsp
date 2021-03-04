<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="frm" method="post" action="petWriteSub.jsp">

주인이름 : <input type="text" name="name"> <br>
주소 : <input type="text" name="addr"> <br>
애완동물 종류 : 
<input type="checkbox" name="pet" value="dog">강아지
<input type="checkbox" name="pet" value="cat">고양이
<input type="checkbox" name="pet" value="pig">돼지
<br>
<input type="submit" value="전송">
 
</form>


</body>
</html>