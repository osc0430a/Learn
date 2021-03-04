<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>

<html lang="en">

<head>

<meta charset="UTF-8">

<title>샘플</title>

</head>



<style>
.header {
	width: 1000px;
	height: 150px;
	border: 1px solid #cccccc;
	margin-bottom: 10px;
}

.side {
	width: 150px;
	height: 500px;
	border: 1px solid #cccccc;
	float: left;
	margin-right: 10px;
}

.section {
	width: 840px;
	height: 500px;
	border: 1px solid #cccccc;
	float: left;
	margin-bottom: 10px;
}

.footer {
	width: 1000px;
	height: 150px;
	border: 1px solid #cccccc;
	clear: both;
}

.top1 {
	position: relative;
	width: 150px;
	height: 140px;
	border: 1px solid #cccccc;
	margin-top: 3px;
	margin-left: 3px;
	float: left;
}

.top2 {
	width: 830px;
	height: 140px;
	border: 1px solid #cccccc;
	margin-top: 3px;
	margin-left: 162px;
}

a {
	text-decoration: none;
}

.menuLink {
	position: relative;
	top: 80px;
	left: 20px;
	font-size: 12px;
	background-color: #e4effc;
	float: left;
	line-height: 30px;
	vertical-align: middle;
	text-align: center;
	width: 100px;
	list-style: none;
	border: 1px solid #ffffff;
}
</style>



<body>

	<div class="header">

		<div class="top1"> 로그 </div>

		<div class="top2">

			<ul>

				<li class="menuLink"><a href="#">홈</a></li>
				<li class="menuLink"><a href="#">게시판</a></li>
				<li class="menuLink"><a href="#">답변게시판</a></li>
				<li class="menuLink"><a href="#">회원가입</a></li>
				<li class="menuLink"><a href="#">로그인</a></li>
				<li class="menuLink"><a href="#">일정관리</a></li>
				<li class="menuLink"><a href="#">대화방</a></li>

			</ul>

		</div>

	</div>

	<div class="side">111</div>
	<div class="section"></div>
	<div class="footer"></div>

</body>

</html>

