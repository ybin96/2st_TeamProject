<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 채용</title>
<style type="text/css">
 	*{
 
 		margin: 5px;
 	}
 	
 	#loginArea{
 		border: 1px solid;
 		padding: 10px;
 		margin: 10px;
 		width: 300px;
 		height: 300px;
 		position: center;
 	}
 	.radio_div{
 		display: inline;
 	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
</head>
<body>
	<h1>나의 채용 확인하기</h1>
	<div class="insert" id="loginArea">
		<form action="LoginCheck.do">
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
				
				<input type="submit" class="btn btn-primary" value="로그인">
			</div>
		</form>
	</div>
</body>
</html>