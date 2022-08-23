<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
<style>
	div.main1 { background-color : gray;
				border  : 1px solid black;
				margin  : 100px 800px 0px 750px;
				padding : 0 0 200px 0; 
				box-shadow: 5px 5px black;
				}
	div.main2 { text-shadow: 5px 5px black;
				color : white;
				 }
	div.main3 {	padding : 30px 0 0 0;
				text-align: center;
				color: white; 
	} 
	div.main4 { position: absolute;
				bottom : 200px;
				margin-left: 125px;
				color: white;
	}
	div.main5 { text-align: left;
				margin : 0 0 0 90px;
				width: 120px;
	}
	h1 { text-align: center;
		 font-family: 'Dancing Script', cursive;
	}
	#main5 input {  display: inline-block;
   					
	}
</style>

<script  src="https://code.jquery.com/jquery-3.6.0.min.js"></script>  

<script>
function CheckEmail(str) {                                                 
     var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
}
</script>
<script>  

	window.onload = function () {
		// 닉네임 중복확인
		var nickChk = document.getElementById("nickChk");
		nickChk.onclick = function (e) {
			e.preventDefault();
			e.stopPropagation();
			$.ajax({
				url : "/user/nickChk",
				type : "get",
				dataType : "json",
				data : {"nickname" : $("#nickname").val()},
				success : function(data) {
					if(data == 1) {
						alert("사용중인 닉네임입니다");
					} else if(data == 0) {
						$("#nickChk").attr("value", "Y");
						alert("사용가능한 닉네임입니다")
					} 
				}
			})
		}
		
		
	    // 이메일 중복확인
	    var idChk = document.getElementById('idChk');
	    idChk.onclick = function (e) {
	    	e.preventDefault();
	    	e.stopPropagation();
	    	$.ajax({
	    		url : "/user/idChk",  // id 중복체크 하는 controller url
	    		type : "get",
	    		dataType : "json",
	    		data : {"email" : $("#email").val()},
	    		success : function(data) {
	    			if(data == 1) {
	    				alert("사용중인 이메일입니다");
	    			} else if(data == 0) {
	    				$("#idChk").attr("value", "Y");
	    				alert("사용가능한 이메일입니다")
	    			} 
	    		}
	    	})
	    	
	    }
		
		// frm  tag 의 입력체크 
		var  frm = document.getElementById('frm');
	   // 클라이언트 validation 
	   frm.onsubmit =  function () {
		   var email = document.querySelector('[name=email]');
		   //var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
		   
		   if( email.value.trim() =='' ) {
			   alert('이메일을 입력하세요')
		   	   return false;  // 이벤트 취소
		   } 
		   var nickname = document.querySelector('[name=nickname]');
		   if( nickname.value.trim() =='' ) {
			   alert('닉네임을 입력하세요')
		   	   return false;  // 이벤트 취소
		   }
		   var password = document.querySelector('[name=password]');
		   if( password.value.trim() =='' ) {
			   alert('비밀번호를 입력하세요')
		   	   return false;  // 이벤트 취소
		   }
		   var password = document.querySelector('[name=password]');
		   var passwordConfrim = document.getElementById('passwordConfrim');
		   
		   if( passwordConfrim.value.trim() =='' ) {
			   alert('비밀번호 확인을 입력하세요')
		   	   return false;  // 이벤트 취소
		   } else if ( password.value != passwordConfrim.value ) {
			   alert('비밀번호가 같지않습니다')
			   return false;
		   }
	   
		   var name = document.querySelector('[name=name]');
		   if( name.value.trim() =='' ) {
			   alert('이름을 입력하세요')
		   	   return false;  // 이벤트 취소
		   }
		   var tel = document.querySelector('[name=tel]');
		   if( tel.value.trim() =='' ) {
			   alert('전화번호를 입력하세요')
		   	   return false;  // 이벤트 취소
		   }
		   
		   alert('회원가입 완료!')
		   return true
	   }
	}

</script>


</head>
<body>
	<div class="main1">
	<div class="main2">
  		<h1>InstaMilligram</h1>
  	</div>

    <form  action ="/Write"  method="POST"  id="frm" >
  	<div class="main3">
  		<h2>회원가입</h2>
	  	<div class="main5">
	     	이메일	<input type="text" name="email" id="email" /><br>
	     	<button class="idChk"  name="idChk" id="idChk" >중복확인</button><br>
	     	 
	     	닉네임	<input type="text" name="nickname" id="nickname" /><br>
	     	<button class="nickChk"  name="nickChk" id="nickChk" >중복확인</button><br> 
	     	
	     	비밀번호<input type="text" name="password" /><br>
	     	비밀번호 확인<input type="text" name="passwordConfrim" id="passwordConfrim"  onkeyup="passConfrim()"> <span id ="confirmMsg"></span>
	     	이름	<input type="text" name="name" /><br>
	     	전화번호<input type="text" name="tel" /><br>
	     </div>
     </div>
     
     <div class="main4">
     	<input type="submit" value="가입" /> 
     	<a href="/logout">취소</a> 
     	<!--  <input type="button" value="취소" /> --> 
     </div>
   </div>
   
   </form>
   
</body>
</html>















