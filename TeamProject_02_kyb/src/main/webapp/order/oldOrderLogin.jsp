<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#oldOrderLogin span{
		width: 200px;
		display: inline-block;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#oldOrderLogin").submit(function(){
			$.ajax({
				url:"",
				success:function(r){
					var cNo="";
					if(r != ""){
						alert("로그인 성공");
						//액션 통해서 페이지 옮겨도 됩니다.
						location.href("oldOrder.jsp?cNo="+cNo);
					}else{
						alert("로그인 실패");
						$("#cCode").empty();
					}
				}
			})
		})
	});
</script>
</head>
<body>
	<form action="" id="oldOrderLogin">
		<span>업체명  :</span> <input type="text" id="cName" name="cName"><br>
		<span>암호나 식별용 코드:</span> <input type="text" id="cCode" name="cCode"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>