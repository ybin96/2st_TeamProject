<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	$(function() {
	    /*$( "#testDatepicker" ).datepicker({
	    	changeMonth: true, 
	        dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
	        dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
	        monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
	        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	        beforeShowDay: function(date){
				var day = date.getDay();
				return [(day != 5 && day != 6)];
			},
	        onSelect: function(selectedDate){
	       		$("#time").removeClass("timeHidden");
	        	$("#time").addClass("timeShow");
	         },
	         timeFormat:'HH:mm:ss',
		        controlType:'select',
				oneLine:true,
	    });*/
	    $.datetimepicker.setLocale('kr');
	    $(".datetimepicker").datetimepicker({ 
	    	lang:"ko",
	    	format: "Y-m-d H:i",
			changeMonth: true,
			allowTimes: [
				'12:00','13:00'
			],
	        beforeShowDay: function(date){
				var day = date.getDay();
				return [(day != 5 && day != 6)];
			},
	        onSelect: function(selectedDate){
	       		$("#time").removeClass("timeHidden");
	        	$("#time").addClass("timeShow");
	         },
		});
	    
	    $("#testDatepicker").click(function(){
	    	 $("#time").removeClass("timeShow");
        	 $("#time").addClass("timeHidden");
	    });
	    
	    $("#btn_add").click(function(e){
	    	e.preventDefault();
	    	var date = "";
	    	date += $("#testDatepicker").val();
	    	console.log(date);
	    	$("#date").val(date);
	    	$("#f").trigger("submit");
	    });
	    
	    $("#f").submit(function(e){
	    	e.preventDefault();
	    	var data =$(this).serializeArray();
	    	$.ajax({
	    		url:"/TeamProject02/DateTest",
	    		data,data,
	    		success:function(re){
	    			if(re>0){
	    				alert("전송 성공");
	    			}else{
	    				alert("전송 실패");
	    			}
	    		}
	    	})
	    });
	});
</script>
</head>
<body>
	<form action="" id="f">
	<input type="text" class="datetimepicker" id="testDatepicker" name="date" autocomplete="off"><br>
	cNo: <input type="text" name="aNo"><br>
	date: <input type="text" name="finalDate" id="date"><br>
	<button id="btn_add">선택</button>
	</form>
	
</body>
</html>