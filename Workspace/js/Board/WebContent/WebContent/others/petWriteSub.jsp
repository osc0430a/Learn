<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 출력</title>
</head>
<body>

<%request.setCharacterEncoding("UTF-8"); %>

주인이름 : <%=request.getParameter("name") %> <br>
주인주소 : <%=request.getParameter("addr") %> <br>
<p>
애완동물 종류 : 
<%

String[] values = request.getParameterValues("pet");
int i=0;
if(values != null){

	for(String val:values){
		if(i!=0){
			out.print(", ");
		}
		out.print(val + " ");
		i++;
	}
}
else{
	out.print("Nothing");
}


%>

</body>
</html>