<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	$(function(){
		$(document).on("click","#port",function(){
			$("#selected").val("");
			window.open("newOrderPortfolio.jsp","selectport","width=470, height=500");
		})
		
		$(document).on("click","#addr",function(){
			$("#addrSelected").val("");
			new daum.Postcode({
		        oncomplete: function(data) {
		        	console.log("�˻��Ϸ�"+data.address);
		            $("#addrSelected").val(data.address);
		        }
		    }).open();
		})		
	});
</script>
</head>
<body>
	<button id="port">��Ʈ������ ����</button><br>
	���õ� ��Ʈ������: <input type="text" id="selected"><br>
	
	<button id="addr">�ּҰ˻�</button><br>
	�ּ�: <input type="text" id="addrSelected">
</body>
</html>