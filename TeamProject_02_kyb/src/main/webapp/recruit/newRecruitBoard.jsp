<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	li{
		float: left;
		list-style: none;
		padding: 10px;
		cursor: pointer;
	}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style type="text/css">
	<style type="text/css">
	body{
	  margin: 0px;
	  font-family: '돋음', dotum, helvetica, sabs-serif
	  color: black;
	}
	nav{
	  height: 100px;
	  background-color: white;
	  display: flex;
	  justify-content: space-around;
	  align-items: center;
	}
	a{
	  color: black;
	  text-decoration: none;
	}
	
	a:hover{
	      color: #9400d3;
	}
	
  .wrap
    {
        width:100%;
        font-size:16px;
        font-weight:700px;
        margin-bottom: 16px;
   
    }
    .menubar
    {
        width:1024px;
        margin: 0 auto;
        border:none;
        background: white;
        overflow: hidden;
    }
    .menuLogo
    {	padding-top:35px;
    	margin:50px;
        width:100px;
        float:left;
    }
    
   .menuItem{
	    padding-bottom: 15px;
	    padding-top: 15px;
	    font-size: 16px;
	    font-weight:600;
	    float:right;
        padding: 20px 17px;
        margin-top: 70px;
	    
   }
    
  /* .menuItem
    {
        float:right;
        padding: 20px 17px;
    }*/
    .menubar ul
    {
        background: white;
        height:50px;
        list-style:none;
       
    }
    .menubar li
    {
        float:left;
    }
    .menubar a
    {
        color:black;
        display:block;
        font-weight: 700;
        line-height:49px;
        padding:1px 30px;
        text-align:center;
        text-decoration: none;
    }
    .menubar li:hover ul
    {
        display:block;
    }
	
    .menubar li:hover li a
    {
        background:none;
        text-decoration: none;
        color:black;
        text-align: left;
    }
    .menubar li ul
    {
        background-color: white;
		box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        display:none;
        height:auto;
        position:absolute;
        z-index:999;
    }
    .menubar li li a ,
    .menubar li li
    {
        background: white;
        display:block;
        float:none;
        min-width:100px;
        text-decoration: none;
    }
    .menubar li ul a
    {
        display:block;
        height:50px;
        font-weight: 400px;
        font-size:12px;
        padding:0px 15px 0px 15px;
        text-align:center;
        text-decoration: none;
     
    }
	.menubar li a:hover {
        background: white;
        color:#9400d3;
    }
   .menubar li ul a:hover,
   .menubar li ul li:hover a{
        background: white;
        border:0px;
        color:#9400d3;
    }
    
/*main{
    height: 1100px;
    background-color: white;
    
    display: flex;
    align-items: center;
    justify-content: center;
 }*/
 
 
 
 
 
 footer{
	  height: 480px;
	  background-color: white;
	  display: flex;
	  justify-content: center;
	}
footer a{
	text-decoration: none;
	color: black;
}
footer a:hover{
	color: #9400d3;
}
 .footer-first-space{
    max-width: 1170px;
    width: 100%;
    padding-top: 80px;
    padding-bottom: 30px;
 }
 
 .footer-seceond-space{
    display: flex;
    justify-content: space-between;
    height: 250px;
 }
.first-bigbox{
    width: 70%;
    display: flex;
    justify-content: space-between;
}
 .footer-subtitle{
    color: #919496;
    font-weight: 900;
    margin: 20px 0px;
}
.footer-menu-item{
    padding-bottom: 15px;
    padding-top: 3px;
    font-size: 16px;
    font-weight:600;
}
.footer-standard{
  display: flex;
    flex-direction: column;
    padding: 0 15px;
}
.character{
    width: 50%;
    display: flex;
    justify-content: flex-end;
}
.icon-box{
    width: 80px;
    height: 54px;
    background-color: white;
    border-radius: 50%;
    margin-right: 15px;
    display: flex;
    justify-content: center;
    align-items: center;
}
.icon {
  font-size: 24px;
}
.icon:hover {
  color: #9400d3;
}
.last-line{
   color: black;
   margin-top: 12px;
}
.last-space{
    margin-right: 24px;
    color: black;
 }
 
