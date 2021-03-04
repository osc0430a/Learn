<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../include/dbCon.jsp" %>

<% 

	String title=request.getParameter("title");
	String name=request.getParameter("name");
	String pass=request.getParameter("pass");
	String content=request.getParameter("content");
	
	if(title == null || pass == null){
	%>
		<script>
		
			alert("잘못된 접근입니다.");
			location="../main/main.jsp";
			
		</script>
	<%	
		return;
	}
	
	title.trim();
	pass.trim();
	name.trim();
	
	if(title.equals("")){
	%>
		<script>
		
		alert("제목 입력 오류.");
		history.back();	
		
		</script>
		
	<%		
		return;
	}
	
	if(name.equals("")){
	%>
		
		<script>
		
		alert("이름 입력 오류.");
		history.back();	
		
		</script>
		
	<%
		return;
	}
	
	if(pass.equals("")){
	%>
		
		<script>
		
		alert("비밀번호 입력 오류.");
		history.back();	
		
		</script>
		
	<%	
		return;
	}
	
	if(content.length() > 4000){
	%>
		
		<script>
		
		alert("내용이 너무 많습니다. \n4000자 미만으로 작성해 주세요.");
		history.back();	
		
		</script>
		
	<%		
		return;
	}
	
	String qry="insert into board1(unq, title, name, pass, content, rdate) "
			 + "values(board1_seq.nextval,'"+title+"','"+name+"','"+pass+"','"+content+"',sysdate)";
	
	int result = stmt.executeUpdate(qry);
	
	if(result>0){
	%>
		<script>
		
		alert("저장 완료.");
		location = "boardList.jsp";
		
		</script>
		
	<%
	}
	else{
	%>
		<script>
		
		alert("저장 실패.");
		history.back();	
		
		</script>
		
	<%
		return;
	}	

%>