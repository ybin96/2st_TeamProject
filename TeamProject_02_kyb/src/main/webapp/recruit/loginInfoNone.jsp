<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#relogin").click(function(){
			console.log("zz");
			location.href="myRecruitLogin.jsp";
		});
	})
</script>
</head>
<body>
	<h1>지원서를 넣은 사용자가 아닙니다.</h1>
	<button id="relogin">다시 로그인하기</button>
	<button id="gotoBoard">채용공고게시판으로가기</button>
</body>
</html>