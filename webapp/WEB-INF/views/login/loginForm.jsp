<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">

<script>   
	window.onload = function () {
	   var  frm = document.getElementById('frm');
	   // 클라이언트 validation 
	   frm.onsubmit =  function () {
		   var email = document.querySelector('[name=email]');
		   if( email.value.trim() =='' ) {
			   alert('이메일을 입력하세요')
		   	   return false;  // 이벤트 취소
		   }
		   var password = document.querySelector('[name=password]');
		   if( password.value.trim() =='' ) {
			   alert('비밀번호를 입력하세요')
		   	   return false;  // 이벤트 취소
		   }
		   return true
	   }
	}
</script>

<style>
	div.main1 { background-color : gray;
	
				border  : 1px solid black;
				margin  : 200px 800px 0 750px;
				padding : 0 0 200px 0; 
				box-shadow: 5px 5px black;
				}
	div.main2 { text-shadow: 5px 5px black;
				color : white;
				 }
	div.main3 {	padding : 100px 0 0 0;
				text-align: center;
				color: white; 
	} 
	div.main4 {position: absolute;
				bottom : 350px;
				margin-left: 110px;
				color: white;
	}
	h1 { text-align: center;
		 font-family: 'Dancing Script', cursive;}
</style>

</head>
<body>
	<form  action="/loginProcess" method="POST" id="frm">
		<div class="main1">
	 	<div class="main2">
   			<h1>InstaMilligram</h1>
   		</div>
   		<div class="main3">
   			이메일<input type="text" name="email" /><br> <br>
   			비밀번호<input type="text" name="password" /><br>
   		</div>
   		<div class="main4">
   			<a href="/WriteForm">회원 가입</a>
   			<input type="submit" value="로그인">
   	 	</div>
   		</div>
   </form>
</body>
</html>