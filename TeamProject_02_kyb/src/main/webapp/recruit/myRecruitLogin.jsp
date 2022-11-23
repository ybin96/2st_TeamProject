<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 채용</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="../infobar.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://kit.fontawesome.com/bb9544ccb9.js" crossorigin="anonymous"></script>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- 메뉴바 시작 -->
 <jsp:include page="../menu_header.jsp" flush="false"/>
<!-- 메뉴바 끝 -->	

<!-- 메인창 시작 -->
	
	<div style="margin:100px 100px 100px 100px;">
	<div class="container">
	<h1>나의 채용 확인하기</h1>
	<br>
	<div class="insert" id="loginArea">
		<form action="LoginCheck.do" method="post">
			<div class="form-group">
				<label for="aname">이름</label>
				<input type="text" id="aname" name="aname" class="form-control"><br>
			</div>
			<div class="form-group">
				<div class="radio_div">
				  <input type="radio" id="radio_email" name="radio" value="0" checked>
				  <label class="custom-control-label" for="customRadioInline1">이메일</label>
				</div>
				<div class="radio_div">
				  <input type="radio" id="radio_phone" name="radio" value="1">
				  <label class="custom-control-label" for="customRadioInline2">전화번호</label>
				</div>
				<input type="text" id="info" name="info" class="form-control"><br>
				
				<input type="submit" class="btn btn-dark" value="로그인" style="background-color: #9400d3">
			</div>
		</form>
	</div>
</div>
</div>
<!-- 메인창 끝 -->

<!-- 하단바 시작 -->
	<jsp:include page="../menu_footer.jsp" flush="false"/>
<!-- 하단바 끝 -->	

</body>
</html>