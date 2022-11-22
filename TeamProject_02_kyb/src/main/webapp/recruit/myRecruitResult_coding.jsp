<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function(){
	$(document).on("click","#test",function(e){
		//e.preventDefault();
		$("#selected").val("");
		window.open("/TeamProject02/calendar.jsp","selectport","width=470, height=500");
	});
	
	$.ajax({
		
	});
	
});
	
</script>
</head>
<body>

<!-- 메뉴창 시작  -->
<hr>
menu
<hr>
<!-- 메뉴창 끝  -->

<!-- 메인창 시작  -->
<div class="container">
	<div class="text center">
		<img src="/TeamProject02/images/grape.png" width="100%" height="180px;">
	</div>
	<br>
	<br>
	<div>
		<h2><strong>${title} (2022년 지원)</strong></h2>				
		<h4>[결과 및 면접 진행 안내]</h4>
	</div>
	
	<div>
		<p>안녕하세요.  ${name }님 <br>grape 인재영입담당자입니다.</p>
		<br>
		
		<h4><strong>${title} 코딩테스트전형 합격을 진심으로 축하드립니다!</strong></h4>
		<br>
			
		<p> 다음으로 면접이 진행될 예정이며 아래에서 면접 가능한 날짜와 시간을 선택해주시길 바랍니다.</p>
	</div>
	
	<button id="test">달력</button>

</div>





<!-- 메인창 끝  -->
		
<!-- 하단창 시작  -->
<!-- 하단창 끝  -->

</body>
</html>