.country{
    color: black;
    display: flex;
    justify-content: center;
    font-size: 13px;
    font-weight: 600;
}
</style>
<script src="https://kit.fontawesome.com/bb9544ccb9.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		// 현재 날짜 가져오기
		var today = new Date();
		var year = today.getFullYear();
		var month = ('0'+(today.getMonth()+1)).slice(-2);
		var day = ('0'+today.getDate()).slice(-2);
		var todayDate = year+"/"+ month+"/"+day;
		
		// 채용게시판 가져오기
		$.ajax({
			url:"/TeamProject02/RecruitBoardList",
			success:function(arr){	
				$.each(arr,function(){
					var tr = $("<tr></tr>"); 
					var rbNo = $("<td></td>").html(this.rbNo);
					var rEndDate = $("<td></td>").html(this.rEndDate);
					if(this.rEndDate < todayDate){
						var rTitle = $("<td></td>").html("<a>"+this.rTitle+"</a>");	
						$(rEndDate).css("color","red");
					}else{
						var f = this.rTitle.charAt(0);
						if(f == "백"){
							var rTitle = $("<td></td>").html("<a href='newRecruitDetail1.jsp?rbNo="+this.rbNo+"'>"+this.rTitle+"</a>");	
						}else if(f == "네"){
							var rTitle = $("<td></td>").html("<a href='newRecruitDetail2.jsp?rbNo="+this.rbNo+"'>"+this.rTitle+"</a>");
						}
					}
					
					
					$(tr).append(rbNo,rTitle,rEndDate);
					$("#list").append(tr);
				});
			}
		});
	});
</script>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<!-- 메뉴바 시작 -->
<nav>
    <div class="wrap">
        <div class="menubar">
            <div class="menuLogo">
                <a href="mainPage.html"><img src="./image/grape1.png" width="170px"></a>
            </div>
            <ul class="menuItem">
                 <li>
                    <a href="">Introduction</a>
                    <ul>
                        <li><a href="companyInfo.jsp">회사소개</a></li>
                     
                    </ul>
                 </li>
                
                 <li>
                    <a href="">Portfolio</a>
                    <ul>
                        <li><a href="portpolio.jsp">포트폴리오</a></li>
                    </ul>
                 </li>
                
                  <li>
                    <a href="">Connect</a>
                    <ul>
                        <li><a href="newOrder.jsp">신규문의</a></li>
                        <li><a href="oldOrderLogin.jsp">기존문의</a></li>
                    </ul>
                  </li>
                
                   <li>
                    <a href="">Recruitment</a>
                    <ul>
                        <li><a href="newRecruitBoard.jsp"> 신규채용</a></li>
                        <li><a href="myRecruitLogin.jsp">나의 지원서</a></li>
                    </ul>
                  </li>
            </ul>
        </div>
    </div>
</nav>
<!-- 메뉴바 끝 -->	


<!-- 메인창 시작 -->

<div class="container">
<h1>채용공고</h1>
	<div id="RecruitBoard" class="table table-hover text-center">
		<table class="table">
			<thead>
	        	<tr class="table-dark">
	            	<th width="20%">번호</th>
	            	<th>제목</th>
	            	<th>마감일</th>
	        	</tr>
	        </thead>
	        <tbody id="list">
	        </tbody>
	    </table>
	</div>
</div>

<!-- 메인창 끝 -->

<!-- 하단바 시작 -->
<footer>
 
 <div class="footer-first-space">
   <div class="footer-seceond-space">
    
   <div class="first-bigbox">
    
   <div class="footer-standard">
     <img src="" width="132px">
   </div>
      
    <div class="footer-standard">
	  <div class="footer-subtitle">Company</div>
		  <a href="companyInfo.jsp"class="footer-menu-item">About Us</a>  
		  <a href="portpolio.jsp"class="footer-menu-item">History</a>
    </div>
      
    <div class="footer-standard">
      <div class="footer-subtitle">Communicates</div>
		  <a href="newOrder.jsp" class="footer-menu-item">Question</a>
		  <a href="https://www.instagram.com"class="footer-menu-item">Instagram</a>
    </div>
    
    <div class="footer-standard">
      <div class="footer-subtitle">Recruitment</div>
		  <a href="myRecruitLogin.jsp"class="footer-menu-item">My application</a>
    </div>
 </div>
    
  <div class="character">
	  <div class="icon-box">
 		 <a href="mainPage.html">
     	 <i class="fa-solid fa-house icon"></i></a>
      </div>  

      <div class="icon-box">
      	<a href="#">
     	 <i class="fa-solid fa-square-phone icon"></i></a>
      </div>
      
      <div class="icon-box">
     	 <a href="https://www.instagram.com">
     	 <i class="fab fa-instagram icon"></i></a>
      </div>
      
  </div>
 </div>
 
<div class="country">
  <div class="last-line"> 
   <div>
     <span class="last-space">Phone : 031-000-0000</span>
 	 <span class="last-space">Address : 서울특별시 마포구 서교동 447-5 풍성빌딩 F2,3,4</span>
   </div>
  </div>
</div>

 </div>

</footer>
<!-- 하단바 끝 -->	
</body>
</html>